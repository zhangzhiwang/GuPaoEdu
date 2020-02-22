package com.asiainfo.p5.javaCore.collection;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * TreeSet
 *
 * @author zhangzhiwang
 * @date Dec 12, 2019 8:36:01 PM
 */
public class TreeSetTest implements Comparable<TreeSetTest> {
	private int age;
	private String name;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
//		TreeSet<Integer> treeSet = new TreeSet<Integer>();// TreeSet的内部是基于TreeMap的，所以是有序的，并且内部的TreeMap也不是懒初始化的，也是在构造器里面初始化的
//		treeSet.add(1);

		TreeMap treeMap = new TreeMap();
		treeMap.put(new TreeSetTest(), 1);
		
		short s1= 1;
		s1 +=  1;
	}

	@Override
	public int compareTo(TreeSetTest o) {
		return this.name.compareTo(o.name);
	}
}
