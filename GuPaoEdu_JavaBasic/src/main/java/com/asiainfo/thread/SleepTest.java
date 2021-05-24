package com.asiainfo.thread;

/**
 * sleep方法
 *
 * @author zhangzhiwang
 * @date 2021年5月7日 下午2:53:18
 */
public class SleepTest {
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(1);// 当调用sleep方法时当前线程会进入TIMED_WAITING状态，当时间结束后会重新回到RUNNABLE状态，具体地说是READY状态，也就是说当休眠时间结束后并不一定会立马运行而是重新等待分配CPU时间片
		Thread.sleep(0);// sleep(0)和wait(0)的含义不同，wait(0)外表永久等待直到被唤醒，而sleep(0)代表休眠0毫秒，即不休眠，但是会主动让出cpu时间片回到READY状态等待下次分配CPU时间，相当于yield
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("aaa");
			}
		});
		
		t.start();
		t.sleep(3000);// sleep方法的作用是使当前线程休眠，注意是“当前”，调用其它线程对象的sleep方法并不能使该线程休眠而仍然会使当前线程休眠
		System.out.println("end");
	}
}
