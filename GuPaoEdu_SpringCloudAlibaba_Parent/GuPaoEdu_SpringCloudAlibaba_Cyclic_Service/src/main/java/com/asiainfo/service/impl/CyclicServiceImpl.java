package com.asiainfo.service.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import com.asiainfo.service.api.ICyclicService;
import com.asiainfo.service.api.IUserService;

@DubboService
public class CyclicServiceImpl implements ICyclicService {
	@DubboReference(registry = {"dubbo"}, protocol = "dubbo", check = false)
	private IUserService userService;

	public void cycle() {
		userService.getAllUser();
		System.out.println("cycle");
	}

}
