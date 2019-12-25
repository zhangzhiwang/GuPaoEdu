package com.asiainfo.p5.javaCore.multiThreads;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产者消费者测试
 *
 * @author zhangzhiwang
 * @date Dec 23, 2019 10:02:41 PM
 */
public class ProviderConsumerTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		Object lock = new Object();
		new Provider(list, lock, 1).start();
		new Consumer(list, lock).start();
	}
}
