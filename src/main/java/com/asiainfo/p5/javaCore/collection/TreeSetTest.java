package com.asiainfo.p5.javaCore.collection;

import java.util.TreeSet;

/**
 * TreeSet
 *
 * @author zhangzhiwang
 * @date Dec 12, 2019 8:36:01 PM
 */
public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet<Integer> treeSet = new TreeSet<Integer>();// TreeSet的内部是基于TreeMap的，所以是有序的，并且内部的TreeMap也不是懒初始化的，也是在构造器里面初始化的
		treeSet.add(1);
	}
}
