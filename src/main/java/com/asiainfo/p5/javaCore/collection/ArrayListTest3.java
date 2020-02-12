package com.asiainfo.p5.javaCore.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * List和数组相互转化
 *
 * @author zhangzhiwang
 * @date Dec 12, 2019 8:01:41 PM
 */
public class ArrayListTest3 {
	public static void main(String[] args) {
		// List->Array
		List<String> list = new ArrayList<String>();
		Object[] array = list.toArray();
		
		// Array->List
		List<Integer> asList = Arrays.asList(1,2,3);
		
		// ArrayList实现线程安全
		List<String> synchronizedList = Collections.synchronizedList(list);
	}
}
