package com.asiainfo.p5.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用jstat命令
 *
 * @author zhangzhiwang
 * @date Feb 21, 2020 6:47:25 PM
 */
public class JStatTest {
	public static void main(String[] args) throws InterruptedException {
		List list = new ArrayList();
		for(;;) {
			list.add(new byte[1024 * 1024]);
			Thread.sleep(3000);
		}
	}
}
