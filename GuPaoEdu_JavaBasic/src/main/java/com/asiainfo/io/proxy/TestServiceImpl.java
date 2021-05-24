package com.asiainfo.io.proxy;

public class TestServiceImpl implements ITestService {

	@Override
	public void met1() {
		System.out.println("met1");
	}

	@Override
	public String met2() {
		System.out.println("met2");
		return "met2";
	}

}
