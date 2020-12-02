package com.asiainfo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {
//	@Value("${product1.name}")
	private String name;
	
	@GetMapping("/test1")
	public String test1() {
		return name;
	}
}