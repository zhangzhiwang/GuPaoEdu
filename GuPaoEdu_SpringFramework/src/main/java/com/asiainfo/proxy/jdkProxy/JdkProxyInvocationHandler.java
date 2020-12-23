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
 * jdk动态代理：
 * 1、被代理类必须实现接口，注意是必须
 * 2、代理类实现InvocationHandler接口并重写invoke方法，可以在invoke方法里面写增强的逻辑
 * 3、代理类持有被代理类的对象，并在invoke方法中通过反射调用被代理对象的目标方法
 * 
 * jdk动态代理的优点：相较于静态代理，代理类不需要实现被代理类所实现接口的所有方法，也不用在每一个代理方法里面插入相同的增强逻辑。在jdk动态代理中，调用任何一个目标方法都会执行InvocationHandler的invoke方法，这样在invoke方法中写入增强逻辑即可。
 * jdk动态代理的限制：被代理类必须实现接口
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
