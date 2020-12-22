package com.asiainfo.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.asiainfo.proxy.staticProxy.VocalConcert;

/**
 * jdk动态代理——被代理类必须实现接口
 *
 * @author zhangzhiwang
 * @date Dec 22, 2020 5:00:33 PM
 */
public class JdkProxyInvocationHandler implements InvocationHandler {
	private VocalConcert target;
	
	public JdkProxyInvocationHandler(VocalConcert target) {
		super();
		this.target = target;
	}

	/**
	 * proxy是代理对象，即动态生成代理类的对象，不是被代理对象，被代理对象是target
	 * method是被代理对象要调用的目标方法
	 * args是目标方法的入参
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("target = " + target);
//		System.out.println("proxy = " + proxy);
		System.out.println("jdk动态代理：目标方法调用前");
		Object result = method.invoke(target, args);	// 注意：method的调用对象是target而不是proxy
		System.out.println("jdk动态代理：after目标方法调用");
		return result;
	}
	
	// 测试类见com.asiainfo.AppTest.testJdkProxy()
}
