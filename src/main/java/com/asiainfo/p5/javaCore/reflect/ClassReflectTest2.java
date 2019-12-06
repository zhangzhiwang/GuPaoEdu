package com.asiainfo.p5.javaCore.reflect;

import java.lang.annotation.Annotation;
import java.util.logging.Logger;

import org.junit.Test;

/**
 * Java反射机制——获取Clas对象的方式
 *
 * @author zhangzhiwang
 * @date Dec 6, 2019 3:00:40 PM
 */
@MyAnnotation1
@MyAnnotation2
public class ClassReflectTest2 extends Boy implements Runnable {
	public static void main(String[] args) throws ClassNotFoundException {
		// 获取Class对象的方式有四种：
		// 1、类.class
		Class clazz1 = ClassReflectTest2.class;
		// 2、对象.getClass()
//		ClassReflectTest2 classReflectTest2 = new ClassReflectTest2();
//		Class clazz2 = classReflectTest2.getClass();
		// 3、通过Class.forName()
		Class clazz3 = Class.forName("com.asiainfo.p5.javaCore.reflect.IPerson");
		// 4、通过ClassLoader.loadClass()
		Class<?> clazz4 = ClassReflectTest.class.getClassLoader().loadClass("com.asiainfo.p5.javaCore.reflect.ClassReflectTest2");
		
		// 类的反射
		// 获取类的修饰符
		int modifier = clazz3.getModifiers();
		System.out.println(modifier);// 如果是接口则为：1024（ABSTRACT）+ 512（INTERFACE）+ 1（PUBLIC）= 1537
		// 获取类的包名
		Package package1 = clazz1.getPackage();
		System.out.println(package1);
		// 获取类的全名称
		String fullName = clazz1.getName();
		System.out.println(fullName);
		// 获取类的简单名称
		String simpleName = clazz1.getSimpleName();
		System.out.println(simpleName);
		// 获取类的类加载器
		ClassLoader classLoader = clazz1.getClassLoader();
		System.out.println(classLoader);
		// 获取类实现的接口列表
		Class[] interfaces = clazz1.getInterfaces();
		System.out.println(interfaces.length);
		System.out.println(interfaces[0]);
		// 获取类的父类
		Class superclass = clazz1.getSuperclass();
		System.out.println(superclass);
		// 获取类的注解列表
		Annotation[] annotations = clazz1.getAnnotations();
		System.out.println(annotations.length);
		System.out.println(annotations[1]);
	}

	@Override
	public void run() {
	}
}
