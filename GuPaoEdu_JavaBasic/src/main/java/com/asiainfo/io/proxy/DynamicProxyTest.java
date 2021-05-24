package com.asiainfo.io.proxy;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
	public static void main(String[] args) {
		ITestService testService = new TestServiceImpl();
		
		ITestService proxyInstance = (ITestService) Proxy.newProxyInstance(testService.getClass().getClassLoader(), testService.getClass().getInterfaces(), new JdkDynamicProxy(testService));
		proxyInstance.met1();
		System.out.println("------------");
		String result = proxyInstance.met2();
		System.out.println("result = " + result);
	}
}
