package com.asiainfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.asiainfo.service.api.IHelloService;

public class RpcController {
	private static IHelloService helloService;// 模拟依赖注入
	
	static {
		// 对IHelloService生成动态代理
		helloService = (IHelloService) Proxy.newProxyInstance(IHelloService.class.getClassLoader(), new Class[] {IHelloService.class}, new JdkDynamicProxy());
	}
	
	public static void main(String[] args) {
		String result = helloService.hello("zhangsan");
		System.out.println(result);
	}
}
