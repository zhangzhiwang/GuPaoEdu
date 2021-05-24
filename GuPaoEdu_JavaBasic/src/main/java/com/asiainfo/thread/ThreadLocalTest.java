package com.asiainfo.thread;

/**
 * ThreadLocal——使用ThreadLocal达到线程的隔离
 *
 * @author zhangzhiwang
 * @date 2021年5月14日 下午5:59:06
 */
public class ThreadLocalTest implements Runnable {
	private static int count = 0;
	
	@Override
	public void run() {
		count++;
	}

	public static void main(String[] args) {
		ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
		threadLocal.set(count);
	}
}
