package com.asiainfo.service.interfaceTest;

import org.springframework.stereotype.Service;

import com.asiainfo.entityTest.User;

/**
 * feign集成hystrix，用于服务降级的类
 *
 * @author zhangzhiwang
 * @date Dec 11, 2020 5:09:42 PM
 */
//@Service
public class FeignHystrixFallbackService implements IUserService {
	@Override
	public String getUser(String s) {
		return "feign hystrix降级";
	}

	@Override
	public String insertUser(User user) {
		return "feign hystrix降级";
	}

}
