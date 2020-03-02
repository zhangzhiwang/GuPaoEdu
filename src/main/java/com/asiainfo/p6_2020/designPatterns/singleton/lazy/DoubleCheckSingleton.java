package com.asiainfo.p6_2020.designPatterns.singleton.lazy;

/**
 * 双重检查锁的单例模式，仍然是懒汉式
 *
 * @author zhangzhiwang
 * @date Mar 2, 2020 2:44:45 PM
 */
public class DoubleCheckSingleton {
	private static volatile DoubleCheckSingleton instance;
	
	private DoubleCheckSingleton() {}
	
	public static DoubleCheckSingleton getInstance() {
		if(instance == null) {// 在instance不为null的情况下不需要任何同步措施，因为读和读是不互斥的，不会有线程安全问题。这样就减小了锁的粒度，使得在大部分情况下访问本方法是不需要同步的
			synchronized (DoubleCheckSingleton.class) {
				if(instance == null) {
					instance = new DoubleCheckSingleton();
				}
			}
		}
		
		return instance;
	}
}
