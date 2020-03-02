package com.asiainfo.p6_2020.designPatterns.singleton.hungry;

/**
 * 饿汉式单例模式（写法2）</p>
 * 和写法1一样，没什么不一样，只不过初始化放到了静态代码块里面
 *
 * @author zhangzhiwang
 * @date Mar 2, 2020 2:17:21 PM
 */
public class HungrySingleton2 {
	private static HungrySingleton2 instance;

	static {
		instance = new HungrySingleton2();
	}
	
	private HungrySingleton2() {
	}

	public static HungrySingleton2 getInstance() {
		return instance;
	}
}
