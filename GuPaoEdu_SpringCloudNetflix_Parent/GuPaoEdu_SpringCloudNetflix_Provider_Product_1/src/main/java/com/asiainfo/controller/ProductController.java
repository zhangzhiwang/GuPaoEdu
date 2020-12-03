package com.asiainfo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
@RefreshScope
public class ProductController {
	@Value("${product1.name}")
	private String name;
	
	@Value("${common.name}")
	private String common;
	
	@GetMapping("/test1")
	public String test1() {
		return name + "----" + common;
	}
}