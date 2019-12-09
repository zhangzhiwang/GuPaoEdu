package com.asiainfo.p5.javaCore.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Java反射机制——构造器的反射
 *
 * @author zhangzhiwang
 * @date Dec 7, 2019 9:06:01 PM
 */
public class ConstructorReflectTest extends Boy {
	public static void main(String[] args) {
		Class<Boy> clazz = Boy.class;
		Constructor[] constructors = clazz.getConstructors();// 获取所有公共构造方法，由于构造方法不能继承所以不包括父类的
		System.out.println(constructors.length);

		Constructor[] declaredConstructors = clazz.getDeclaredConstructors();// 获取该类声明的所有构造方法，包括任意修饰符
		System.out.println(declaredConstructors.length);
		for (Constructor constructor : declaredConstructors) {
			System.out.println(constructor);
		}
		System.out.println("----------------");

		try {
			Constructor<Boy> declaredConstructor = clazz.getDeclaredConstructor();
			System.out.println(declaredConstructor);
//			declaredConstructor = clazz.getDeclaredConstructor(int.class);
			System.out.println(declaredConstructor);
			int modifiers = declaredConstructor.getModifiers();
			System.out.println(modifiers);
			System.out.println("----------------");

//			declaredConstructor.setAccessible(true);
//			Boy newInstance = declaredConstructor.newInstance(123);
			Boy newInstance2 = clazz.newInstance();// 查看clazz.newInstance()的源码可以知道，这个方法实际上调用的是构造器的newInstance(Object ... initargs)方法，等同于下面这行代码
			Boy newInstance3 = declaredConstructor.newInstance((Object[])null);
//			System.out.println(newInstance);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
