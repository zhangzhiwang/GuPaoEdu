package com.asiainfo.p5.javaCore.multiThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 *
 * @author zhangzhiwang
 * @date Dec 27, 2019 7:25:20 PM
 */
public class ThreadPoolTest {
	public static void main(String[] args) throws InterruptedException {
		// 创建一个线程池只需要新建一个ThreadPoolExecutor对象即可
		// 创建一个线程池
//		new ThreadPoolExecutor(
//				corePoolSize, // 线程池的核心线程数
//				maximumPoolSize, // 线程池的最大线程数
//				keepAliveTime, // 空闲线程最大存活时间
//				unit, // 空闲线程最大存活时间的时间单位
//				workQueue, // 任务阻塞队列
//				threadFactory, // 创建线程的工厂
//				handler // 拒绝策略
//				);

		// 由于ThreadPoolExecutor的构造方法参数过多，所以为了减少新建线程池的难度，Java的JUC提供了一个工具类Executors，它根据不同的适用场景来对传入ThreadPoolExecutor构造器的参数进行不同的调整和优化，从而提供了几种常用的线程池。
		// Executors可以创建常用的四种线程池：
		// 1、创建固定线程数的线程池
		/**
		 * 需要传入线程数量，FixedThreadPool将核心线程数和最大线程数都设置为传入的值n，最大存活时间设置为0，阻塞队列用的是LinkedBlockingQueue
		 */
		ExecutorService threadPool1 = Executors.newFixedThreadPool(10);// 线程池的核心线程数是10。该线程池每来一个任务就会创建一个线程来执行任务，直到线程数量达到设定的核心线程数10为止。
		
		// 2、创建单个线程的线程池
		/**
		 * SingleThreadExecutor默认将核心线程数和最大线程数都设置为1，keepAliveTime设置为0，阻塞队列用的是LinkedBlockingQueue
		 */
		ExecutorService threadPool2 = Executors.newSingleThreadExecutor();
		
		// 3、创建根据需要可伸缩的线程池
		/**
		 * CachedThreadPool将核心线程数设置为0，也就是没有核心线程，最大线程数设置为Integer的最大值，最大空闲存活时间为60s，阻塞队列用的是SynchronousQueue
		 */
		ExecutorService threadPool3 = Executors.newCachedThreadPool();
		
		// 4、创建具有周期性和定时调度的线程池
		/**
		 * ScheduledThreadPool的核心线程数是传入的值，最大线程数设置为Integer的最大值，最大空闲存活时间为0s，阻塞队列用的是DelayedWorkQueue
		 */
		ScheduledExecutorService threadPool4 = Executors.newScheduledThreadPool(10);
		// 以上四种通过Executors来创建线程池的方式实际上也是新建ThreadPoolExecutor对象，只不过它们在调用ThreadPoolExecutor构造方法的时候传的入參不一样。
		
		/**
		 *  另外，线程池中是不区分核心线程和非核心线程的，也就是说并没有一个变量来标识一个线程是否为核心线程，线程池只是维护两个数量——核心线程数和最大线程数。</p>
		 *  当一个线程出于等待任务状态时，它最多存活keepAliveTime这么长时间，超过这个时间就会被回收调，线程池允许回收（maximumPoolSize - corePoolSize）个线程，直到线程数减少到corePoolSize时停止回收
		 */
		
		// 线程池监控
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 15, 5, TimeUnit.SECONDS, new LinkedBlockingQueue());
		threadPoolExecutor.prestartAllCoreThreads();// 线程池先创建好10个线程作为核心线程等待任务的到来，如果不调用本方法，那么任务到来的时候会现创建一个线程来运行，再来一个再创建一个直到达到核心线程数为止。
		System.out.println("核心线程数：" + threadPoolExecutor.getCorePoolSize());
		System.out.println("最大线程数：" + threadPoolExecutor.getMaximumPoolSize());
		System.out.println("线程池中也有线程数：" + threadPoolExecutor.getPoolSize());
		System.out.println("线程池中活跃（处于工作状态）线程数：" + threadPoolExecutor.getActiveCount());
		threadPoolExecutor.execute(new Runnable() {
			@Override
			public void run() {
				while(true) {}
			}});
		Thread.sleep(10);
		System.out.println("线程池中活跃（处于工作状态）线程数：" + threadPoolExecutor.getActiveCount());
	}
}
