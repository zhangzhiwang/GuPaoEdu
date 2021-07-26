package com.asiainfo.thread.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest implements Runnable {
	private Lock lock = new ReentrantLock();
	private static int count;
	
	@Override
	public void run() {
		lock.lock();
		for (int i = 0; i < 100; i++) {
			count++;
		}
		lock.unlock();
	}
	
	public static void main(String[] args) {
		List<Thread> list = new ArrayList<>();
		LockTest lockTest = new LockTest();
		for (int i = 0; i < 1000; i++) {
			list.add(new Thread(lockTest));
		}
		
		for (Thread thread : list) {
			thread.start();
		}
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(count);
	}
}
