package com.asiainfo.thread;

/**
 * 优雅地终止线程-interrupt
 *
 * @author zhangzhiwang
 * @date 2021年5月13日 下午2:54:27
 */
public class InterruptTest implements Runnable {
	@Override
	public void run() {
		/**
		 * 当外界调用interrupt()方法来终止线程的时候，只是给线程发出了一个信号，这个信号就是改变中断标志位的值，线程本身必须去不断地判断这个标识位从而做出相关的反应，
		 * 注意这里强调的是“不断地判断“，而达到“不断地判断“这样的效果一般是在循环里进行判断。判断的方式就是使用Thread类的interrupted()和isInterrupted()方法。
		 * interrupted()和isInterrupted()方法的相同点和不同点：
		 * 1、二者都是响应外界中断请求的方式，都去检查中断标识位。
		 * 2、isInterrupted()是实例方法，interrupted()是静态方法。查看interrupted()方法的源码可以看出，内部是调用当前线程的isInterrupted()方法。
		 * 3、isInterrupted()方法不清除中断位，interrupted()方法清除中断位（对中断标识进行复位）。
		 * 	  中断标识位的复位以便于下次可以再次被中断。举个场景：一个正在运行逻辑A的线程被通知可以中断了，那么这个线程判断中断位标识变化后会运行另一部分逻辑B，在逻辑B里面还有一个while循环来不断判断中断标识位，
		 * 	  当逻辑B判断线程中断位被改变后（第二次被中断）会运行逻辑C，在逻辑C里面仍然有while循环……
		 * 	  当外界请求中断线程的时候，该线程是不是要退出取决于线程自己，如果线程在接收到外界中断建议的时候选择仍然继续运行后面的代码，万一后面的代码也有while循环或者有阻塞的方法怎么办，仍然需要被外界再次中断，清除标识位的作用就在这里。
		 *    如果不清除标识位那么后面的代码就不能继续判断标识位了从而运行其它逻辑了。
		 */
//		while(!Thread.currentThread().isInterrupted()) {}
//		while(!Thread.interrupted()) {}
		
		// 测试中断位的清除
//		try {
////			boolean interrupted = Thread.currentThread().isInterrupted();
//			boolean interrupted = Thread.interrupted();
//			System.out.println("	" + interrupted);
//			while(!Thread.interrupted()) {
//				System.out.println("	" + interrupted);
//			}
////			interrupted = Thread.currentThread().isInterrupted();
//			interrupted = Thread.interrupted();
//			System.out.println(interrupted);
////			interrupted = Thread.currentThread().isInterrupted();
//			interrupted = Thread.interrupted();
//			System.out.println(interrupted);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		// 清除中断位的场景
//		while(!Thread.interrupted()) {
//			metA();// 如果外界没有中断就一直运行逻辑A
//		}
//		
//		metB();// 当外界第一次中断后会运行逻辑B
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {// InterruptedException清除中断标识位
			e.printStackTrace();
		}
		boolean interrupted = Thread.currentThread().isInterrupted();
		System.out.println(interrupted);
	}
	
	private void metB() {// 逻辑B里面仍然后while循环判断中断标识
		while(!Thread.interrupted()) {
			metC();// 如果外界没有第二次中断则一直运行逻辑C
		}
		
		metD();// 一旦有第二次中断则运行逻辑D
	}

	private void metD() {
		
	}

	private void metC() {
		
	}

	private void metA() {
		// 逻辑A
	}

	public static void main(String[] args) {
		Thread t = new Thread(new InterruptTest());
		t.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t.interrupt();
	}
}
