package com.asiainfo.jvm;

//import java.awt.List;
import java.util.ArrayList;
import java.util.List;

/**
 * java.lang.OutOfMemoryError: Java heap space
 *
 * @author zhangzhiwang
 * @date 2021年4月8日 下午2:45:10
 */
public class OOM_HeapSpace {
	public static void main(String[] args) throws InterruptedException {
		// -Xms10m -Xmx10m
//		List<byte[]> list = new ArrayList<>();
//		while(true) {
//			list.add(new byte[5120]);
////			Thread.sleep(1);
//		}
//		List<User> list = new ArrayList<>();
//		while(true) {
//			list.add(new User());
//		}
		MyController myController = new MyController();
		myController.query();
	}
}
