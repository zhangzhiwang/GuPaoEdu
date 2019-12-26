package com.asiainfo.p5.javaCore.multiThreads;

import java.util.concurrent.Semaphore;

/**
 * semaphore信号灯，主要起限流作用，即最多允许n个线程同时访问
 *
 * @author zhangzhiwang
 * @date Dec 26, 2019 10:07:33 PM
 */
public class SemaphoreTest {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(5);
		for(int i = 1; i <= 10; i++) {
			Car car = new Car(semaphore);
			car.setName("Car_" + i);
			car.start();
		}
	}
	
	static class Car extends Thread {
		private Semaphore semaphore;

		private Car(Semaphore semaphore) {
			super();
			this.semaphore = semaphore;
		}
		
		public void run() {
			try {
				semaphore.acquire();// 获取许可证，只有获取了许可证的线程才能访问，同一时刻最多发放n个许可证，没有获得许可证的线程会被阻塞
				System.out.println(Thread.currentThread().getName() + "获得了许可证");
				System.out.println(Thread.currentThread().getName() + "离开...");
				semaphore.release();// 释放许可证，线程运行结束时要归还许可证
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
