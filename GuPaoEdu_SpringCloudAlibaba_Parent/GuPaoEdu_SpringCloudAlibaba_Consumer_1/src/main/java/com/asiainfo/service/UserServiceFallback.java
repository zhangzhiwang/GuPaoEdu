package com.asiainfo.service;

import com.asiainfo.service.api.IUserService;

/**
 * dubbo的服务降级
 * 什么情况下会服务降级：
 *  部分服务暂停
 	全部服务暂停
 	随机拒绝服务
 	部分服务延迟
 	注意：目标服务抛异常不在降级范围内
 *
 * @author zhangzhiwang
 * @date Aug 15, 2020 11:05:27 PM
 */
public class UserServiceFallback implements IUserService {// 服务降级的类要实现目标服务接口
	public String getUserById(String id) {
		return "getUserById服务降级";
	}

	public String getAllUser() {
		// TODO Auto-generated method stub
		return "getAllUser服务降级";
	}
}
