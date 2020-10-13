package com.asiainfo.service;

import com.asiainfo.entityTest.User;
import com.asiainfo.service.interfaceTest.IUserService;

public class UserServiceImpl implements IUserService {

	public String getUser(User user) {
		System.out.println(user);
		return "ok";
	}
}
