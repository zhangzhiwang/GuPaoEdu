package com.asiainfo.p5.javaCore.multiThreads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Fork/Join框架——用于将一个大任务拆分成若干小任务，然后合并小任务的计算结果最终得到大任务的计算结果。
 * </p>
 * 这里面有一个经典的算法——工作窃取算法。工作窃取算法就是每一个线程维护一个双端队列，里面存放需要被处理的任务，当某个线程处理完自己负责的队列里的任务后会从其他线程的队列尾端窃取一个任务来执行。
 * </p>
 * 之所以是双端队列是因为为了减少不同线程对同一个任务的竞争，线程在处理自己队列里的任务时是从头部获取任务，而从其他队列获取任务时是从尾部获取。
 * </p>
 * 工作窃取算法就是自己的活干完了去帮别人干，从而提高了整个系统的性能。
 *
 * @author zhangzhiwang
 * @date Dec 28, 2019 10:01:25 AM
 */
public class ForkJoinTest extends RecursiveTask<Integer> {
	private final int THRESHOLD = 51;// 一个大任务可以拆分成若干小任务，每个小任务还可以继续拆分直到子任务不可拆分为止，这里就要定义一个阈值来定义什么样的任务不能再拆分。
	private int start;
	private int end;

	private ForkJoinTest(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 需求：计算1-1000的累加值
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		Future<Integer> result = forkJoinPool.submit(new ForkJoinTest(1, 1000));
		System.out.println(result.get());
	}

	@Override
	protected Integer compute() {
		boolean canSplit = (end - start) > THRESHOLD;
		if(canSplit) {// 说明可以继续拆分
			ForkJoinTest forkJoinTest1 = new ForkJoinTest(start, (end + start) / 2);
			forkJoinTest1.fork();// fork方法会自动调用compute方法
			ForkJoinTest forkJoinTest2 = new ForkJoinTest(((end + start) / 2) + 1, end);
			forkJoinTest2.fork();
			
			return forkJoinTest1.join() + forkJoinTest2.join();
		} else {
			int sum = 0;
			for(int i = start; i <= end; i++) {
				sum += i;
			}
			return sum;
		}
	}
}
