package com.asiainfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.asiainfo.entity.User;
import com.asiainfo.service.IUserService;

@Controller
//@Service
public class UserController {
	@Autowired
	private IUserService userService;
	
	public User queryUser() {
		return userService.queryUser();
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}
