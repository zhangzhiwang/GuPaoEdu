package com.asiainfo.jvm;

/**
 * 用jstack、jconsole、jvisualvm查看线程死锁
 *
 * @author zhangzhiwang
 * @date 2021年4月12日 下午3:23:35
 */
public class DeadLock extends Thread {
	Object o1 = new Object();
	Object o2 = new Object();
	
	public void run() {
		try {
			if(currentThread().getName().equals("t1")) {
				m1();
			} else {
				m2();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void m1() throws InterruptedException {
		synchronized (o1) {
			Thread.sleep(1000);
			synchronized (o2) {
				System.out.println("m1");
//				while(true) {}
			}
		}
	}
	
	public void m2() throws InterruptedException {
		synchronized (o2) {
			Thread.sleep(1000);
			synchronized (o1) {
				System.out.println("m2");
//				while(true) {}
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		DeadLock d = new DeadLock();
		Thread t1 = new Thread(d, "t1");
		t1.start();
		Thread.sleep(10);
		Thread t2 = new Thread(d, "t2");
		t2.start();
	}
}
