package com.asiainfo.service;

import org.springframework.stereotype.Service;

import com.asiainfo.entityTest.User;
import com.asiainfo.service.interfaceTest.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	public String getUser(String s) {
		int i = 1 / 0;
		System.out.println(s);
		return "ok";
	}

	public String insertUser(User user) {
		int i = 1 / 0;
		System.out.println(user);
		return "insert success";
	}
}
