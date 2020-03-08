package com.asiainfo.p6_2020.designPatterns.singleton.hungry;

import java.io.Serializable;

/**
 * 饿汉式单例模式（写法1）</p>
 * 优点：由于本类的实例作为静态变量且在定义的时候初始化，所以天生线程安全，不需要加任何同步措施</p>
 * 缺点：又是由于本类的实例作为静态变量且在定义的时候初始化，就意味着无论系统用不用这个类的实例以及何时会用到在类加载时都会进行初始化，如果这样的单例类有很多的话那势必会在类加载后造成大量的内存浪费。另外无法防止反射破坏单例。</p>
 * 饿汉式单例模式的特点是在类加载的时候初始化实例，由于类加载只会进行一次且是线程安全的，所以饿汉式单例模式天生具有线程安全性，但是这个特点既是它的优点又是它的缺点。
 *
 * @author zhangzhiwang
 * @date Mar 2, 2020 2:17:21 PM
 */
public class HungrySingleton1 implements Serializable {
	private static final HungrySingleton1 INSTANCE = new HungrySingleton1();

	private HungrySingleton1() {
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
}
