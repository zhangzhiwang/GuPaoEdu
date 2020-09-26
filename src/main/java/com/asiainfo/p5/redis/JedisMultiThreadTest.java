package com.asiainfo.p5.redis;

import redis.clients.jedis.Jedis;

/**
 * Jedis的多线程问题
 * 多个线程共用一个Jedis对象会有线程安全问题，因为Jedis是非线程安全的，具体可参考：https://www.jianshu.com/p/5e4a1f92c88f
 * 解决Jedis线程不安全的方法很简单，就是一个线程对应一个Jedis实例，但这样胡创建过多的Jedis实例从而创建过多的socket连接，解决这个问题通常的做法就是使用连接池，一个线程使用完Jedis实例就将它归还给连接池。
 * 所以完美解决Jedis线程安全的方法就是使用JedisPool，这样既保证了线程安全也保证了不会创建过多的socket连接。
 *
 * @author zhangzhiwang
 * @date Sep 26, 2020 1:41:18 PM
 */
public class JedisMultiThreadTest {
	private static final Jedis JEDIS = new Jedis("localhost", 6389);
	
	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			MyThread myThread = new MyThread();
			myThread.setName("myThread_" + i);
			myThread.start();
		}
	}
	
	static class MyThread extends Thread {
		public void run() {
			JEDIS.set(Thread.currentThread().getName(), "1");
		}
	}
}
