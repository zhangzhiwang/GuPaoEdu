package com.asiainfo.p5.javaCore.multiThreads;

import java.util.List;

/**
 * 消费者
 *
 * @author zhangzhiwang
 * @date Dec 23, 2019 9:46:46 PM
 */
public class Consumer extends Thread {
	private List<String> list;
	private Object lock;
	
	public Consumer(List<String> list, Object lock) {
		super();
		this.list = list;
		this.lock = lock;
	}


	public void consume() {
		synchronized (lock) {
			while(list.size() == 0) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("消费者消费了 		" + list.remove(0));
			lock.notifyAll();
		}
	}
	
	public void run() {
		for(int i = 0; ; i++) {
			consume();
		}
	}
}
