package com.asiainfo.thread;

/**
 * 线程的生命周期
 * Java线程的生命周期一共有六个：
 * 1、新建（NEW）
 *    线程new出来之后start之前
 * 2、可运行状态（RUNNABLE）
 *    start之后线程进入可运行状态。Java线程的可运行状态包括了操作系统线程的两个状态：就绪状态（READY）和运行中状态（RUNNING），READY和RUNNING状态之间的互相切换是通过操作系统的调度，
 *    其中从RUNNING切换到READY还有另一种方式，就是显式地调用yield方法，该方法的作用就是当前线程主动让出cpu的使用权重新进入READY状态等待CPU的下次调度。
 * 3、等待状态（WAITING）
 * 	  当调用wait()、LockSupport.park()、join()方法时线程会进入等待状态，从等待状态切回到可运行状态的方法是notify()、notifyAll()、LockSupport.unpark(Thread)方法。
 * 	  通过看Thread类的join方法乐意得知：join()底层调用的是join(long)方法，join(long)方法底层调用的是wait(long)方法，所以本质上无论是join()还是join(long)方法实际上都是调用的wait(long)方法
 * 4、超时等待状态（TIMED_WAITING）
 *    当调用具有超时等待的方法时线程会进入超时等待状态，比如：sleep()、wait(long)、join(long)、LockSupport.parkNanos()、LockSupport.parkUntil()，
 *    由超时等待状态切换回等待状态的方法是：notify()、notifyAll()、LockSupport.unpark(Thread)，和WAITING->RUNNABLE的方式一样
 * 5、阻塞状态（BLOCKED）
 *    处于重量级锁竞争的时候会进入BLOCKED状态
 * 6、终止状态（TERMINATED）
 * 	  线程运行自然结束或异常结束则线程终止
 * 
 * @author zhangzhiwang
 * @date 2021年5月7日 上午10:49:38
 */
public class ThreadLifeCycle implements Runnable {
	public static void main(String[] args) throws InterruptedException {
		ThreadLifeCycle threadLifeCycle = new ThreadLifeCycle();
		Thread t1 = new Thread(threadLifeCycle);
		// NEW
//		System.out.println(t1.getState());
		
		// RUNNABLE、WAITING、TIMED_WAITING、TERMINATED
		t1.start();
		Thread.sleep(1000);
		System.out.println(t1.getState());
		
		// BLOCKED
//		Thread t2 = new Thread(threadLifeCycle);
//		t2.start();
//		Thread.sleep(1000);
//		System.out.println("t2.state = " + t2.getState());
	}

	@Override
	public void run() {
//		// 模拟线程RUNNABLE状态
//		while(true) {}
		
		// 模拟线程WAITING状态
//		synchronized (ThreadLifeCycle.class) {
//			try {
//				ThreadLifeCycle.class.wait();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
		// 模拟线程TIMED_WAITING状态
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		// 模拟线程BLOCKED状态
//		synchronized (ThreadLifeCycle.class) {
//			while(true) {}
//		}
		
		// 模拟线程TERMINATED状态
		String s = null;
		s.length();
	}
}
