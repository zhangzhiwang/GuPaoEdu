package com.asiainfo.p6_2020.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式
 *
 * @author zhangzhiwang
 * @date May 19, 2020 5:01:07 PM
 */
public class CreateThread {
	public static void main(String[] args) {
		// 创建线程一共有四种方式：1、实现Runnalbe接口 2、继承Thread类 3、实现Callable接口 4、使用线程池
		// 前两种方式省略
		// 3、实现Callable接口
		Callable<Integer> callable = new CreateThreadInner();
		FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
		Thread thread = new Thread(futureTask);
		thread.start();

		try {
			Integer result = futureTask.get();// 阻塞当前线程
			System.out.println("result = " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("-----------------");
		// 4、使用线程池
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("hello");
			}
		};
		
		newFixedThreadPool.submit(runnable);
		Future<Integer> f = newFixedThreadPool.submit(callable);
		Integer result2 = 0;
		try {
			result2 = f.get();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println("result2 = " + result2);
	}

	static class CreateThreadInner implements Callable<Integer> {
		@Override
		public Integer call() throws Exception {
			System.out.println("进入call方法");
			Thread.sleep(3000);
			return 123;
		}
	}
}
