package com.asiainfo.service.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.protocol.rest.support.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.asiainfo.service.api.ICyclicService;
import com.asiainfo.service.api.IOrderService;
import com.asiainfo.service.api.IUserService;

@DubboService(registry = {"beijing"})// 同一个服务注册到多个注册中心。如果配置了多个注册中心，但是具体的服务在注册时没有指定注册到哪一个或者哪几个，那么默认会注册到所有配置的注册中心上
public class UserServiceImpl implements IUserService {
	@Value("${dubbo.application.name}")
	private String appName;
	@DubboReference(check = false)// 当出现循环引用时如果check设置为true那么谁也启动不了，因为在服务消费者端启动检查检查的是该服务是否在注册中心注册了且可用，所以要将check设置为false，即允许服务临时不可用，等循环引用的所有服务都起来之后就可以正常调用了
	private ICyclicService cyclicService;// 模拟循环依赖
	
	public String getUserById(String id) {
//		try {
//			Thread.sleep(300);// 模拟客户端超时
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		int i = 1 / 0;// 模拟服务端抛异常
		
		return "appName : " + appName + ",id = " + id;
	}

	public String getAllUser() {
		cyclicService.cycle();
		return "getAllUser success";
	}

}