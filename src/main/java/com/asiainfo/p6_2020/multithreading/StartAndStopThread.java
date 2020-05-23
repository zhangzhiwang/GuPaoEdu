package com.asiainfo.p6_2020.multithreading;

/**
 * 启动和终止线程
 *
 * @author zhangzhiwang
 * @date May 21, 2020 10:29:38 AM
 */
public class StartAndStopThread extends Thread {
	public static void main(String[] args) {
		StartAndStopThread startAndStopThread = new StartAndStopThread();
		startAndStopThread.start();// 涉及面试题：为什么启动线程用start方法而不是直接调用run方法？
		
		// 线程终止的方式：1、线程自然运行结束 2、线程抛异常结束 3、外部线程调用stop方法 4、设置中断标记，通过改变中断标记来结束线程，实现的方式可以自己定义一个中断变量或者调用interrupt方法
//		startAndStopThread.stop();// 涉及面试题：为什么不使用stop方法来结束线程
		startAndStopThread.interrupt();// 优雅结束线程的方式——这是终端标记，具体做法有两种：一个是调用interrupt方法，一个是自己设置终端标记
		
		/**
		 * interrupted和isInterrupted方法的区别：</p>
		 * 1、名字短的是静态的。interrupted是静态方法，isInterrupted是实例方法。静态方法判断的是当前线程，非静态方法判断的是指定线程的。</p>
		 * 2、interrupted方法清除中断状态，isInterrupted方法则不清除状态
		 */
		
//		System.out.println("isInterrupted : " + startAndStopThread.isInterrupted());// 名字长的是实例方法，判断指定线程startAndStopThread的中断状态，由于上面已经设置为true所以返回true
//		System.out.println("interrupted : " + startAndStopThread.interrupted());// 名字短的静态方法，静态方法判断的是当前线程的中断状态，即使调用的对象是startAndStopThread，但实际上判断的是main线程的中断状态，由于main线程并没有调用interrupt方法所以返回false
		
		// sleep不释放锁资源但是会释放cpu资源，让给其他线程执行，sleep(0)的作用就是让出cpu资源重新进行cpu时间片的分配，下一次获得cpu的可能是该线程也可能是其他线程；wait既会释放锁资源也会释放cpu资源
	}
	
	public void run() {
//		while(Thread.currentThread().isInterrupted()) {// 涉及面试题：interrupted和isInterrupted方法的区别
//			
//		}
		
		for(int i = 0; i < 100000; i++) {
			
		}
//		boolean interrupted1 = Thread.interrupted();
//		System.out.println("interrupted1 = " + interrupted1);// true
//		
//		boolean interrupted2 = Thread.interrupted();
//		System.out.println("interrupted2 = " + interrupted2);// false
		
//		boolean interrupted3 = this.isInterrupted();
//		System.out.println("interrupted3 = " + interrupted3);// true
//		
		boolean interrupted4 = this.isInterrupted();
		System.out.println("interrupted4 = " + interrupted4);// true
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean interrupted5 = this.isInterrupted();
		System.out.println("interrupted5 = " + interrupted5);// false
	}
}
