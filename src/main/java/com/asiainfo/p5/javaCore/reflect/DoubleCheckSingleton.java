package com.asiainfo.p5.javaCore.reflect;

/**
 * 基于双重检查锁的单例模式
 *
 * @author zhangzhiwang
 * @date Dec 9, 2019 9:53:33 AM
 */
public class DoubleCheckSingleton {
	private static DoubleCheckSingleton singleton;

	private DoubleCheckSingleton() {
	}

//	public static DoubleCheckSingleton getInstance() {
//		if (singleton != null) {
//			return singleton;
//		}
//
//		synchronized (DoubleCheckSingleton.class) {
//			if (singleton != null) {
//				return singleton;
//			}
//
//			singleton = new DoubleCheckSingleton();
//			return singleton;
//		}
//	}

	public static DoubleCheckSingleton getInstance() {
		if (singleton == null) {
			synchronized (DoubleCheckSingleton.class) {
				if (singleton == null) {
					singleton = new DoubleCheckSingleton();
					return singleton;
				}
			}
		}
		
		return singleton;
	}
}
