package com.asiainfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.entity.User;

@RestController
public class TestController {
	@Value("${user.userName}")
	private String userName;
	@Autowired
	private User user;
	
	@GetMapping("/test1")
	public String test1() {
		System.out.println(user);
		return userName;
	}
}
