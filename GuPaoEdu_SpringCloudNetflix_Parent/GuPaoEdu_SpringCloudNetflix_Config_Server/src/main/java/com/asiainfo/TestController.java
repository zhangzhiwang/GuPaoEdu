package com.asiainfo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
//	@Value("${student.name}")
	private String name;
	
	@GetMapping("/test1")
	public String test1() {
		return name;
	}
}