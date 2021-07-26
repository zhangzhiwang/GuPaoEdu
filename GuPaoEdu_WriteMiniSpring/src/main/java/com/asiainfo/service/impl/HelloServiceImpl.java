package com.asiainfo.service.impl;

import com.asiainfo.annotation.ZzwComponent;
import com.asiainfo.service.IHelloService;

@ZzwComponent(value = "helloBean")
public class HelloServiceImpl implements IHelloService {

	@Override
	public String hello(String s) {
		
		return "Hello " + s;
	}

}
