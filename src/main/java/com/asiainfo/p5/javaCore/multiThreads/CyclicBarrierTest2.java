package com.asiainfo.p5.javaCore.multiThreads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier
 *
 * @author zhangzhiwang
 * @date Dec 27, 2019 9:59:39 AM
 */
public class CyclicBarrierTest2 extends Thread {
	private static CyclicBarrier cyclicBarrier;

	static {
		cyclicBarrier = new CyclicBarrier(2, new Runnable() {// CyclicBarrier第二种使用方式：构造方法的第二个参数传递一个Runnable对象，用于最后一个线程到达同步点时先执行这个Runnable对象的run方法，然后再唤醒其他阻塞的线程。
			@Override
			public void run() {// 注意：是最后一个线程到达屏障点时才会触发run的执行，然后再唤醒其他线程
				System.out.println("hello");
			}
		});
	}

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		CyclicBarrierTest2 t1 = new CyclicBarrierTest2();
		t1.setName("CyclicBarrierTest_1");
		t1.start();

		CyclicBarrierTest2 t2 = new CyclicBarrierTest2();
		t2.setName("CyclicBarrierTest_2");
		t2.start();

//		System.out.println(Thread.currentThread().getName() + "到达同步点，开始阻塞");
//		cyclicBarrier.await();
//		System.out.println(Thread.currentThread().getName() + "继续运行。。。");
	}

	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + "到达同步点，开始阻塞");
			cyclicBarrier.await();// 调用await()方法通知CyclicBarrier本线程已到达同步点，并阻塞
			System.out.println(Thread.currentThread().getName() + "继续运行。。。");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
