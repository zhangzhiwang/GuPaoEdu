package com.asiainfo.p5.javaCore.multiThreads;

/**
 * 线程可见性测试
 *
 * @author zhangzhiwang
 * @date Dec 25, 2019 9:51:41 AM
 */
public class VisibilityTest extends Thread {
	private static boolean isStop = false;
	private static long num = 0;
	
	public static void main(String[] args) throws InterruptedException {
		VisibilityTest visibilityTest = new VisibilityTest();
		visibilityTest.setName("VisibilityTest");
		visibilityTest.start();
		
		Thread.sleep(1000);
		isStop = true;
		System.out.println(num);
	}
	
	public void run() {
		while(!isStop) {
			num=10;
		}
		System.out.println("已经停止了");
	}
}
