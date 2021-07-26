package com.asiainfo.thread;

/**
 * volatile关键字
 *
 * @author zhangzhiwang
 * @date 2021年5月27日 下午1:54:51
 */
public class VolatileTest {
	/**
	 * volatile可以保证可见性和有序性，不能保证原子性，在保证可见性和有序性的时候并不会引起线程上下文的切换，因为常被叫做“轻量级锁”
	 */
	private volatile int i;
}
