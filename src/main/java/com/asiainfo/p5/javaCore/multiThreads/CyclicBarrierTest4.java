package com.asiainfo.p5.javaCore.multiThreads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier的reset方法
 *
 * @author zhangzhiwang
 * @date Dec 27, 2019 9:59:39 AM
 */
public class CyclicBarrierTest4 extends Thread {
	private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
	
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		CyclicBarrierTest4 t1 = new CyclicBarrierTest4();
		t1.setName("CyclicBarrierTest_1");
		t1.start();
		
		CyclicBarrierTest4 t2 = new CyclicBarrierTest4();
		t2.setName("CyclicBarrierTest_2");
		t2.start();
		
		Thread.sleep(1000);
		cyclicBarrier.reset();
//		t1.interrupt();
//		int numberWaiting = cyclicBarrier.getNumberWaiting();
//		System.out.println("处于阻塞的线程数量是：" + numberWaiting);
	}
	
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + "到达同步点，开始阻塞");
			System.out.println(Thread.currentThread().getName() + " broken = " + cyclicBarrier.isBroken());// 判断被阻塞的线程是否被中断
			int numberWaiting = cyclicBarrier.getNumberWaiting();
			System.out.println("处于阻塞的线程数量是：" + numberWaiting);
			cyclicBarrier.await();
			System.out.println(Thread.currentThread().getName() + "继续运行。。。");
		} catch (Exception e) {
			System.out.println(Thread.currentThread().getName() + "抛出异常！broken = " + cyclicBarrier.isBroken());
			e.printStackTrace();
		}
	}
}
