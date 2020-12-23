package com.asiainfo.proxy.cglibProxy;

import java.lang.reflect.Method;

import com.asiainfo.proxy.staticProxy.VocalConcert;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglib动态代理——被代理类不需要实现任何接口，需要引入cglib的包
 * 
 * cglib代理：
 * 1、引入cglib的包
 * 2、不要求被代理类实现接口，即可以实现接口也可以不实现
 * 3、代理类实现MethodInterceptor接口并重写intercept方法
 * 4、可以在intercept方法中写增强逻辑
 * 
 * cglib代理的优点：相较于jdk动态代理，对被代理类的要求放宽了
 *
 * @author zhangzhiwang
 * @date Dec 22, 2020 9:04:42 PM
 */
public class CglibProxy implements MethodInterceptor {
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("cglib动态代理之前...");
		Object result = proxy.invokeSuper(obj, args);
		System.out.println("cglib动态代理之后");
		return result;
	}
}
