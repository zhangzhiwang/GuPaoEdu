package com.asiainfo.controller;

import org.apache.catalina.User;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.service.api.IHelloService;
import com.asiainfo.service.api.IUserService;

@RestController
@RequestMapping("helloController")
public class HelloController {
//	@Reference// 注意这里是ali的@Reference，不是jdk的
	@DubboReference(version = "1")// 在新版本的dubbo中，为了和jdk的@Reference注解区分开提供一个@DubboReference的注解
	private IHelloService helloService;
	@DubboReference(version = "2", registry = {"shanghai"})// 模拟两个客户端，一个调用老服务（version = "1"）一个调用新服务（version = "2"）
	private IHelloService helloService2;
	@DubboReference// 当生产者想多个注册中心注册了该服务，但是消费者在消费时没有指定到哪哥注册中心获取服务，那么dubbo会对多个注册中心进行负载，最终将消费者的请求转向某一个注册中心。可以在配置里对注册中心的负载进行干预，比如设置权重（weight）或者区域优先（zone）或者优先选择（preferred）
	private IUserService userService;
	
	@GetMapping("/hello")
	public String hello() {
		return helloService.hello();
	}
	
	@GetMapping("/hello2")
	public String hello2() {
		return helloService2.hello();
	}
	
	@GetMapping("/getUserById")
	public String getUserById() {
		return userService.getById(1);
	}
}
