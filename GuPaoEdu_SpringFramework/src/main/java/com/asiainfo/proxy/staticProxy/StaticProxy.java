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
 * 静态代理：
 * 1、被代理类一般要实现接口（最好实现接口，以约束代理类的行为，但不强制要求）
 * 2、静态代理类要实现和被代理类相同的接口并实现接口的所有方法
 * 3、静态代理类要持有被代理类的对象
 * 4、在静态代理类的的方法中用被代理类对象调用目标方法，从而起到代理的作用，同时可以做一些其他的操作
 * 
 * 静态代理的缺点：
 * 1、代理类要实现所有接口的方法
 * 2、需要在实现的每一个方法中写“增强部分”的逻辑，如果这个逻辑都相同（比如连接数据库，释放数据库连接），会造成代码冗余
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
		System.out.println("pre:商务洽谈");// 每一个方法的增强逻辑“pre”和“post”都相同，但是在每一个实现方法里都要写
		target.sing();
		System.out.println("post:费用结算");
	}

	@Override
	public String dance(int i) {
		System.out.println("pre:商务洽谈");
		target.dance(i);
		System.out.println("post:费用结算");
		return "" + i;
	}
	
	// 测试方法详见com.asiainfo.AppTest.testStaticProxy()
}
