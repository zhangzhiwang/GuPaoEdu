package com.asiainfo.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.protocol.rest.support.ContentType;
import org.springframework.beans.factory.annotation.Value;

import com.asiainfo.service.api.IUserService;

@DubboService(registry = {"beijing"})// 同一个服务注册到多个注册中心。如果配置了多个注册中心，但是具体的服务在注册时没有指定注册到哪一个或者哪几个，那么默认会注册到所有配置的注册中心上
public class UserServiceImpl implements IUserService {
	@Value("${dubbo.application.name}")
	private String appName;
	
	public String getUserById(String id) {
		return "appName : " + appName + ",id = " + id;
	}

	public String getAllUser() {
		// TODO Auto-generated method stub
		return null;
	}
}
