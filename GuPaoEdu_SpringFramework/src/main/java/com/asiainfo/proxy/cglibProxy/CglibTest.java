package com.asiainfo.proxy.cglibProxy;

import com.asiainfo.proxy.staticProxy.JayChou;
import com.asiainfo.proxy.staticProxy.JayChou2;

//import net.sf.cglib.proxy.Enhancer;

public class CglibTest {
	public static void main(String[] args) {
//		// 使用cglib的步骤：
//		// 1、引入cglib的依赖
//		// 2、创建Enhancer对象
//		Enhancer enhancer = new Enhancer();
//		// 3、设置父类
//		enhancer.setSuperclass(JayChou2.class);
//		// 4、设置回调函数，参数是MethodInterceptor接口的实现类对象，调用目标方法时会自动调用MethodInterceptor类的intercept方法
//		enhancer.setCallback(new CglibProxy());
//		// 5、创建对象
//		JayChou2 proxy = (JayChou2) enhancer.create();
//		proxy.sing();
//		System.out.println("------------");
//		String result = proxy.dance(10086);
//		System.out.println("result =" + result);
	}
}
