package com.asiainfo.proxy.staticProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 代理：
 * 1、静态代理
 * 2、动态代理
 * 	2.1 jdk动态代理
 *  2.2 cglib动态代理
 *
 * @author zhangzhiwang
 * @date Dec 22, 2020 4:18:20 PM
 */
@Component
public class StaticProxy implements VocalConcert {// 静态代理类要和被代理类实现同一接口
	@Autowired
	@Qualifier("zhouJieLun")
	private VocalConcert target;// 代理类持有被代理类对象
	
	@Override
	public void sing() {// 代理类实现的接口方法要用被代理类对象去掉用该方法
		System.out.println("pre:商务洽谈");
		target.sing();
		System.out.println("post:费用结算");
	}
}
