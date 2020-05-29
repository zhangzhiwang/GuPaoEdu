package com.asiainfo.p6_2020.designPatterns.singleton.hungry;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * 饿汉式单例模式（写法1）
 * </p>
 * 优点：由于本类的实例作为静态变量且在定义的时候初始化，所以天生线程安全，不需要加任何同步措施
 * </p>
 * 缺点：又是由于本类的实例作为静态变量且在定义的时候初始化，就意味着无论系统用不用这个类的实例以及何时会用到在类加载时都会进行初始化，如果这样的单例类有很多的话那势必会在类加载后造成大量的内存浪费。另外无法防止反射破坏单例。
 * </p>
 * 饿汉式单例模式的特点是在类加载的时候初始化实例，由于类加载只会进行一次且是线程安全的，所以饿汉式单例模式天生具有线程安全性，但是这个特点既是它的优点又是它的缺点。
 *
 * @author zhangzhiwang
 * @date Mar 2, 2020 2:17:21 PM
 */
public class HungrySingleton1 implements Serializable {
	private static final HungrySingleton1 INSTANCE = new HungrySingleton1();

	private HungrySingleton1() {
		// 这样写没有用，并不能防止反射攻击
		if (INSTANCE != null) {// 通过反射可以去掉INSTANCE的final修饰符，然后重新将INSTANCE置为null，然后通过反射获取构造函数创建新对象，所以此方法并不能防止反射破坏
			throw new UnsupportedOperationException("不支持该操作");
		}
	}

	public static HungrySingleton1 getInstance() {
		return INSTANCE;
	}

	private Object readResolve() {// 防止反序列化破坏单例
		/**
		 * 为什么要写这个方法？打开java.io.ObjectInputStream.readObject()的源码，查找路径：readObject0()->readOrdinaryObject()->hasReadResolveMethod()->invokeReadResolve()
		 */
		return INSTANCE;
	}

	/**
	 * 反射破坏单例
	 * 
	 * @param clazz
	 * @throws Exception
	 * @author zhangzhiwang
	 * @date May 29, 2020 5:38:41 PM
	 */
	public static void reflectDestroySingleton(Class<?> clazz) throws Exception {
		// 通过反射破坏单例
		Field field = clazz.getDeclaredField("INSTANCE");
		field.setAccessible(true);// 访问private变量
		int modifiers = field.getModifiers();
		System.out.println("modifiers1 = " + modifiers);// private(2) + static(8) + final(16) = 26

		Field f = Field.class.getDeclaredField("modifiers");
		f.setAccessible(true);
		f.setInt(field, 10);// 去掉final

		field.set(null, null);// 重新给field赋值

		// 通过反射调用构造方法创建实例
		Constructor<?> constructor = clazz.getDeclaredConstructor();
		constructor.setAccessible(true);
		Object instance2 = constructor.newInstance();
		System.out.println("反射后instance2 = " + instance2);
	}

	/**
	 * 反序列化破坏反射
	 * 
	 * @author zhangzhiwang
	 * @date May 29, 2020 5:42:41 PM
	 */
	public static Object unserializeDestroySingleton(Object o) {
		Object result = null;
		try (FileOutputStream fileOutputStream = new FileOutputStream("test.txt"); FileInputStream fileInputStream = new FileInputStream("test.txt"); ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream); ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
			// 序列化
			objectOutputStream.writeObject(o);
			objectOutputStream.flush();

			// 反序列化
			result = objectInputStream.readObject();// 打开java.io.ObjectInputStream.readObject()的源码，查找路径：readObject0()->readOrdinaryObject()->hasReadResolveMethod()->invokeReadResolve()
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public static void main(String[] args) {
		try {
			// 反射破坏单例
			HungrySingleton1 instance1 = HungrySingleton1.getInstance();
			System.out.println("正常情况下instance1 = " + instance1);

//			reflectDestroySingleton(HungrySingleton.class);

			// 反序列化破坏单例
			Object instance3 = unserializeDestroySingleton(instance1);
			System.out.println("反序列化instance3 = " + instance3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
