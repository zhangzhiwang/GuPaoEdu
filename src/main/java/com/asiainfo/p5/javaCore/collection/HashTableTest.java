package com.asiainfo.p5.javaCore.collection;

import java.util.HashMap;
import java.util.Map;

public class HashTableTest {
	public static void main(String[] args) {
		/**
		 * HashTable与HashMap的区别：</p>
		 * 1、HashMap底层数据结构是动态数组+单向链表+红黑树（jdk1.8之后），而HashTable的底层数据结构只有动态数组+单向链表</p>
		 * 2、HashMap的key和value都可以为null，而HashTable的key和value都不能为null
		 * 3、HashMap不是线程安全的，而HashTable是线程安全的。而HashTable实现线程安全的方式就是简单粗暴地在各种方法的定义处加上synchronized关键字，效率低下
		 * 4、HashMap的默认初始大小为16，且每次扩容都是扩大一倍（即扩容后是原来的两倍）。而HashTable的默认初始大小为11，且每次扩容后都是原来的两倍+1（即newsize = oldsize*2+1）
		 * 5、HashMap计算index的方法为：(数组长度 - 1) & hash(key)，而HashTable计算index的方法为：(hash(key) & Integer最大值) % 数组的长度;
		 */
		
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put(null, null);// HashMap的key和value都可以为null
		System.out.println(map1);
		
//		Map<String, String> map2 = new Hashtable<String, String>();
//		map2.put("a", null);// HashTable的key和value都不能为null
//		System.out.println(map2);// java.lang.NullPointerException
	}
}
