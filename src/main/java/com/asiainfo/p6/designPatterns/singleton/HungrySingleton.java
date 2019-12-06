package com.asiainfo.p6.designPatterns.singleton;

/**
 * 饿汉式单例模式
 *
 * @author zhangzhiwang
 * @date Oct 28, 2019 1:03:52 PM
 */
public class HungrySingleton {
	// 方式1:在类加载的时候就实例化变量
//	private static final Car CAR = new Car();
	// 方式2：静态代码块也是在类初始化的时候运行，和方式1原理一样
	private static HungrySingleton HUNGRYSINGLETON;
	
	static {
		HUNGRYSINGLETON = new HungrySingleton();
	}
	
	private HungrySingleton() {}
	
	public static HungrySingleton getInstance() {// 由于变量是在类加载的时候实例化的，所以不存在线程安全问题
		return HUNGRYSINGLETON;
	}
}
