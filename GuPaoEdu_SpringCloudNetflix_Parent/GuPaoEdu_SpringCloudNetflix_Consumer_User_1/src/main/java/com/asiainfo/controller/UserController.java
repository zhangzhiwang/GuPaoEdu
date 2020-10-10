package com.asiainfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private RestTemplate restTemplate;// 在没有使用feign的情况下，可以使用Spring提供的原生调用http服务的API——RestTemplate。注意：RestTemplate不是spb提供的接口类，而是Spring原生的。
									  // 打开RestTemplate的源码可以看到该类并没有被任何注解标注为一个Bean，所以@Autowired肯定注入不进来，必须手动声明它为一个Bean
	
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
}
