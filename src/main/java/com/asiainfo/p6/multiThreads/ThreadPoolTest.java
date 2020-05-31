package com.asiainfo.p6.multiThreads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * 线程池测试
 *
 * @author zhangzhiwang
 * @date 2020年5月31日 上午11:00:51
 */
public class ThreadPoolTest {
	public static void main(String[] args) {
		/**
		 *  java的线程池都是通过Executors工厂类来创建的，Executors可以创建三种类型的线程池：固定线程数的线程池FixedThreadPool、单一线程的线程池SingleThreadExecutor和带缓冲的线程池CachedThreadPool。
		 *  这三种线程池并无本质上的差别，最终都是调用ThreadPoolExecutor的构造方法，只不过转入的参数不一样罢了。
		 */
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);// 核心线程数=最大线程数，使用无界队列LinkedBlockingQueue
		ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();// 核心线程数=最大线程数=1，其它和FixedThreadPool一样，使用无界队列LinkedBlockingQueue
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();// 核心线程数是0，最大线程数是Integer的最大值，过期时间是60s，阻塞队列用不存储元素的SynchronousQueue
		
		newFixedThreadPool.shutdown();
		newCachedThreadPool.shutdown();
		newSingleThreadExecutor.shutdownNow();
		
		/**
		 * 完整的ThreadPoolExecutor的构造函数如下：
		public ThreadPoolExecutor(
				int corePoolSize, //核心线程数
                int maximumPoolSize, // 最大线程数
                long keepAliveTime,// 空闲线程存活时间
                TimeUnit unit,// keepAliveTime的单位
                BlockingQueue<Runnable> workQueue,// 阻塞队列
                ThreadFactory threadFactory,// 线程工厂
                RejectedExecutionHandler handler// 拒绝策略，常见的有拒绝并抛异常、丢弃、把阻塞队列里面停留时间最长的任务丢弃掉
                ) {}
        */
	}
}
