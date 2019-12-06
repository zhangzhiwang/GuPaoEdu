package com.asiainfo.p5.javaCore.reflect;

/**
 * Java反射机制——反射机制的效率低
 *
 * @author zhangzhiwang
 * @date Dec 6, 2019 3:00:40 PM
 */
public class ClassReflectTest {
	public static void main(String[] args) throws ClassNotFoundException {
		// 不使用反射
//		long start = System.currentTimeMillis();
//		for(int i = 0; i < 100000000; i++) {
//			new ClassReflectTest();
//		}
//		long end = System.currentTimeMillis();
//		System.out.println(end - start);

		// 使用反射
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000000; i++) {
			try {
				ClassReflectTest.class.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		// 反射为什么慢
		// 原因1:通过JNI调用native方法
		Class<?> clazz = Class.forName("com.asiainfo.p5.javaCore.reflect.ClassReflectTest");
	}
}
