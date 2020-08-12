package com.asiainfo.p5.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出
 *
 * @author zhangzhiwang
 * @date Jan 14, 2020 11:05:24 AM
 */
public class OOM_JavaHeapSpace {
	public static void main(String[] args) throws InterruptedException {
		// -Xms10m -Xmx10m
		List<byte[]> list = new ArrayList<byte[]>();
		while(true) {
			list.add(new byte[1024]);
		}
		
//		List<Car> list = new ArrayList<Car>();
//		while(true) {
//			list.add(new Car());
//		}
	}
}
