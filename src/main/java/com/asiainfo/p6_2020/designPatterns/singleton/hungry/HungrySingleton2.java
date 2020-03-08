package com.asiainfo.p6_2020.designPatterns.singleton.hungry;

import java.io.Serializable;

/**
 * 饿汉式单例模式（写法2）</p>
 * 和写法1一样，没什么不一样，只不过初始化放到了静态代码块里面
 *
 * @author zhangzhiwang
 * @date Mar 2, 2020 2:17:21 PM
 */
public class HungrySingleton2 implements Serializable {
	private static final HungrySingleton2 INSTANCE;

	static {
		INSTANCE = new HungrySingleton2();
	}
	
	private HungrySingleton2() {
	}

	public static HungrySingleton2 getInstance() {
		return INSTANCE;
	}
	
	private Object readResolve() {// 防止反序列化破坏单例
		/**
		 * 为什么要写这个方法？打开java.io.ObjectInputStream.readObject()的源码，查找路径：readObject0()->readOrdinaryObject()->hasReadResolveMethod()->invokeReadResolve()
		 */
		return INSTANCE;
	}
}
