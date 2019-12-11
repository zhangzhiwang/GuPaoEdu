package com.asiainfo.p5.javaCore.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 线程安全的集合</p>
 * ArrayList（基于动态数组）和LinkedList（基于双向链表）都是线程不安全的集合实现类，Vector是线程安全的集合，它也是基于数组来实现的，它保证线程安全的措施就是在方法的声明处加上synchronized关键字
 *
 * @author zhangzhiwang
 * @date Dec 10, 2019 2:13:09 PM
 */
public class ThreadSafeCollection {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		// java.util.Collections.synchronizedList(List<T>)这个方法可以将线程不安全的List转换成线程安全的List，通过看源码可以知道其实也是通过加synchronized关键字实现的，而且用的静态代理模式
		List<Integer> synchronizedList = Collections.synchronizedList(list);
	}
}
