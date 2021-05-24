package com.asiainfo.jvm;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * java.lang.OutOfMemoryError: Metaspace
 *
 * @author zhangzhiwang
 * @date 2021年4月8日 下午2:45:10
 */
public class OOM_Metaspace {
	public static void main(String[] args) {
		// -XX:MaxMetaspaceSize=100M -XX:MetaspaceSize=100M 
		while (true) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOM.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {

				@Override
				public Object intercept(Object obj, Method arg1, Object[] args, MethodProxy proxy) throws Throwable {
					return proxy.invokeSuper(obj, args);
				}
			});
			OOM oom = (OOM) enhancer.create();
			oom.sayHello("Kevin LUAN");
		}
	}

	static class OOM {
		public String sayHello(String str) {
			return "HI " + str;
		}
	}
}
