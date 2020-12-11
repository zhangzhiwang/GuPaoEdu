package com.asiainfo.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
@RefreshScope
public class ProductController {
	@Value("${product1.name}")
	private String name;
	
//	@Value("${common.name}")
	private String common;
	
	@GetMapping("/test1")
	public String test1() throws Exception {
//		throw new RuntimeException("测试异常");
//		return name + "----" + common;
		
//		Thread.sleep(2000);
		
//		int i = 1 / 0;
		
		return "product_1";
	}
	
	@GetMapping("/test2")
	public void test2(HttpServletRequest request) {
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			System.out.println(headerNames.nextElement());
		}
		System.out.println("-----------");
		System.out.println("newparam : " + request.getHeader("newparam"));
	}
}