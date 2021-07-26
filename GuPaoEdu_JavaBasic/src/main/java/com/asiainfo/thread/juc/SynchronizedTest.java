package com.asiainfo.thread.juc;

/**
 * synchronized原理
 *
 * @author zhangzhiwang
 * @date 2021年6月1日 下午5:23:28
 */
public class SynchronizedTest {
	/**
	 * 使用javap -verbose查看，met1方法没有插入monitorenter和monitorexit指令，而是会读取元数据区的运行时常量池中对该方法的描述常量ACC_SYNCHRONIZED，表明发方法是同步的；
	 * 而met2方法使用的是monitorenter和monitorexit指令
	 */
	public synchronized void met1() {
		
	}
	
	public void met2() {
		synchronized (this) {
			System.out.println();
		}
	}
}
