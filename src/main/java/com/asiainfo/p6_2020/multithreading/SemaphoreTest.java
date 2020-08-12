package com.asiainfo.p6_2020.multithreading;

import java.util.concurrent.Semaphore;

/**
 * 信号量Semaphore可用于实现高并发场景下的限流
 *
 * @author zhangzhiwang
 * @date Jun 28, 2020 10:45:30 AM
 */
public class SemaphoreTest {
	public static void main(String[] args) {
		final Semaphore semaphore = new Semaphore(3);
		
		for(int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						while(true) {
							// 获取许可证
							boolean tryAcquire = semaphore.tryAcquire();
							if(tryAcquire) {
								System.out.println(Thread.currentThread().getName() + "获取了许可证，开始执行业务逻辑");
//								Thread.sleep(10);
								// 释放许可证
								semaphore.release();
								System.out.println(Thread.currentThread().getName() + "释放了许可证");
								break;
							} else {
								System.out.println(Thread.currentThread().getName() + "没有获取许可证");
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}, "Thread-" + i).start();
		}
	}
}
