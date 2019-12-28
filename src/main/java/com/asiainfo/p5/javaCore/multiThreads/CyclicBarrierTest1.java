package com.asiainfo.p5.javaCore.multiThreads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier——使一组线程到达一个屏障（同步点）时被阻塞，知道最后一个线程到达屏障时所有被阻塞的线程才开始继续运行</p>
 * 举一个形象化的例子，就好比一个登山队在半山腰设一个休息点，先到的队员可以原地休息等一下后面的队员跟上来，直到锁最后一个名队员到达休息点之后所有队员开继续出发。</p>
 * 分析CyclicBarrier的源码，大致过程是这样的：</p>
 * 1、在构造CyclicBarrier实例的时候要传入一个parties的数值，这个数值代表一共有多少个参与者线程，一旦这个数值被设置那么后必须有有这么多个线程调用await方法才可以，少一个都不行，否则唤醒不了。就好比登上队在出发前先强电一下人数，到达休息点时必须还得有这么多人，如果少一个人那么其他所有队员必须在这个休息点等他。</p>
 *    这里的同步点就是一个栅栏Barrier。</p>
 * 2、在某一个线程到达同步点时要调用await方法来告诉CyclicBarrier自己已到达同步点，并将parties的值减1，然后调用ReentrantLock的Condition对象去调用await方法阻塞当前线程。</p>
 * 3、当最后一个线程到达同步点时调用await方法并将parties的值减1，这时parties值已经为0了，那么就会调用ReentrantLock的Condition对象的signalAll方法唤醒所有线程，那么本周期结束，所有线程继续运行，开始下一个周期，奔向下一个同步点。</p>
 *    这里一个周期被定义为一代（Generation），下一个周期是下一个Generation，后面会有循环往复的周期，每个周期的终点会有一个同步点，这里叫栅栏Barrier，所以CyclicBarrier的名字就是这么来的。
 *
 * @author zhangzhiwang
 * @date Dec 27, 2019 9:59:39 AM
 */
public class CyclicBarrierTest1 extends Thread {
	private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);// 注意：这里的参数代表比需有n个线程到达阻塞点，如果少于n个线程到达阻塞点则会全部阻塞而不会唤醒，造成死锁的现象。
	
	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		CyclicBarrierTest1 t1 = new CyclicBarrierTest1();
		t1.setName("CyclicBarrierTest_1");
		t1.start();
		
		CyclicBarrierTest1 t2 = new CyclicBarrierTest1();
		t2.setName("CyclicBarrierTest_2");
		t2.start();
		
		System.out.println(Thread.currentThread().getName() + "到达同步点，开始阻塞");
		cyclicBarrier.await();
		System.out.println(Thread.currentThread().getName() + "继续运行。。。");
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
