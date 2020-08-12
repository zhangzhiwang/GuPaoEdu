package com.asiainfo.service.impl;

import org.apache.dubbo.config.annotation.Service;

import com.asiainfo.service.api.IHelloService;

@Service// 注意要使用阿里的@Service注解，而不是Spring的
public class HelloServiceImpl implements IHelloService {

	public String hello() {
		return "Hello World!";
	}
}
