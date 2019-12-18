package com.asiainfo.p5.javaCore.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 集合类的fail-fast机制：为了保证集合遍历结果的确定性而采取的防范措施。如果没有fast-fail机制，那么假如多个线程同时操作同一个集合（有的线程增删元素，有的遍历集合），那么会导致遍历集合的线程遍历出来的结果可能是不确定的。</p>
 * 其实，FailFast机制的工作意义是：对“一个集合内部已经发生修改,其他使用该集合的线程还不知情”的一种防范机制，说白了就是防止：一个线程在遍历集合的时候这个集合还在不停地变化。
 *
 * @author zhangzhiwang
 * @date Dec 10, 2019 1:20:14 PM
 */
public class FailFastTest {
	static class AddThread extends Thread {
		private List<Integer> list;

		private AddThread(List<Integer> list) {
			super();
			this.list = list;
		}

		public void run() {
			for (int i = 0; i < 10000; i++) {
				list.add(i);
			}
		}
	}

	static class IterThread extends Thread {
		private List<Integer> list;

		private IterThread(List<Integer> list) {
			super();
			this.list = list;
		}

		public void run() {
			Iterator<Integer> iterator = list.iterator();
			while (iterator.hasNext()) {
				try {
					Thread.sleep(1);
					Integer next = iterator.next();// 集合里面的modCount只增不减
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		new AddThread(list).start();
		new IterThread(list).start();
	}
}
