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

public class JavaReflectTest {
	public static void main(String[] args) throws Exception {
		// 获取Class对象的四种方式：
		// 方式1:
		Class<Son> clazz1 = Son.class;
		System.out.println(clazz1);
		// 方式2:
		Class<? extends Son> clazz2 = new Son().getClass();
		System.out.println(clazz2);
		// 方式3:
		Class<?> clazz3 = Class.forName("com.asiainfo.reflect.Son");
		System.out.println(clazz3);
		// 方式4:
		Class<?> clazz4 = JavaReflectTest.class.getClassLoader().loadClass("com.asiainfo.reflect.Son");
		System.out.println(clazz4);
		System.out.println("-----------------");
		
		// *************创建对象的四种方式（获取Class对象和创建对象的方式都有四种）**************
		// 创建对象的方式1:new
		Son son1 = new Son();
		System.out.println("son1 = " + son1);
		
		// 创建对象的方式2:反射
		// 2.1:通过Class对象的newInstance()方法
		Son son2 = clazz1.newInstance();
		// 2.2:通过Constructor的newInstance()方法
		Constructor<Son> constructor = clazz1.getConstructor();
		Son son3 = constructor.newInstance();
		
		// 创建对象的方式3:clone（牵扯到Java的克隆机制）
		Object son4 = son1.clone();
		System.out.println("son4 = " + son4);
		
		// 创建对象的方式4:反序列化
		try(FileOutputStream fileOutputStream = new FileOutputStream("/Users/zhangzhiwang/Desktop/Son.txt");
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
				FileInputStream fileInputStream = new FileInputStream("/Users/zhangzhiwang/Desktop/Son.txt");
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
			// 将内存中的对象序列化到磁盘上
			objectOutputStream.writeObject(son1);
			
			// 将磁盘上的对象反序列化到内存中
			Son son5 = (Son) objectInputStream.readObject();
			System.out.println("son5 = " + son5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ***************************
		
		
		// 获取Class对象的相关信息
		// 获取包名
		Package pkg = clazz1.getPackage();
		System.out.println(pkg.getName());
		// 获取访问控制权限
		int modifiers = clazz1.getModifiers();// java的访问控制权限是一个整形的数字，想知道数字和相关权限的对应关系可以参考Modifier类的API文档或者源码（源码是以十六进制显示的需要转换成十进制）
		System.out.println(modifiers);
		// 获取类名
		String name = clazz1.getName();
		System.out.println(name);
		String simpleName = clazz1.getSimpleName();
		System.out.println(simpleName);
		// 获取父类
		Class<? super Son> superclass = clazz1.getSuperclass();
		System.out.println("superClass = " + superclass);
		// 获取接口
		Class<?>[] interfaces = clazz1.getInterfaces();
		for(Class c : interfaces) {
			System.out.println("实现的接口：" + c);
		}
		// 获取类加载器
		ClassLoader classLoader = clazz1.getClassLoader();
		System.out.println("classLoader = " + classLoader);
		// 获取注解
		Annotation[] annotations = clazz1.getAnnotations();
		for(Annotation anno : annotations) {
			System.out.println("注解：" + anno);
		}
		// 获取构造器
		Constructor<?>[] constructors = clazz1.getConstructors();
		for(Constructor con : constructors) {
			System.out.println("构造器：" + con);
		}
		
		// 获取方法
		Method[] methods = clazz1.getMethods();// 获取该类及其父类的所有public方法
		for(Method method : methods) {
			System.out.println("方法：" + method.getName());
		}
		System.out.println("--------------------");
		
		Method[] methods2 = clazz1.getDeclaredMethods();// 获取该类所有访问权限的方法
		for(Method method : methods2) {
			System.out.println("Declared方法：" + method.getName());
		}
		System.out.println("--------------------");
		
		Method staticSonMet4 = clazz1.getDeclaredMethod("staticSonMet4", String.class);
		String result = (String) staticSonMet4.invoke(null, "hello");// 反射调用静态方法
		System.out.println(result);
		
		Method SonMet3 = clazz1.getDeclaredMethod("SonMet3", String.class);
		result = (String) SonMet3.invoke(son1, "hello");// 反射调用普通方法
		System.out.println(result);
		System.out.println("--------------------");
		
		// 获取属性
		Field[] fields = clazz1.getFields();// 获取该类及其父类的所有属性
		for(Field f : fields) {
			System.out.println("属性：" + f.getName());
		}
		System.out.println("--------------------");
		
		Field[] fields2 = clazz1.getDeclaredFields();// 获取该类所有访问权限的属性
		for(Field f : fields2) {
			System.out.println("Declared属性：" + f.getName());
		}
		System.out.println("--------------------");
		
		Field sonAge = clazz1.getDeclaredField("sonAge");
		Son son6 = new Son();
		sonAge.set(son6, 18);
		System.out.println(son6.getSonAge());
		
		Field sonStaticDate = clazz1.getDeclaredField("sonStaticDate");
		sonStaticDate.set(null, new Date());
		System.out.println(Son.sonStaticDate);
	}
}
