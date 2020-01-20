package com.asiainfo.p5.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用JVisualVM工具
 *
 * @author zhangzhiwang
 * @date Jan 14, 2020 10:23:03 AM
 */
public class JVisualVMTest {
	private byte[] bs = new byte[10240];
	
	public static void main(String[] args) throws InterruptedException {
		List<JVisualVMTest> list = new ArrayList<JVisualVMTest>();
		for(;;) {
			list.add(new JVisualVMTest());
			Thread.sleep(10);
		}
	}
}
