package com.asiainfo.proxy.cglibProxy;

import java.lang.reflect.Method;

import com.asiainfo.proxy.staticProxy.VocalConcert;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglib动态代理——被代理类不需要实现任何接口，需要引入cglib的包
 *
 * @author zhangzhiwang
 * @date Dec 22, 2020 9:04:42 PM
 */
public class CglibProxy implements MethodInterceptor {
	private VocalConcert target;
	
	public CglibProxy(VocalConcert target) {
		super();
		this.target = target;
	}



	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

}
