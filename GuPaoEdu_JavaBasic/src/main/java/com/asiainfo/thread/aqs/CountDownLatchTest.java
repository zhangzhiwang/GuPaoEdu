package com.asiainfo.thread.aqs;

import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch——当count的数量减到0的时候唤醒所有调用await()方法而阻塞的线程
 *
 * @author zhangzhiwang
 * @date 2021年6月7日 上午10:17:22
 */
public class CountDownLatchTest {
	private static int count = 0;
	
	public static void main(String[] args) {
		// 应用场景1:发令枪，主线程一声令下，其他线程同时开跑
//		CountDownLatch countDownLatch = new CountDownLatch(1);// 在这种使用场景下，count的初始值一般设置为1
//		for (int i = 0; i < 5; i++) {
//			new Thread(new Runnable() {
//				@Override
//				public void run() {
//					try {
//						System.out.println(Thread.currentThread().getName() + "已准备就绪...");
//						countDownLatch.await();// 每个线程启动后先调用await()方法来阻塞，等待发令枪，然后同时起跑
//						System.out.println(Thread.currentThread().getName() + "开始运行了！");
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}, "Thread_" + i).start();
//		}
//		
//		try {
//			Thread.sleep(5000);
//			System.out.println("-----------------");
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		countDownLatch.countDown();// 主线程一声令下（使count减为0）
		
		// 应用场景2:主线程汇总每个线程的执行结果后的结果
		CountDownLatch countDownLatch = new CountDownLatch(5);
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (CountDownLatchTest.class) {
						count++;
						countDownLatch.countDown();
					}
				}
			}).start();
		}
		
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(count);// 对各线程的执行结果进行汇总
	}
}
