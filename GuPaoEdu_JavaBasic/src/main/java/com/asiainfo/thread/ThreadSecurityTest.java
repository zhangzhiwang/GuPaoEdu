package com.asiainfo.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程安全问题——原子性、可见性和有序性
 *
 * @author zhangzhiwang
 * @date 2021年5月14日 上午11:05:26
 */
public class ThreadSecurityTest implements Runnable {
	/**
	 * 这个线程原子性问题模拟在mac电脑上不容易出现，可以放到配置相对较低的windows电脑上试验。
	 * 启动100000个线程，每个线程给公有变量加1，最终运行结果往往小于100000，在变量上加上volatile关键字仍然不能解决问题，这就牵扯到线程安全的三个问题以及volatile是解决什么问题的。
	 * 这个例子模拟的是线程安全的原子性问题，而不是可见性问题，而volatile解决的是可见性问题。问题的关键在于count++操作在Java代码里面是一行，由于Java是高级开发语言，一行代码可能对于底层的多个计算机指令，count++就只这样。
	 * count++对应的底层多个指令不是原子操作，运行完其中的某些指令后可能会出现cpu上下文的切换，再切换回来的时候变量可能被其他线程改变了。
	 * count++可以拆分为三个计算机指令：
	 * 1、读取count的值
	 * 2、执行count加1操作
	 * 3、给count赋值
	 * 如果在进行完第二步的时候出现了上下文切换，再重新获取cpu时间片的时候count的值可能被其他的线程改过了而直接运行第三部——给count赋值。
	 * 其实这个例子体现了两个问题：一个是线程的原子性问题，一个是可见性问题，给count变量加上volatile关键字只能解决可见性问题而不能解决原子性问题，解决原子性问题只能使用锁：Lock或者synchronized。
	 * 由于synchronized技能保证原子性也能保证可见性，所以count变量的volatile关键字就没必要加了。
	 */
	private static volatile int count = 0;

	@Override
	public void run() {
		synchronized (ThreadSecurityTest.class) {
			count++;
		}
	}

	public static void main(String[] args) {
		while (true) {
			List<Thread> list = new ArrayList<>();
			
			int loop = 100000;
			for (int i = 0; i < loop; i++) {
				list.add(new Thread(new ThreadSecurityTest()));
			}
			
			for(Thread t : list) {
				t.start();
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(count);
			count = 0;
		}
	}
}
