package com.asiainfo.thread;

import java.util.List;

/**
 * 消费者
 *
 * @author zhangzhiwang
 * @date 2021年5月7日 下午4:19:51
 */
public class Consumer implements Runnable {
	private List<String> list;
	private int size;

	public Consumer(List<String> list, int size) {
		super();
		this.list = list;
		this.size = size;
	}

	@Override
	public void run() {
		while (true) {
			try {
//				Thread.sleep(1);
				Thread.yield();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
			synchronized (list) {
				if (list.size() == 0) {
					System.out.println("队列已空");
					try {
						list.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				try {
					Thread.sleep(1);// 每秒消费1个
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				String remove = list.remove(0);
				System.out.println("	消费者消费：" + remove);
				list.notifyAll();
			}
		}
	}
}
