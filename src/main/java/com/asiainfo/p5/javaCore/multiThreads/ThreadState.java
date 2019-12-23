package com.asiainfo.p5.javaCore.multiThreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程状态测试
 *
 * @author zhangzhiwang
 * @date Dec 23, 2019 1:59:57 PM
 */
public class ThreadState {
	private static Lock lock = new ReentrantLock();
	
	public static void main(String[] args) throws InterruptedException {
//		new MyThread("MyThread_1").start();
//		new MyThread("MyThread_2").start();
		
		MyThread myThread = new MyThread("MyThread_3");
		System.out.println(myThread.getState());// NEW
		
		myThread.start();
		Thread.sleep(1);
		System.out.println(myThread.getState());// RUNNABLE/TERMINATED/TIMED_WAITING/WAITING
	}
	
	static class MyThread extends Thread {
		public MyThread(String name) {
			super(name);
		}
		
		public void  run() {
//			lock.lock();// 等待lock.lock()锁的线程出于waiting状态，而不是timed_waiting状态
//			try {
//				Thread.sleep(Integer.MAX_VALUE);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//			lock.unlock();
			
//			while(true) {}
			
			synchronized (MyThread.class) {
				try {
					MyThread.class.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
