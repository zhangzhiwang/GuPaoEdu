package com.asiainfo.thread;

/**
 * 终止线程的方式：
 * 1、stop
 * 	  简单粗暴，相当与用电脑的过程中突然拔电源，正在运行的进行突然被kill -9，什么时候线程被停止不可预测，可能会导致打开的资源没有关闭或者线程运行结束前一些收尾或者清理的工作没有做，会引发一些问题
 * 2、使用共享flag
 * 	  注意要使用volatile修饰以保证对变量修改的可见性
 * 3、使用iterrupt()方法和interrupted()/isInterrupted()方法
 *    本质上和第二点使用共享flag一样，只不过这个“flag”不是java代码维护的，是在jvm里面维护的，查看jvm的源码可以看到iterrupt()方法是将这一个变量设置为false，interrupted()/isInterrupted()方法就是来检查这个变量。
 *    第二点和第三点的就是说外界给一个正在运行的线程一个中断信号，告诉这个线程可以停止了，具体是否要停止以及什么时候停止是由被通知的线程自己说了算。
 *    另外，第二点和第三点这两种方式只有在被通知的线程里面有循环判断中断标识或者有等待情况的时候（比如sleep、wait等）才有意义。
 *    为什么具有等待功能的方法（比如sleep、wait等）要声明抛出InterruptedException异常？一种可能的原因是要区分线程是“自然睡醒”的还是“被叫醒”的，可能java的设计者设计用抛异常的方式来表达线程是被外界叫醒的，try/catch之后可以继续运行后面的代码，
 *    如果不作区分，sleep后继续运行后面的代码，那怎么知道该线程是“自然睡醒”还是“被叫醒”的呢？
 *
 * @author zhangzhiwang
 * @date 2021年5月7日 下午5:22:11
 */
public class TerminateThreadTest implements Runnable {
	private static volatile boolean flag = false;
	
	@Override
	public void run() {
//		while(true) {}
//		while(!flag) {}
//		while(!Thread.interrupted()) {}
		while(Thread.currentThread().isInterrupted()) {}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new TerminateThreadTest());
		t.start();
		
		Thread.sleep(1000);
		System.out.println("我要终止线程");
//		t.stop();
//		flag = true;
		t.interrupt();
	}
}
