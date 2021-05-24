package com.asiainfo.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * wait和notify
 *
 * @author zhangzhiwang
 * @date 2021年5月7日 下午4:23:52
 */
public class WaitNotifyTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		int size = 10;
		Producer producer = new Producer(list, size);
		Consumer consumer = new Consumer(list, size);
		Thread t1 = new Thread(producer);
		Thread t2 = new Thread(consumer);
		
		t1.start();
		t2.start();
	}
}
