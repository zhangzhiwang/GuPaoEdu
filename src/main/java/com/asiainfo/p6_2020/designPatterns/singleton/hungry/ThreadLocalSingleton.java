package com.asiainfo.p6_2020.designPatterns.singleton.hungry;

/**
 * 基于ThreadLocal的单例模式——只能保证一个线程内是单例的，线程之间不能保证单例，天生线程安全
 *
 * @author zhangzhiwang
 * @date Mar 4, 2020 10:58:32 PM
 */
public class ThreadLocalSingleton {
	private static ThreadLocal<ThreadLocalSingleton> threadLocal = new ThreadLocal<ThreadLocalSingleton>() {
		@Override
		protected ThreadLocalSingleton initialValue() {
	        return new ThreadLocalSingleton();
	    }
	};
	
	private ThreadLocalSingleton() {}
	
	public static ThreadLocalSingleton getInstance() {
		return threadLocal.get();
	}
}
