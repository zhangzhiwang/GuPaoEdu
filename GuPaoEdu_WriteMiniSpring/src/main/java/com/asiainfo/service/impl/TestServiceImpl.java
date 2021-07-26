package com.asiainfo.service.impl;

import com.asiainfo.annotation.ZzwComponent;
import com.asiainfo.service.ITestService;

@ZzwComponent
public class TestServiceImpl implements ITestService {
	@Override
	public String test(String s) {
		return "test ---> " + s;
	}
}
