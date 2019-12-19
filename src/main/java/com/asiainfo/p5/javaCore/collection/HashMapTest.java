package com.asiainfo.p5.javaCore.collection;

import java.util.HashMap;

/**
 * HashMap的存储结构
 *
 * @author zhangzhiwang
 * @date Dec 10, 2019 8:57:51 PM
 */
public class HashMapTest {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "aaa");
		
		Integer i = new Integer(123456789);
		int hashCode = i.hashCode();
		System.out.println(hashCode);
	}
}
