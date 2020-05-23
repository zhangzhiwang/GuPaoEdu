package com.asiainfo.p6_2020.multithreading;

/**
 * 线程状态
 *
 * @author zhangzhiwang
 * @date May 20, 2020 10:48:19 AM
 */
public class ThreadStatus extends Thread {
	public static void main(String[] args) throws Exception {
		// Java线程一种有6种状态：NEW、TERMINATED、RUNNABLE、BLOCKED、WAITING、TIMED_WATING
		// 操作系统（OS）线程一共有5种状态：READY、RUNNING、BLOCKED、WAITING、TIMED_WATING。和Java线程状态的区别是：没有新建和销毁状态，将Java的可运行状态分为就绪和运行状态、其他三个状态一样
		ThreadStatus threadStatus = new ThreadStatus();
		State state1 = threadStatus.getState();
		System.out.println(state1);// NEW
		
		threadStatus.start();
		Thread.sleep(1);
		State state2 = threadStatus.getState();
		System.out.println(state2);// RUNNABLE、TIMED_WATING、WAITING
		
		Thread.sleep(1);
		ThreadStatus threadStatus2 = new ThreadStatus();
		threadStatus2.start();
		Thread.sleep(10);
		State state3 = threadStatus2.getState();
		System.out.println(state3);// BLOCKED、TERMINATED
	}

	public void run() {
		System.out.println("hello");
//		while(true) {}
		
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
//		synchronized(ThreadStatus.class) {
//			try {
//				System.out.println(Thread.currentThread().getName());
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	}
}
