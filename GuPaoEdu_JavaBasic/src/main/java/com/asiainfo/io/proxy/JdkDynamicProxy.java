package com.asiainfo.io.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * jdk动态代理
 *
 * @author zhangzhiwang
 * @date 2021年4月22日 上午9:48:48
 */
public class JdkDynamicProxy implements InvocationHandler {
	private Object target;

	public JdkDynamicProxy(Object target) {
		super();
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("调用目标方法前做点事情");
		Object result = method.invoke(target, args);
		System.out.println("	调用目标方法后做点事情");
		return result;
	}

}
