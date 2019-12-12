package com.asiainfo.p5.javaCore.collection;

import java.util.LinkedList;

/**
 * LinkedList
 *
 * @author zhangzhiwang
 * @date Dec 12, 2019 8:14:11 PM
 */
public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		System.out.println(list.size());
		list.add(0, 2);
		System.out.println(list);
	}
}
