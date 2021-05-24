package com.asiainfo.thread;

import java.util.List;

/**
 * 生产者
 * 生产者-消费者三种模式之二——把队列生产满再消费
 *
 * @author zhangzhiwang
 * @date 2021年5月7日 下午4:04:57
 */
public class Producer implements Runnable {
	private List<String> list;
	private int size;

	public Producer(List<String> list, int size) {
		super();
		this.list = list;
		this.size = size;
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			i++;
			try {
//				Thread.sleep(1);
				Thread.yield();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			synchronized (list) {
				if (list.size() == size) {
					System.out.println("队列已满");
					try {
						list.wait();// wait方法是使当前线程进入等待状态
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				try {
					Thread.sleep(1);// 每秒生产1个
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				list.add("" + i);
				System.out.println("生产者生产：" + i);
				list.notifyAll();
			}
		}
	}
}
