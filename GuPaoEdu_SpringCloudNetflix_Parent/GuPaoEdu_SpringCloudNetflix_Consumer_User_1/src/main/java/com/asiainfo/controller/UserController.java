package com.asiainfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.converters.Auto;
//import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@RequestMapping("user")
//@DefaultProperties(defaultFallback = "fallBackTest")// 如果该类的所有方法可以共用一个降级方法并且降级策略都一样，那么没有必要在每个方法的注解@HystrixCommand后面设置参数了（注意：需要降级的方法还是得加@HystrixCommand注解，只不过不用写参数了），在类上加@DefaultProperties注解并统一设置参数即可即可
public class UserController {
	/**
	 * RestTemplate是Spring提供的用于访问Rest服务的客户端，它提 供了很多可以方便方位远程http服务的方法，这些方法可以减少 开发人员在编写客户端代码的工作量。
	 */
	@Autowired
	private RestTemplate restTemplate;// 在没有使用feign的情况下，可以使用Spring提供的原生调用http服务的API——RestTemplate。注意：RestTemplate不是spb提供的接口类，而是Spring原生的。
									  // 打开RestTemplate的源码可以看到该类并没有被任何注解标注为一个Bean，所以@Autowired肯定注入不进来，必须手动声明它为一个Bean
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;// 注意：使用LoadBalancerClient必须将RestTemplate的@LoadBalanced注解去掉，否则
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@GetMapping("/userTest1")
	public String userTest1() {
		/**
		 * 1、uri指定的不是目标服务的ip和port，而是服务提供者的服务名，eureka会根据这个服务名找到对应的服务提供者列表然会给调用者
		 * 2、调用者通过负载均衡机制从服务者列表中选择其一进行调用，这就是上面的@LoadBalanced的作用
		 * 3、eureka-client依赖内置了Ribbon负载均衡器，所以引入eureka-client依赖后无需显式引入Ribbon依赖，且Ribbon负载均衡器的使用不需要额外的配置和注解
		 * 4、Ribbon负载均衡器的默认算法是轮询
		 */
		String result = restTemplate.getForObject("http://GuPaoEdu-SpringCloudNetflix-Provider-Product/product/test1", String.class);
		return result;
	}
	
	@GetMapping("/userTest2")
	public String userTest2() {
		ServiceInstance instance = loadBalancerClient.choose("GuPaoEdu-SpringCloudNetflix-Provider-Product");// 参数是服务提供者的应用名称
		String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/product/test1";
		String result = restTemplate.getForObject(url, String.class);
		return result;
	}
	
//	@HystrixCommand
//	@HystrixCommand(fallbackMethod = "fallBackTest",// 降级方法
//			commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),// 设置超时时间。@HystrixCommand注解的属性commandProperties的类型也是一个注解，所以使用@HystrixProperty
//			/**
//			 * hystrix的熔断策略：默认情况下hystrix在10s接收20个请求，如果这20个请求有50%的调用失败就会出发hystrix断路器打开（open状态），阻断所有请求5秒钟，在这5秒内所有请求都会降级。
//			 * 5秒过后hystrix进入半开状态（half-open）允许一部分请求通过，如果这部请求响应成功则断路器完全关闭（close状态）这是所有请求可以全部通过；如果请求失败断路器会重新回到打开状态。
//			 * 上面这些阈值（10秒、20个请求、50%、5秒）都是hystrix的默认值，可以在com.netflix.hystrix.HystrixCommandProperties里面找到。
//			 */
//			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3"),// 设置请求个数阈值，默认是20个
//			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 断路器打开时长，默认是5s
//			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "10"),// 错误请求比例，默认为50%
//			/**
//			 * 隔离策略有两种：
//			 * 1、线程池隔离。线程池隔离就是将不用的业务放到不同的线程池里面，每个服务的调用链路都在自己的线程池里面进行，一旦某个联储出现问题影响的是本线程池的服务，不会影响其他线程池的服务，防止整个系统的雪崩。
//			 * 2、信号量。设置一个系统容忍的醉倒并发量，超过这个并发量之后会拒绝。
//			 */
//			@HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE")
//			})
	@GetMapping("/userTest3/{num}")
	public String userTest3(@PathVariable("num") int num) {
		if(num % 2 == 0) {
			return "成功";
		}
		
		String result = restTemplate.getForObject("http://GuPaoEdu-SpringCloudNetflix-Provider-Product/product/test1", String.class);
		return result;
	}
	
	public String fallBackTest(int num) {// 降级方法的入參和返回值类型必须和原方法一致，名称和原方法的@HystrixCommand注解的fallbackMethod属性一致
		return "【默认】服务降级了";
	}
}
