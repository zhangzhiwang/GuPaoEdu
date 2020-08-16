package com.asiainfo.controller;

import org.apache.catalina.User;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.common.Constants;
import com.asiainfo.service.api.IHelloService;
import com.asiainfo.service.api.IUserService;

@RestController
@RequestMapping("helloController")
public class HelloController {
//	@Reference// 注意这里是ali的@Reference，不是jdk的
//	@DubboReference(version = "1")// 在新版本的dubbo中，为了和jdk的@Reference注解区分开提供一个@DubboReference的注解
	private IHelloService helloService;
//	@DubboReference(version = "2", registry = {"shanghai"})// 模拟两个客户端，一个调用老服务（version = "1"）一个调用新服务（version = "2"）
	private IHelloService helloService2;
	/**
	 *  dubbo配置的优先级：
	 *  1、方法级别的配置优先级高于接口级的配置
	 *  2、消费者的配置优先级高于生产者的配置
	 *  3、系统变量（JVM启动参数）优先级 > 外部化配置优先级 > API（用代码进行配置）优先级 > 本地配置文件优先级 
	 */
	@DubboReference(protocol = "dubbo", // 在服务提供者里面protocol属性可以写在配置文件里面配置的协议id（自定义的），但是在消费者里面protocol属性的值必须是协议的名称，不能是自定义协议的id
			registry = {"beijing"}, // 当生产者想多个注册中心注册了该服务，但是消费者在消费时没有指定到哪哥注册中心获取服务，那么dubbo会对多个注册中心进行负载，最终将消费者的请求转向某一个注册中心。可以在配置里对注册中心的负载进行干预，比如设置权重（weight）或者区域优先（zone）或者优先选择（preferred）
			loadbalance = "roundrobin", // netflex里面的ribbon默认负载均衡策略是轮询，dubbo和它不一样，dubbo的默认负载均衡策略是随机
			mock = "com.asiainfo.service.UserServiceFallback",// 服务降级，当目标服务调用失败时会调用mock参数配置的类的方法
			cluster = "failfast",// 集群容错策略，默认是failover（失败重试），这里使用的是failfast（快速失败，即失败直接报错不会进行重试）
			timeout = 500,// 消费者的超时时间，单位ms
			check = false// 启动检查，启动时检查目标服务是否已在注册中心注册，如果没有则启动失败，如果不进行检查当目标服务不可用时仍然能启动成功
			)
	private IUserService userService;
	
//	@DubboReference(interfaceName = "com.asiainfo.service.ITestService", generic = true, protocol = "dubbo")
	// dubbo泛化：当生产者提供的服务接口没有放到api工程里，导致消费者无法引用到接口类，这时可以使用泛化，如果接口的如餐是一个实体类，那么要消费者要使用Map构造出实体类的结构来传参
//	private GenericService genericService;
	
//	@GetMapping("/hello")
//	public String hello() {
//		return helloService.hello();
//	}
	
//	@GetMapping("/hello2")
//	public String hello2() {
//		return helloService2.hello();
//	}
	
	@GetMapping("/getUserById")
	public String getUserById() {
		return userService.getUserById("1");
	}
	
//	@GetMapping("/test")
//	public String test() {
//		return (String) genericService.$invoke("test", new String[] {"java.lang.Integer"}, new Object[]{123});
//	}
}
