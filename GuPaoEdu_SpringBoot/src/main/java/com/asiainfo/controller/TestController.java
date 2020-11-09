package com.asiainfo.controller;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.asiainfo.entity.User;
import com.asiainfo.service.UserService;

@RestController
public class TestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);
	
	@Value("${user.userName}")
	private String userName;
	@Autowired
	private User user;
	@Autowired
	private UserService userService;
	
	@GetMapping("/test1")
	public String test1() {
		System.out.println(user);
		
		LOGGER.debug("controller debug");
		LOGGER.info("controller info");
		LOGGER.error("controller error");
		
		userService.testService1();
		return userName;
	}
	
	@PostMapping("/upload")
	public void upload(MultipartFile multipartFile) throws IllegalStateException, IOException {
		multipartFile.transferTo(new File("/Users/zhangzhiwang/Desktop/" + multipartFile.getOriginalFilename()));
	}
}
