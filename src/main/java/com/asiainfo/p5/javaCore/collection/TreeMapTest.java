package com.asiainfo.p5.javaCore.collection;

import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap</p>
 * 基于树结构，查找是基于二分查找的，所以是有序的，非线程安全
 *
 * @author zhangzhiwang
 * @date Dec 12, 2019 4:50:49 PM
 */
public class TreeMapTest {
	public static void main(String[] args) {
		Map<String, String> map = new TreeMap<String, String>();
		map.put("1", "a");
	}
}
