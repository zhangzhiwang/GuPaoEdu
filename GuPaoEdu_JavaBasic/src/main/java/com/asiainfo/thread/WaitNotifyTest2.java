package com.asiainfo.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 关于wait和notify
 * 参考：https://blog.csdn.net/qq32933432/article/details/108063769
 * 		
 *
 * @author zhangzhiwang
 * @date 2021年5月7日 下午4:23:52
 */
public class WaitNotifyTest2 {
	private static Object o = new Object();
	
	public static void main(String[] args) {
		/**
		 * 涉及几个问题：
		 * 问题1:为什么wait和notify方法要放到同步块中？
		 * 		拿生产者和消费者来举例子，首先要满足一个前提——生产者和消费者在不同的线程中运行，那么这个问题就类似于线程安全问题了。
		 * 		生产者伪代码：
		 *      if(list.size() == size) {
		 *      	list.wait();
		 *      }
		 *      list.add();
		 *      list.notify();
		 *      消费者伪代码：
		 *      if(list.size() == 0) {
		 *      	list.wait();
		 *      }
		 *      list.remove();
		 *      list.notify();
		 *      如果程序启动后消费者先运行，这个时候list是空的，然后就通过了if判断，恰巧在运行list.wait()之前，进行了cpu时间片的切换，这个时候生产者线程获得了时间片开始运行，在判断了list.size()不等于最大值时进行了add操作，
		 *      往list里面添加了一个元素，然后执行了notify操作，这个时候消费者从wait中被唤醒，然后执行wait操作。这里面有两个关键点：一个是消费者在判断list.size() == 0之后wait之前list.size()发生了变化，另一个是生产者的notify操作在消费者wait操作之前，所以notify被丢弃了。
		 *      恰巧生产者只生产一个数据，那么消费者将永远不会被唤醒，这就是著名的Lost Wake Up问题。怎么解决呢，可以认为生产者和消费者之间产生了静态条件，类似于解决线程安全问题一样，所以解决方案是枷锁，那么java从语法层面也强制用户放在同步块中否则运行抛异常。
		 * 问题2：为什么加锁的对象和调用wait/notify方法的对象要一致？
		 * 		这个问题没有查处根本原因来，只能从java语法规定来说了。可以查看wait和notify源码的注释，要获取调用对象的同步监视器，也就是同步锁，也就是说调用wait和notify方法的对象必须得是锁对象，目前只能这么解释了。
		 */
//		synchronized (o) {
			try {
				o.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			o.notify();
			System.out.println("notify后其它逻辑代码");
//		}
	}
}
