package com.asiainfo.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.service.api.IHelloService;

@RestController
@RequestMapping("helloController")
public class HelloController {
	@Reference// 注意这里是ali的@Reference，不是jdk的
	private IHelloService helloService;
	
	@GetMapping("/hello")
	public String hello() {
		return helloService.hello();
	}
}
