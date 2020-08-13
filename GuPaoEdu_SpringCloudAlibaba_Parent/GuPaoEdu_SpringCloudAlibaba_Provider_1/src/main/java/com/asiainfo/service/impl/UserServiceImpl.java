package com.asiainfo.service.impl;

import org.apache.dubbo.config.annotation.DubboService;

import com.asiainfo.service.api.IUserService;

@DubboService(registry = {"beijing","shanghai"})// 同一个服务注册到多个注册中心。如果配置了多个注册中心，但是具体的服务在注册时没有指定注册到哪一个或者哪几个，那么默认会注册到所有配置的注册中心上
public class UserServiceImpl implements IUserService {

	public String getById(int id) {
		return "User[name=zhangsan]";
	}

}
