package com.asiainfo.thread.aqs;

import java.util.concurrent.Semaphore;

/**
 * Semaphore信号量——最多允许N个线程同时执行，一般用于限流
 *
 * @author zhangzhiwang
 * @date 2021年6月7日 上午11:00:39
 */
public class SemaphoreTest {
	public static void main(String[] args) {
		// 应用场景：停车场有5个车位，最多允许停5辆车，每一辆车入库的时候要在门口获取一个通行证，出库的时候要将通行证归还，如果车位已满其他车辆只能在入口处等待。
		Semaphore semaphore = new Semaphore(10);// 停车场最多有10个停车位，门口保安手里面只有10张通行证
		for (int i = 0; i < 100; i++) {// 有1000辆车要进停车场
			new Thread(new Runnable() {
				@Override
				public void run() {
					int permits = semaphore.availablePermits();// 返回可用令牌数量，即保安手里还有几张未领取的通行证
					System.out.println(Thread.currentThread().getName() + "要进入停车场，看了眼门口屏幕，显示可用车位还有" + permits);
					
					try {
						semaphore.acquire();// 获取令牌，向保安要一张通行证，如获取不到就阻塞在这里
						System.out.println(Thread.currentThread().getName() + "成功领取通行证进入停车场");
						Thread.sleep(100);// 在停车场停了100ms
						semaphore.release();// 归还令牌
						System.out.println("\t" + Thread.currentThread().getName() + "驶出停车场并归还通行证");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}, "Thread_" + i).start();
		}
	}
}