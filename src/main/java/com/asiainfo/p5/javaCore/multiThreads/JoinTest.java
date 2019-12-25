package com.asiainfo.p5.javaCore.multiThreads;

/**
 * join
 *
 * @author zhangzhiwang
 * @date Dec 23, 2019 7:53:32 PM
 */
public class JoinTest extends Thread {
	public static void main(String[] args) throws InterruptedException {
		JoinTest j1 = new JoinTest("t1");
		j1.start();
		j1.join();// join方法使当前调用join方法的线程wait
		new JoinTest("t2").start();
	}
	
	public JoinTest(String name) {
		super(name);
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
}
