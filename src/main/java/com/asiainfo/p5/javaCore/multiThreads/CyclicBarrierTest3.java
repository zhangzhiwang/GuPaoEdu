package com.asiainfo.p5.javaCore.multiThreads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier
 *
 * @author zhangzhiwang
 * @date Dec 27, 2019 9:59:39 AM
 */
public class CyclicBarrierTest3 extends Thread {
	// 面试题：多线程编程，50个线程生成随机数，然后相加。这里使用CountDownLatch来实现，还有会用CyclicBarrier来实现。
	private static int num;
	private static CyclicBarrier cyclicBarrier;
	private String name;

	private CyclicBarrierTest3(String name) {
		super();
		this.name = name;
	}

	static {
		cyclicBarrier = new CyclicBarrier(50, new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(num);
			}
		});
	}

	public void run() {
		try {
			synchronized (CyclicBarrierTest3.class) {
				num++;
			}
			cyclicBarrier.await();// 通知CyclicBarrier本线程已到达同步点，开始阻塞。底层调用的是LockSupport.park()方法，由于该方法不释放锁，所以本例中要在synchronized块之外使用。
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			new CyclicBarrierTest3("Thread_" + i).start();
		}
	}
}
