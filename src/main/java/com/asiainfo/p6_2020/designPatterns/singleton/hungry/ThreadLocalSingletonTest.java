package com.asiainfo.p6_2020.designPatterns.singleton.hungry;

public class ThreadLocalSingletonTest extends Thread {
	public static void main(String[] args) {
		ThreadLocalSingletonTest t1 = new ThreadLocalSingletonTest();t1.start();
		ThreadLocalSingletonTest t2 = new ThreadLocalSingletonTest();t2.start();
	}
	
	public void run() {
		for(int i = 0; i < 3; i++) {
			ThreadLocalSingleton instance = ThreadLocalSingleton.getInstance();
			System.out.println(Thread.currentThread().getName() + " -> " + instance);
		}
	}
}
