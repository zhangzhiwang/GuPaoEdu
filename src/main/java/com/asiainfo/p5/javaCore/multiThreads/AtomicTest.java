package com.asiainfo.p5.javaCore.multiThreads;

/**
 * 原子性测试
 *
 * @author zhangzhiwang
 * @date Dec 26, 2019 4:27:29 PM
 */
public class AtomicTest extends Thread {
	private static int num;// volatile能解决问题吗，导致问题发生的原因除了可见性之外还有原子性，volatile不能保证volatile++的原子性，所以要想解决这个问题只能加锁。既然锁可以保证原子性、可见性和有序性那么就不需要加volatile了。

	public static void main(String[] args) throws InterruptedException {
		Thread[] ts = new Thread[1000];
		for (int i = 0; i < 1000; i++) {
			ts[i] = new AtomicTest();
		}

		for (Thread t : ts) {
			t.start();
		}

		Thread.sleep(8000);
		System.out.println(num);
	}

	public void run() {
		synchronized (AtomicTest.class) {
			Thread.yield();// 不释放锁
			num += 10;
		}
	}
}
