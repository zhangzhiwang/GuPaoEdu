package com.asiainfo.p5.javaCore.multiThreads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的四种方式
 *
 * @author zhangzhiwang
 * @date 2019年12月18日 上午12:04:54
 */
public class CreateThread {
	public static void main(String[] args) {
		// 1、继承Thread类（略）
		// 2、实现Runnable接口（略）
		// 3、实现Callable接口
		Callable<Integer> callable = new MyThread1();
		FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);// FutureTask实现了Runnable接口
		Thread thread = new Thread(futureTask);
		thread.start();
		Integer result = 0;
		try {
			result = futureTask.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);

		// 4、线程池
		thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("hello");
			}
		});
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		executorService.execute(thread);
		executorService.shutdown();
	}

	static class MyThread1 implements Callable<Integer> {
		@Override
		public Integer call() throws Exception {
			return 1;
		}
	}
}
