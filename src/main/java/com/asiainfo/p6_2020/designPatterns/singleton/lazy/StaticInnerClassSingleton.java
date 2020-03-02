package com.asiainfo.p6_2020.designPatterns.singleton.lazy;

/**
 * 静态内部类的单例</p>
 * 优点：这种方式利用了类加载机制的天然优势，既是懒汉式又是线程安全的同时代码整洁度又提高了。</p>
 * 这里需要强调的一点是：JVM在加载外部类的时候不会同时也加载内部类，和外部类一样只有被第一次主动使用的时候内部类才会被加载
 *
 * @author zhangzhiwang
 * @date Mar 2, 2020 8:39:00 PM
 */
public class StaticInnerClassSingleton {
	private static StaticInnerClassSingleton instance;
	
	private StaticInnerClassSingleton() {}
	
	public static StaticInnerClassSingleton getInstance() {
		return MyClass.sics;
	}
	
	static class MyClass {
		public static final StaticInnerClassSingleton sics = new StaticInnerClassSingleton();
	}
}
