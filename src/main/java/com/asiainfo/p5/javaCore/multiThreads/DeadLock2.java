package com.asiainfo.p5.javaCore.multiThreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁解决方案
 * </p>
 * 首先已经死锁了没有什么好的解决方案，只能停掉进程找出问题然后重启。平时说的“怎么解决死锁”其实说的是怎么预防死锁。
 *
 * @author zhangzhiwang
 * @date Dec 28, 2019 12:42:53 AM
 */
public class DeadLock2 {
	public static void main(String[] args) {
		Lock lock1 = new ReentrantLock();
		Lock lock2 = new ReentrantLock();

		new ThreadA(lock1, lock2).start();
		new ThreadB(lock2, lock1).start();
	}

	static class ThreadA extends Thread {
		private Lock lock1;
		private Lock lock2;

		private ThreadA(Lock lock1, Lock lock2) {
			super();
			this.lock1 = lock1;
			this.lock2 = lock2;
		}

//		public void run() {
//			synchronized (o1) {
//				System.out.println(Thread.currentThread().getName() + "获得了锁o1");
//				try {
//					Thread.sleep(10);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				synchronized (o2) {
//					System.out.println(Thread.currentThread().getName() + "获得了锁o2");
//				}
//			}
//		}
		public void run() {
			if (lock1.tryLock()) {
				System.out.println(Thread.currentThread().getName() + "获得了锁o1");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (lock2.tryLock()) {
					System.out.println(Thread.currentThread().getName() + "获得了锁o2");
				}
				lock2.unlock();
			}
			lock1.unlock();
		}
	}

	static class ThreadB extends Thread {
		private Lock lock1;
		private Lock lock2;

		private ThreadB(Lock lock1, Lock lock2) {
			super();
			this.lock1 = lock1;
			this.lock2 = lock2;
		}

//		public void run() {
//			synchronized (o2) {
//				System.out.println(Thread.currentThread().getName() + "获得了锁o2");
//				try {
//					Thread.sleep(10);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				synchronized (o1) {
//					System.out.println(Thread.currentThread().getName() + "获得了锁o1");
//				}
//			}
//		}
		public void run() {
			if (lock2.tryLock()) {
				System.out.println(Thread.currentThread().getName() + "获得了锁o2");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (lock1.tryLock()) {
					System.out.println(Thread.currentThread().getName() + "获得了锁o1");
				}
				lock1.unlock();
			}
			lock2.unlock();
		}
	}
}
