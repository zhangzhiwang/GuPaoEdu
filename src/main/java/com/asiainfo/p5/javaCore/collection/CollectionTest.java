package com.asiainfo.p5.javaCore.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 如何确保一个集合不被修改
 *
 * @author zhangzhiwang
 * @date Dec 12, 2019 8:01:41 PM
 */
public class CollectionTest {
	public static void main(String[] args) {
		// 使用final修饰集合引用的话只能确保引用不能被修改或者该引用不能再指向其他集合对象了，但是集合对象里面的元素是可以变化的，这里要说的是怎么让集合里面的元素也不能被修改
		final Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("1", 1);
		map.put("2", 2);
//		map = new HashMap<String, Integer>();// map引用不能指向其他容器对象了
		System.out.println(map);
		map.put("1", map.get("1") + 10);
		System.out.println(map);// map引用是final的但是里面的元素是可以被修改的
		
		System.out.println("-------------");
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put("1", 1);
		map2.put("2", 2);
		Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(map2);
		System.out.println(map2);
		map2.put("1", map2.get("1") + 10);
		System.out.println(map2);// map2里面的元素仍然可以改，但是unmodifiableMap里面的元素不能改了
		unmodifiableMap.put("1", unmodifiableMap.get("1") + 10);// 报错：java.lang.UnsupportedOperationException
		
		// 类似的还有：
		Collections.unmodifiableList(new ArrayList());
		Collections.unmodifiableSet(new HashSet());
		
//		Collections.synchronizedMap(new HashMap());
	}
}
