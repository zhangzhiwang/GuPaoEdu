package com.asiainfo.service.impl;

import com.asiainfo.service.api.IHelloService;

public class HelloServiceImpl implements IHelloService {

	@Override
	public String hello(String s) {
		return "Hello!My name is " + s + ".";
	}
}
