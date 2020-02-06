/**
 * 
 */
package com.asiainfo.p5.javaCore.javaBasic.exception;

/**
 * finally语句块测试
 *
 * @author Administrator
 * @date 2020年2月4日 下午10:00:12
 */
public class FinallyTest {
	public static void main(String[] args) throws InterruptedException {
//		int[] a = new int[1];
//		int i = a[3];
//		try {
////			Thread.sleep(1000000);
//			System.out.println("try");
//			System.exit(0);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			System.out.println("finally");
//		}
		
		FT ft = new FT();
		ft.setDaemon(true);
		ft.start();
		
		Thread.sleep(3000);
	}

	static class FT extends Thread {
		public void run() {
			try {
				System.out.println("子线程");
				Thread.sleep(10000);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println("子线程finally");
			}
		}
	}
}
