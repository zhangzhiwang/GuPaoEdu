package com.asiainfo.p6.designPatterns.singleton;

/**
 * 测试懒汉式单例模式
 *
 * @author zhangzhiwang
 * @date Oct 28, 2019 1:16:39 PM
 */
public class TestLazySingleton extends Thread {
	
	public void run() {
		LazySingleton lazySingleton = LazySingleton.getInstance();
		System.out.println(Thread.currentThread().getName() + "--->" + lazySingleton);
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			new TestLazySingleton().start();
		}
	}
}
