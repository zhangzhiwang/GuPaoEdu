package com.asiainfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.asiainfo.entityTest.User;
import com.asiainfo.service.IServiceFeign;
import com.asiainfo.service.interfaceTest.IUserServiceFeign;
import com.netflix.discovery.converters.Auto;

@RestController
@RequestMapping("userWithFeign")
public class UserControllerFeign {
//	@Autowired// 注意：IServiceFeign标注了@FeignClient注解但是并没有声明为一个Bean，所以直接@Autowired会报Bean找不到，必须在启动类使用注解@EnableFeignClients
//	private IServiceFeign serviceFeign;
	
	@Autowired
	private IUserServiceFeign userServiceFeign;
	
//	@GetMapping("/testFeign")
//	public String testFeign() {
//		return serviceFeign.testFeign();
//	}
	
	@GetMapping("/testFeign2")
	public String testFeign2() {
		return userServiceFeign.getUser(new User(18));
	}
}
