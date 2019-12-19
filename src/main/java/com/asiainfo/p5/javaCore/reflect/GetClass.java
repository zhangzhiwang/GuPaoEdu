package com.asiainfo.p5.javaCore.reflect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * 获取Class的四种方式
 *
 * @author zhangzhiwang
 * @date Dec 18, 2019 9:55:08 AM
 */
public class GetClass {
	public static void main(String[] args) throws Exception {
		// 1、通过类名.class
		Class clazz1 = GetClass.class;
		
		// 2、通过对象.getClass()
		GetClass getClass = new GetClass();
		Class clazz2 = getClass.getClass();
		
		// 3、通过Class.forName()
		Class clazz3 = Class.forName("com.asiainfo.p5.javaCore.reflect.GetClass");
		
		// 4、通过Class对象的getClassLoader().loadClass()方法，可以通过获取一个类的类加载器获取另一个类的Class对象
		Class clazz4 = GetClass.class.getClassLoader().loadClass("com.asiainfo.p5.javaCore.reflect.MyObject");// 通过获取GetClass类的类加载器来获取MyObject的Class对象
		System.out.println(clazz1);
		System.out.println(clazz2);
		System.out.println(clazz3);
		System.out.println(clazz1 == clazz2);
		System.out.println(clazz2 == clazz3);
		System.out.println(clazz4);
		
		// 四种方式的区别：
		
		// 为什么jdbc编程的时候用Class.forName()获取数据库驱动？
		Class.forName("com.mysql.jdbc.Driver");// 因为Class.forName()会导致类的初始化，初始化就会运行静态代码块，否则com.mysql.jdbc.Driver的静态代码块不会运行
	}
}
