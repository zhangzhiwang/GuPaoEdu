package com.asiainfo.p5.javaCore.collection;

import java.util.HashSet;

/**
 * HashSet——是基于HashMap实现的
 *
 * @author zhangzhiwang
 * @date Dec 12, 2019 8:25:12 PM
 */
public class HashSetTest {
	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(1);// HashSet是基于HashMap实现的，HashSet里面的元素实际上是存储在了内部HashMap的key里面，value统一是固定值Object。为什么Set的元素可以去重，是因为HashMap的key不能重复。HashSet里面的HashMap不是懒初始化的，而是在调用构造函数的时候初始化的。
	}
}
