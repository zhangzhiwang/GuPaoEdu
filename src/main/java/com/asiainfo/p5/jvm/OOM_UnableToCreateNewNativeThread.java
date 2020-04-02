package com.asiainfo.p5.jvm;

/**
 * 模拟java.lang.OutOfMemoryError: unable to create new native thread
 *
 * @author zhangzhiwang
 * @date Mar 31, 2020 5:44:14 PM
 */
public class OOM_UnableToCreateNewNativeThread {
	public static void main(String[] args) {
		for(int i = 0; i < Integer.MAX_VALUE; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(Integer.MAX_VALUE);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
			System.out.println(i);
		}
	}
}
