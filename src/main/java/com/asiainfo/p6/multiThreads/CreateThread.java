package com.asiainfo.p6.multiThreads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的四种方式
 *
 * @author zhangzhiwang
 * @date Dec 11, 2019 1:20:59 PM
 */
public class CreateThread {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 1、实现Runnable接口
		Thread1 t1 = new Thread1();
		Thread thread = new Thread(t1);
		thread.start();
		
		// 2、继承Thread类
		Thread2 t2 = new Thread2();
		t2.start();
		
		// 3、实现Callable接口
		Callable<Integer> t3 = new Thread3();
		FutureTask<Integer> futureTask = new FutureTask<Integer>(t3);
		Thread thread2 = new Thread(futureTask);
		thread2.start();
		Integer r = futureTask.get();
		System.out.println(r);
		
		// 4、使用线程池
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
		newFixedThreadPool.execute(t2);
		newFixedThreadPool.shutdown();
	}
	
	public void met1() {
		int i = 0;
		int b = i++;
		synchronized (this) {
			System.out.println();
		}
		
		i = b + i;
	}

	static class Thread1 implements Runnable {
		@Override
		public void run() {
			System.out.println("Thread1");
		}
	}
	
	static class Thread2 extends Thread {
//		@Override
//		public void run() {
//			System.out.println("Thread2");
//		}
	}
	
	static class Thread3 implements Callable<Integer> {
		@Override
		public Integer call() throws Exception {
			Thread.sleep(3000);
			return 1;
		}}
}
