package com.asiainfo.p5.javaCore.multiThreads;

/**
 * 模拟死锁</p>
 *
 * @author zhangzhiwang
 * @date Dec 28, 2019 12:42:53 AM
 */
public class DeadLock {
	public static void main(String[] args) {
		Object o1 = new Object();
		Object o2 = new Object();
		
		new ThreadA(o1, o2, "T1").start();
		new ThreadB(o1, o2, "T2").start();
	}
	
	static class ThreadA extends Thread {
		private Object o1;
		private Object o2;
		
		private ThreadA(Object o1, Object o2, String name) {
			super(name);
			this.o1 = o1;
			this.o2 = o2;
		}

		public void run() {
			synchronized (o1) {
				System.out.println(Thread.currentThread().getName() + "获得了锁o1");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (o2) {
					System.out.println(Thread.currentThread().getName() + "获得了锁o2");
				}
			}
		}
	}
	
	static class ThreadB extends Thread {
		private Object o1;
		private Object o2;
		
		private ThreadB(Object o1, Object o2, String name) {
			super(name);
			this.o1 = o1;
			this.o2 = o2;
		}
		
		public void run() {
			synchronized (o2) {
				System.out.println(Thread.currentThread().getName() + "获得了锁o2");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (o1) {
					System.out.println(Thread.currentThread().getName() + "获得了锁o1");
				}
			}
		}
	}
}
