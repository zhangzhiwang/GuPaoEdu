package com.asiainfo.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用Atomic解决原子性问题
 *
 * @author zhangzhiwang
 * @date 2021年5月14日 上午11:05:26
 */
public class AtomicTest implements Runnable {
	private static AtomicInteger atomicInteger = new AtomicInteger(0);

	@Override
	public void run() {
		atomicInteger.incrementAndGet();
	}

	public static void main(String[] args) {
		while (true) {
			List<Thread> list = new ArrayList<>();
			
			int loop = 100000;
			for (int i = 0; i < loop; i++) {
				list.add(new Thread(new AtomicTest()));
			}
			
			for(Thread t : list) {
				t.start();
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(atomicInteger.get());
			atomicInteger.set(0);
		}
	}
}
