package com.asiainfo.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asiainfo.config.MySwaggerConfig;

@Controller
@RequestMapping("swagger")
public class SwaggerController {
	@GetMapping("/test1")
	public String test1() {
		System.out.println("test1...");
		return "/index.jsp";
	}
	
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
		Object bean = app.getBean(MySwaggerConfig.class);
		System.out.println(bean);
	}
}
