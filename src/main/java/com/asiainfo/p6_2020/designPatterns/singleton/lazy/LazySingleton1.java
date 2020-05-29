package com.asiainfo.p6_2020.designPatterns.singleton.lazy;

import java.io.Serializable;

/**
 * 懒汉式单例模式——在第一次需要时才初始化对象
 * </p>
 * 优点：解决了饿汉式单例模式在类加载时初始化对象导致的内存浪费问题，如果加上synchronized关键字保证了线程安全问题
 * </p>
 * 缺点：synchronized家在方法定义处效率低。只有在第一次新建对象时才需要同步，对象建好后绝大部分的场景都是获取该对象，而获取对象是不需要同步的。改进方案就是缩小锁粒度，于是就出现类双重检查锁的单例模式。另外无法防止反射破坏单例。
 *
 * @author zhangzhiwang
 * @date Mar 2, 2020 2:34:16 PM
 */
public class LazySingleton1 implements Serializable {
	private static LazySingleton1 instance;

	private LazySingleton1() {
		if(instance != null) {// 对反射不起作用
			throw new UnsupportedOperationException("不支持的操作");
		}
	}

	public static synchronized LazySingleton1 getInstance() {
		if (instance == null) {
			instance = new LazySingleton1();
		}

		return instance;
	}
	
	private Object readResolve() {// 防止反序列化破坏单例
		/**
		 * 为什么要写这个方法？打开java.io.ObjectInputStream.readObject()的源码，查找路径：readObject0()->readOrdinaryObject()->hasReadResolveMethod()->invokeReadResolve()
		 */
		return instance;
	}
}
