package com.asiainfo.p6_2020.multithreading;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * volatile可见性
 *
 * @author zhangzhiwang
 * @date May 23, 2020 10:07:20 AM
 */
public class VolatileVisibility extends Thread {
	private static  boolean flag = false;
	
	public void run() {
		int i = 0;
		while(!flag) {
			i++;
			// 如果flag不加volatile，以下四种方式也能保证可见性
			// 方式1:
//			System.out.println("i = " + i);
			
			// 方式2:
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			
			// 方式3:
//			Thread.yield();
			
			// 方式4:IO
//			try {
//				InputStream inputStream = new FileInputStream("");
//			} catch (FileNotFoundException e) {
//			}
		}
		System.out.println("i = " + i);
	}
	
	public static void main(String[] args) throws InterruptedException {
		VolatileVisibility volatileVisibility = new VolatileVisibility();
		volatileVisibility.start();
		
		Thread.sleep(1000);
		flag = true;
	}
}
