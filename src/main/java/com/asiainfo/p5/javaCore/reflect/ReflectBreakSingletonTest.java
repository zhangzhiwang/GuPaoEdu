package com.asiainfo.p5.javaCore.reflect;

import java.lang.reflect.Constructor;

/**
 * 反射可以使双重检查锁的单例不再单例
 *
 * @author zhangzhiwang
 * @date Dec 9, 2019 10:00:01 AM
 */
public class ReflectBreakSingletonTest {
	public static void main(String[] args) {
		Class<DoubleCheckSingleton> clazz = DoubleCheckSingleton.class;
		try {
			Constructor<DoubleCheckSingleton> declaredConstructor = clazz.getDeclaredConstructor();
			declaredConstructor.setAccessible(true);// 强制访问私有构造器
			DoubleCheckSingleton newInstance = declaredConstructor.newInstance();
			
			DoubleCheckSingleton instance = DoubleCheckSingleton.getInstance();
			System.out.println(instance == newInstance);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
