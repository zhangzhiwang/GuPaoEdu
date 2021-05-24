package com.asiainfo.thread;

import java.util.HashMap;
import java.util.Map;

/**
 * join方法
 *
 * @author zhangzhiwang
 * @date 2021年5月7日 上午11:29:10
 */
public class JoinTest {
	private static int i = 0;

	public static void main(String[] args) throws InterruptedException {
		for (int j = 0; j < 1000; j++) {
			Thread t1 = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					i = 10;
				}
			});
			t1.start();
			
			/**
			 * join方法的本质是调用wait()方法，通过查看源码得知：join()方法调用join(long)方法，join(long)方法调用wait(long)方法，所以调用join方法主线程会阻塞，
			 * 当t1线程执行结束后会唤醒主线程，唤醒的逻辑是在jvm里面实现的而非java代码实现。
			 */
			t1.join();
			
			Thread t2 = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					i++;
				}
			});
			t2.start();

			Thread.sleep(10);

			System.out.println(i);
			i = 0;
		}

	}
}
