package com.asiainfo.p5.javaCore.reflect;

/**
 * Java反射机制——获取Clas对象的方式
 *
 * @author zhangzhiwang
 * @date Dec 6, 2019 3:00:40 PM
 */
public class ClassReflectTest2 {
	public static void main(String[] args) throws ClassNotFoundException {
		// 获取Class对象的方式有四种：
		// 1、类.class
		Class clazz1 = ClassReflectTest2.class;
		// 2、对象.getClass()
		ClassReflectTest2 classReflectTest2 = new ClassReflectTest2();
		Class clazz2 = classReflectTest2.getClass();
		// 3、通过Class.forName()
		Class clazz3 = Class.forName("com.asiainfo.p5.javaCore.reflect.ClassReflectTest2");
		// 4、通过ClassLoader.loadClass()
		Class<?> clazz4 = ClassReflectTest.class.getClassLoader().loadClass("com.asiainfo.p5.javaCore.reflect.ClassReflectTest2");
	}
}
