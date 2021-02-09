package com.asiainfo.reflect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import org.springframework.stereotype.Component;

public class JavaReflectTest2 {
	public static void main(String[] args) throws Exception {
		/**
		 * 反射的优缺点：
		 * 优点：使代码更灵活，避免硬编码，达到程序服用的目的（客管的Party）
		 * 缺点：使用反射性能有损耗，原因有两点：一个是如果使用Class.forName()，那么该方法是一个native方法，native方法要比调用java代码耗时；另一方面newInstance()方法要做访问权限的校验。
		 */
		
		Party party = createParty("Individual");
//		System.out.println(party);
		
		party = createParty("Company");
//		System.out.println(party);
		
		// 测试反射性能损耗
		long begin = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++) {
			new Individual();
		}
		long end = System.currentTimeMillis();
		System.out.println("正常创建对象耗时：" + (end - begin));
		System.out.println("-------------------");
		
		long begin2 = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++) {
//			Individual.class.newInstance();
			Class<?> clazz = Class.forName("com.asiainfo.reflect.Individual");
			clazz.newInstance();
		}
		long end2 = System.currentTimeMillis();
		System.out.println("反射创建对象耗时：" + (end2 - begin2));
	}
	
	public static Party createParty(String name) throws Exception {
		Class<?> clazz = Class.forName("com.asiainfo.reflect." + name);
		Party instance = (Party) clazz.newInstance();
		return instance;
	}
}
