package com.asiainfo.p6_2020.designPatterns.proxy.cglibDynamicProxy;

import java.lang.reflect.Method;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglib动态代理，又叫子类代理
 * </p>
 * jdk动态代理是jdk自带的，Proxy和InvocationHandler都位于java.lang.reflect包下，而cglib动态代理是第三方实现的，索引要引入相关的jar包
 *
 * @author zhangzhiwang
 * @date Mar 13, 2020 12:05:17 PM
 */
public class CglibDynamicProxy {
	public static void main(String[] args) {
		/**
		 * 静态代理和jdk动态代理都需要被代理类实现接口，否则无法进行代理，而cglib代理可以代理未实现任何接口的普通类，其原理是动态生成其子类。也由于cglib是生成被代理类的子类，所以被代理类本身不能被final修饰同时被代理方法也不能被final修饰
		 */
		// 为了证实cglib生成的代理类是指定类的子类，将内存中的字节码文件手动输出到硬盘当中，注意真实的代理过程没有有这一步
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/zhangzhiwang/Desktop/cglib");
		
		// 创建Enhancer对象，类似于JDK动态代理的Proxy类
		Enhancer enhancer = new Enhancer();
		// 将被代理类设置成代理类的父类以便cglib生成其子类
		enhancer.setSuperclass(Cat.class);
		// 设置回调函数——指定方法拦截器，任何对目标对象方法的访问都会被该拦截器拦截以执行增强逻辑
		enhancer.setCallback(new MyMethodInterceptor());
		// 获取代理对象
		Cat catProxy = (Cat) enhancer.create();
//		System.out.println("catProxy = " + catProxy);

		catProxy.eatFish();
		
		/**
		 * jdk动态代理和cglib动态代理在使用层面容易混淆的地方：</p>
		 * 1、jdk动态代理在获取代理类对象时用的是java.lang.reflect.Proxy.newProxyInstance(ClassLoader, Class<?>[], InvocationHandler)方法；而cglib在获取代理对象的时候使用的是net.sf.cglib.proxy.Enhancer.create()方法</p>
		 * 2、jdk动态代理需要自己实现InvocationHandler接口，cglib动态代理需要实现MethodInterceptor接口</p> 
		 * 3、jdk动态代理的InvocationHandler接口的invoke方法和cglib动态代理的MethodInterceptor接口的intercept方法里面的Object参数均代表代理对象，而不是被代理对象</p>
		 * 4、jdk动态代理的InvocationHandler接口的invoke方法一般不需要使用代理对象，即method.invoke()方法的第一个参数是被代理对象，也就是说method.invoke()方法的第一个参数不是InvocationHandler#invoke()方法的第一个参数；而cglib在调用proxy.invokeSuper()时的第一个参数确实是代理对象，也就是intercept方法的第一个参数</p>
		 * 5、第5点不是使用层面的区别而是原理上的：jdk动态代理使用反射机制实现的，而cglib动态代理不是
		 */
	}

	static class MyMethodInterceptor implements MethodInterceptor {

		/**
		 * obj是动态生成的代理类的对象，即代理对象
		 * </p>
		 * 通过proxy来调用代理对象父类的方法，也就是目标方法
		 */
		@Override
		public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//			System.out.println("obj到底是代理对象还是被代理对象？obj = " + obj);
			Object returnValue = proxy.invokeSuper(obj, args);
			System.out.println("善后工作");
			return returnValue;
		}
	}
}
