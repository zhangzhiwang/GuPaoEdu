package com.asiainfo.p5.javaCore.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Vector
 *
 * @author zhangzhiwang
 * @date 2020年2月11日 下午2:58:26
 */
public class VectorTest {
	public static void main(String[] args) {
		// List接口的三大常用实现类：ArrayList、LinkedList和Vector
		// 分别看一下这三个类的源码，重点关注默认初始容量、扩容机制、add方法的实现
		List<Integer> vector = new Vector<Integer>();
		vector.add(1);
		vector.add(1);
		System.out.println(vector.size());
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		
		List<Integer> list2 = new LinkedList<Integer>();
		list2.add(1);
		list2.add(5, 2);
	}
}
