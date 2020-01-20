package com.asiainfo.p5.jvm;

import java.io.IOException;
import java.io.InputStream;

/**
 * 同一个类用不同的类加载器加载会出现什么情况
 *
 * @author zhangzhiwang
 * @date Jan 17, 2020 2:30:58 PM
 */
public class ClassLoaderTest {
	public static void main(String[] args) throws ClassNotFoundException {
		Class clazz1 = ClassLoaderTest.class;
		ClassLoaderTest classLoaderTest = new ClassLoaderTest();
		Class clazz2 = classLoaderTest.getClass();
		System.out.println(clazz1);
		System.out.println(clazz2);
		System.out.println(clazz1 == clazz2);
		
		System.out.println("--------------------------");
		ClassLoader classLoader = new ClassLoader() {
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException {
				String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
				InputStream stream = getClass().getResourceAsStream(fileName);
				if (stream == null) {
                    return super.loadClass(name);
                }
                try {
                    byte[] b = new byte[stream.available()];
                    // 将流写入字节数组b中
                    stream.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return super.loadClass(name);
			}
		};
		
		Class<?> clazz3 = classLoader.loadClass("com.asiainfo.p5.jvm.ClassLoaderTest");
		System.out.println(clazz3);
		System.out.println(clazz1 == clazz3);// 同一个类被不同的类加载器加载那么那么这两个类是不相等的
	}
}
