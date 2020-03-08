package com.asiainfo.p6_2020.designPatterns.singleton.lazy;

/**
 * 静态内部类的单例
 * </p>
 * 优点：这种方式利用了类加载机制的天然优势，既是懒汉式又是线程安全的同时代码整洁度又提高了。只有静态内部类单例模式可以防止反射破坏。
 * </p>
 * 这里需要强调的一点是：JVM在加载外部类的时候不会同时也加载内部类，和外部类一样只有被第一次主动使用的时候内部类才会被加载
 * </p>
 *
 * @author zhangzhiwang
 * @date Mar 2, 2020 8:39:00 PM
 */
public class StaticInnerClassSingleton {
	private StaticInnerClassSingleton() {
		if(InnerClass.SICS != null) {
			throw new RuntimeException("不允许的操作");														// 只有静态内部类单例模式可以防止反射破坏
		}
	}

	public static StaticInnerClassSingleton getInstance() {
		return InnerClass.SICS;
	}

	static class InnerClass {
		public static final StaticInnerClassSingleton SICS = new StaticInnerClassSingleton();
	}
	
	private Object readResolve() {// 防止反序列化破坏单例
		/**
		 * 为什么要写这个方法？打开java.io.ObjectInputStream.readObject()的源码，查找路径：readObject0()->readOrdinaryObject()->hasReadResolveMethod()->invokeReadResolve()
		 */
		return InnerClass.SICS;
	}
}


class Test {
	public Test() {
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
	}
}
