package com.asiainfo.p5.javaCore.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * HashMap的存储结构
 *
 * @author zhangzhiwang
 * @date Dec 10, 2019 8:57:51 PM
 */
public class LinkedHashMapTest {
	public static void main(String[] args) {
//		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
//		map.put(1, "aaa");
//		
//		Integer i = new Integer(123456789);
//		int hashCode = i.hashCode();
//		System.out.println(hashCode);
		
		LinkedHashMapTest l1 = null;
		LinkedHashMapTest l2 = l1;
		l1 = new LinkedHashMapTest();
		System.out.println(l2);
	}
}
