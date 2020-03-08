package com.asiainfo.p6_2020.designPatterns.singleton.hungry;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class HungrySingletonTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException, IOException, ClassNotFoundException {
//		HungrySingleton1 instance1 = HungrySingleton1.getInstance();
//		HungrySingleton1 instance2 = HungrySingleton1.getInstance();
//		System.out.println(instance1 == instance2);
		
//		EnumSingleton instance = EnumSingleton.getInstance();
//		instance.setNum(100);
//		System.out.println(instance.getNum());
//		
//		// 尝试通过反射新建枚举类对象
//		Constructor<EnumSingleton> constructor = EnumSingleton.class.getDeclaredConstructor(String.class, int.class);
//		System.out.println(constructor);
//		constructor.setAccessible(true);
//		EnumSingleton instance2 = constructor.newInstance("", 1);// 抛异常：Cannot reflectively create enum objects，打开newInstance方法的源码可以看到原因。
		
		// 基于枚举的单例模式的升级版——注册式单例模式
//		Object instance1 = Container.getInstance("com.asiainfo.p6_2020.designPatterns.singleton.hungry.A");
//		System.out.println(instance1);
//		Object instance2 = Container.getInstance("com.asiainfo.p6_2020.designPatterns.singleton.hungry.A");
//		System.out.println(instance2);
//		Object instance3 = Container.getInstance("com.asiainfo.p6_2020.designPatterns.singleton.hungry.B");
//		System.out.println(instance3);
//		Object instance4 = Container.getInstance("com.asiainfo.p6_2020.designPatterns.singleton.hungry.HungrySingletonTest");
//		System.out.println(instance4);
		
		// 反序列化破坏单例
		Object instance1 = EnumSingleton.getInstance();
		System.out.println(instance1);
		
		// 序列化
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/zhangzhiwang/Desktop/HungrySingleton1.txt"));
		objectOutputStream.writeObject(instance1);
		objectOutputStream.flush();
		objectOutputStream.close();
		
		// 反序列化
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/Users/zhangzhiwang/Desktop/HungrySingleton1.txt"));
		Object instance2 = objectInputStream.readObject();
		objectInputStream.close();
		System.out.println(instance2);
		System.out.println(instance1 == instance2);
		
	}
	
}
class A {}

class B {}
