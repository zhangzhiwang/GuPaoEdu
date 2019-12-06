package com.asiainfo.p6.designPatterns.singleton;

/**
 * 懒汉式单例模式
 *
 * @author zhangzhiwang
 * @date Oct 28, 2019 1:13:14 PM
 */
public class LazySingleton {
	private static LazySingleton lazySingleton;// 虽然lazySingleton = new LazySingleton()会有指令重排序的可能，但是由于synchronized修饰了getInstance方法，所以同一时间只会有同一个线程在执行。所以这里不需要volatile修饰

	private LazySingleton() {
	}

	public static synchronized LazySingleton getInstance() {// 懒汉式是在第一次使用的时候实例化变量，有线程安全问题
		if (lazySingleton != null) {
			return lazySingleton;
		}

		lazySingleton = new LazySingleton();// 会有指令重排序
		return lazySingleton;
	}
}
