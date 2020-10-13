package com.asiainfo.service.interfaceTest;

import org.springframework.web.bind.annotation.GetMapping;

import com.asiainfo.entityTest.User;

public interface IUserService {
	@GetMapping(value = "/getUser", consumes = {"application/json"})
	String getUser(User user);
}
