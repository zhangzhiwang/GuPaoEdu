package com.asiainfo.controller;

import javax.annotation.Resource;

import com.asiainfo.annotation.ZzwAutowired;
import com.asiainfo.annotation.ZzwComponent;
import com.asiainfo.annotation.ZzwRequestMapping;
import com.asiainfo.service.IHelloService;
import com.asiainfo.service.IStudentService;
import com.asiainfo.service.ITestService;
import com.asiainfo.service.impl.HelloServiceImpl;

@ZzwComponent
@ZzwRequestMapping(value = "/test")
public class TestController {
	@ZzwAutowired
	private ITestService testService;
//	@ZzwAutowired
//	private IStudentService studentService;
	@Resource(name = "helloBean")
//	@Resource(type = HelloServiceImpl.class)
//	@Resource(name = "helloBean", type = HelloServiceImpl.class)
	private IHelloService helloService;
	
	@ZzwRequestMapping("test1")
	public String test1(String s) {
		return testService.test(s);
	}
	
	@ZzwRequestMapping("test2")
	public String test2(String s) {
		return helloService.hello(s);
	}
}

