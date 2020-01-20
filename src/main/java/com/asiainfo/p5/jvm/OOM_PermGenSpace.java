package com.asiainfo.p5.jvm;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 方法区内存溢出
 *
 * @author zhangzhiwang
 * @date Jan 14, 2020 10:41:42 AM
 */
public class OOM_PermGenSpace {
	public static void main(String[] args) {
		// 使用cglib往方法区填充大量的类
		// -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
		while (true) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {
				@Override
				public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
					return methodProxy.invokeSuper(o, objects);
				}
			});
			enhancer.create();
		}
	}

	static class OOMObject {

	}
}
