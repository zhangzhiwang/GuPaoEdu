package com.asiainfo.p5.javaCore.multiThreads;

/**
 * 线程可见性测试
 *
 * @author zhangzhiwang
 * @date Dec 25, 2019 9:51:41 AM
 */
public class VisibilityTest extends Thread {
	private static boolean isStop = false;// 没有加volatile
	private static int num = 0;
	
	public static void main(String[] args) throws InterruptedException {
		VisibilityTest visibilityTest = new VisibilityTest();
		visibilityTest.setName("VisibilityTest");
		visibilityTest.start();
		
		Thread.sleep(100);
		isStop = true;
	} 
	
	@SuppressWarnings("unused")
	public void run() {
		int i = 0;
		while(!isStop) {
			num=10;
			synchronized (VisibilityTest.class) {
				// 无意义的同步快，目的是测试synchronized对线程可见性的影响
			}
		}
	}
}
