package com.asiainfo.p5.javaCore.multiThreads;

import java.util.List;

/**
 * 生产者
 *
 * @author zhangzhiwang
 * @date Dec 23, 2019 9:46:46 PM
 */
public class Provider extends Thread {
	private List<String> list;
	private Object lock;
	private int size;
	
	public Provider(List<String> list, Object lock, int size) {
		super();
		this.list = list;
		this.lock = lock;
		this.size = size;
	}


	public void produce(int i) {
		synchronized (lock) {
			while(list.size() == size) {
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
			
			list.add("" + i);
			System.out.println("生产者生产了 " + i);
			lock.notifyAll();
		}
	}
	
	public void run() {
		for(int i = 0; ; i++) {
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			produce(i);
		}
	}
}
