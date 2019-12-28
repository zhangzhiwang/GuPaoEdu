package com.asiainfo.p5.javaCore.multiThreads;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch
 *
 * @author zhangzhiwang
 * @date Dec 25, 2019 10:24:16 PM
 */
public class CountDownLatchTest {
	private static double num;
	
	public static void main(String[] args) throws InterruptedException {
		// 需求：一个线程等到其他所有线程都运行结束之后才继续运行
		// 面试题：多线程编程，50个线程生成随机数，然后相加。这里使用CountDownLatch来实现，还有会用CyclicBarrier来实现。
		int threadNum = 50;// 启动n个线程
		final CountDownLatch countDownLatch = new CountDownLatch(threadNum);
		
		for(int i = 0; i < threadNum; i++) {
			new Thread(new Runnable() {
				public void run() {
					synchronized (CountDownLatchTest.class) {
						num += Math.random();
						countDownLatch.countDown();
					}
				}
			}).start();
		}
		
		countDownLatch.await();// CountDownLatch的await()方法会阻塞当前线程直到其它所有线程执行完毕的时候再继续运行。要想达到这个效果，首先每个线程必须共用一个CountDownLatch的实例对象，并且在运行结束前调用countDown()方法将计数减1，最后将计数减为0的那个线程会唤醒因调用CountDownLatch.await()而处于阻塞的线程。
		System.out.println(num);
	}
}
