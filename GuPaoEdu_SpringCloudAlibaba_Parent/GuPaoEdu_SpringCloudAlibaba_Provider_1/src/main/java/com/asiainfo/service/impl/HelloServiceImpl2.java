package com.asiainfo.service.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Service;

import com.asiainfo.service.api.IHelloService;

@DubboService(version = "2",registry = {"shanghai"})// 新服务注册到名称为“shanghai”的注册中心
public class HelloServiceImpl2 implements IHelloService {

	public String hello() {
		return "Hello World!	新服务";
	}
}
