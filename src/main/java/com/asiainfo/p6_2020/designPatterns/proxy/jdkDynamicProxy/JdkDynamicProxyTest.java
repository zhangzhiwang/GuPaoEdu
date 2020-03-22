package com.asiainfo.p6_2020.designPatterns.proxy.jdkDynamicProxy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import sun.misc.ProxyGenerator;

/**
 * jdk动态代理
 * </p>
 * jdk动态代理的“动态“体现在代理类不是程序员预先写好的java文件，然后编译成class文件，然后加载到JVM中的，而是在运行时动态生成类的字节码直接放到内存中，硬盘上不存在这样的一个class文件，所以代理类是在运行时动态生成的。
 * </p>
 * 其实动态代理和静态代理一样，代理类都需要实现被代理类实现的接口，只不过静态代理类是程序员预先写好的，而动态代理类是运行时动态生成的。
 *
 * @author zhangzhiwang
 * @date Mar 12, 2020 11:31:46 PM
 */
public class JdkDynamicProxyTest {
	public static void main(String[] args) throws Exception {
		DogImpl dogImpl = new DogImpl();
		// 动态代理理解两个类就可以了：一个是Proxy，一个是InvocationHandler
		IDog proxyInstance = (IDog) Proxy.newProxyInstance(dogImpl.getClass().getClassLoader(), // 被代理类的类加载器
				dogImpl.getClass().getInterfaces(), // 被代理类实现的接口列表
				new MyInvocationHandler(dogImpl)); // InvocationHandler实例
		// proxyInstance是实现了被代理类所有接口的代理类的对象，即代理对象
		System.out.println("proxyInstance = " + proxyInstance.toString());
		proxyInstance.eat();
		proxyInstance.bark("hello", 123);
		
		// 将动态生成的代理类通过下面的方式输出到硬盘以供分析
		// 注意：动态代理生成的代理类是在运行时在内存中动态生成的，不会存在真实的class文件，进程结束该代理类消失。这里是为了分析代理的过程采取人为干预的手段将class文件保存到硬盘，实际运行时不存在这一步
		byte[] bs = ProxyGenerator.generateProxyClass("proxyInstanceDogImpl", new Class[]{IDog.class});// 第一个参数是类名称，第二个是该类需实现的接口
		FileOutputStream fileOutputStream = new FileOutputStream("/Users/zhangzhiwang/Desktop/proxyInstanceDogImpl.class");
		fileOutputStream.write(bs);
		fileOutputStream.close();
	}

	static class MyInvocationHandler implements InvocationHandler {
		private IDog dog;

		public MyInvocationHandler(IDog dog) {
			super();
			this.dog = dog;
		}

		/**
		 * proxy是动态生成的代理类的对象，即代理对象 </p>
		 * method是被代理的方法，即被代理对象调用的方法 </p>
		 * args是被代理方法的入参 </p>
		 */
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("调用之前做点事情");
			
			Object returnValue = method.invoke(dog, args);// returnValue是被代理方法的返回值，这里要注意的是本行invoke方法的调用实际上是调用被代理对象的方法，所以第一个参数是被代理对象dog而不是代理对象proxy
			
			System.out.println("调用之后做点事情");
			return returnValue;
		}
	}
}