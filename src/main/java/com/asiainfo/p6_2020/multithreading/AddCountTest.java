package com.asiainfo.p6_2020.multithreading;

/**
 * 经典问题
 *
 * @author zhangzhiwang
 * @date May 22, 2020 12:04:40 PM
 */
public class AddCountTest extends Thread {
	public static int count;
	
	public void add() {
//		synchronized (AddCountTest.class) {
			count++;
//		}
	}
	
	public void run() {
		add();
	}
	
	public static void main(String[] args) throws InterruptedException {
		for(int i = 0; i < 10000; i++) {
			new AddCountTest().start();
		}
		
		Thread.sleep(3000);
		System.out.println(count);
	}
}
