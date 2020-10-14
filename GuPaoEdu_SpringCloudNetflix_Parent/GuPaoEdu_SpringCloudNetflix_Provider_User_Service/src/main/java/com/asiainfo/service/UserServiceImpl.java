package com.asiainfo.service;

import org.springframework.web.bind.annotation.RestController;

import com.asiainfo.entityTest.User;
import com.asiainfo.service.interfaceTest.IUserService;

@RestController
public class UserServiceImpl implements IUserService {

	public String getUser(User user) {
		System.out.println(user);
		return "ok";
	}
}
