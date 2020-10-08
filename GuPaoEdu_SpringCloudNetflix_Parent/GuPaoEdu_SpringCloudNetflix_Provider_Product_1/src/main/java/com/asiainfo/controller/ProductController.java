package com.asiainfo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {
	@GetMapping("/test1")
	public String test1() {
		return "product_1";
	}
}
