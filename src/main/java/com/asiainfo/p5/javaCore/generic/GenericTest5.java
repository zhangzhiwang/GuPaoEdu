package com.asiainfo.p5.javaCore.generic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 * @author zhangzhiwang
 * @date Dec 12, 2019 1:25:52 PM
 */
public class GenericTest5<T> {
	public static void main(String[] args) {
		GenericTest5<Integer> g = new GenericTest5<Integer>();
//		Integer i = g.get();
		g.get();
		
		/**
		 * 编译时进行的泛型类型检查针对的是引用的泛型类型，而与该引用指向的对象的泛型无关。所以下面的list1和list2添加String类型的元素时会报错；而list3引用没有泛型，它所指向的ArrayList对象的泛型Integer不起作用，素以通过引用list3可以给ArrayList对象添加任意Object类型的元素
		 */
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
//		list1.add("a");// 编译报错
		
		List<Integer> list2 = new ArrayList();
		list2.add(1);
//		list2.add("a");// 编译报错
		
		List list3 = new ArrayList<Integer>();// 相当于不使用泛型：List list3 = new ArrayList();
		list3.add(1);
		list3.add("a");// 编译不报错
	}
	
	public T get() {
		return null;
	}
}
