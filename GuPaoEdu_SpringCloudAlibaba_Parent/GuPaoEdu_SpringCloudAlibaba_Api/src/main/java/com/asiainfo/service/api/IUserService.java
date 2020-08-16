package com.asiainfo.service.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/")// 配置rest风格http接口的路径，可以类比@RequestMapping
public interface IUserService {
	@Path("/getById")// 相当与方法上的@RequestMapping
	@GET// 接收get请求
//	@POST// 接收post请求
	String getUserById(String id);
	
	String getAllUser();
}