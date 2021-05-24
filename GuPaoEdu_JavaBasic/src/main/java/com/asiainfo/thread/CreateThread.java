package com.asiainfo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的四种方式
 *
 * @author zhangzhiwang
 * @date 2021年5月6日 下午5:07:07
 */
public class CreateThread {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 方式1:实现Runnable接口
//		Thread a = new Thread(new A());
//		a.start();
		
		// 方式2:继承Thread类
//		Thread b = new B();
//		b.start();
		
		// 方式3:实现Callable接口（需要结合FutureTask来使用，注意是FutureTask不是Future，Future是使用线程池的方式submit方法的返回值）
//		FutureTask<String> futureTask = new FutureTask<String>(new C());
//		Thread c = new Thread(futureTask);// FutureTask也是Runnable的实现类
//		c.start();
//		System.out.println("result = " + futureTask.get());// futureTask.get()
		
		// 方式4:使用线程池
		ExecutorService executorService = Executors.newFixedThreadPool(1);
//		Future<String> result = executorService.submit(new C());
//		System.out.println("result = " + result.get());// Future.get()方法是阻塞的
		
		Future<?> r = executorService.submit(new A());
		System.out.println(r.get());
		
		/**
		 * 区别：
		 * 1、Callable接口有返回值
		 * 2、继承Thread的方式的缺点是一个线程类继承了Thread类就不能再继承其它的类了，但是接口可以实现多个，所以一般建议使用实现Runnable接口的方式
		 */
	}

	static class A implements Runnable {
		@Override
		public void run() {
			System.out.println("Thread A");
		}
	}

	static class B extends Thread {
		@Override
		public void run() {
			System.out.println("Thread B");
		}
	}

	static class C implements Callable<String> {// 泛型是返回值的类型
		@Override
		public String call() throws Exception {
			System.out.println("Thread C");
			Thread.sleep(10000);
			return "Thread C return...";
		}
	}
}
