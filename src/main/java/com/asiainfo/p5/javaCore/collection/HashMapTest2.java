package com.asiainfo.p5.javaCore.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 遍历HashMap的三种方式
 *
 * @author zhangzhiwang
 * @date Dec 10, 2019 8:57:51 PM
 */
public class HashMapTest2 {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "aaa");
		map.put(2, "bbb");
		
		// 方式1:获取EntrySet集合
		Set<Entry<Integer,String>> entrySet = map.entrySet();
		for(Entry<Integer,String> entry : entrySet) {
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " : " + value);
		}
		
		// 方式2:获取keySet集合
		System.out.println("---------------");
		Set<Integer> keySet = map.keySet();
		for(Integer key : keySet) {
			System.out.println(key + " : " + map.get(key));
		}
		
		// 方式3:获取values集合
		System.out.println("---------------");
		Collection<String> values = map.values();
		for(String value : values) {
			System.out.println(value);
		}
	}
}
