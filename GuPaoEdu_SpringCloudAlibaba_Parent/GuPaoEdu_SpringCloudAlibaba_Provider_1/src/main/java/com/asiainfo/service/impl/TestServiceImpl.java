package com.asiainfo.service.impl;

import org.apache.dubbo.config.annotation.DubboService;

import com.asiainfo.service.ITestService;

@DubboService(protocol = { "protocal_1" }, registry = { "beijing" })// protocol属性的值可以是配置文件里面配置的协议id（比如本工程配置的protocal_1或protocal_2），也可以是具体协议的名称（比如dubbo或rest），这两种方式都能识别
public class TestServiceImpl implements ITestService {

	public String test(Integer id) {
		return id + "";
	}

}
