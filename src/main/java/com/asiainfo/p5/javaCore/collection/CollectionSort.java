package com.asiainfo.p5.javaCore.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 集合排序
 *
 * @author zhangzhiwang
 * @date Dec 12, 2019 8:01:41 PM
 */
public class CollectionSort {
	public static void main(String[] args) {
		// 方式1:
		List<A> list = new ArrayList<A>();
		list.add(new A(30));
		list.add(new A(10));
		list.add(new A(20));
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
		System.out.println("--------------");
		// 方式2:
		List<B> list2 = new ArrayList<B>();
		list2.add(new B(30));
		list2.add(new B(10));
		list2.add(new B(20));
		System.out.println(list2);
		Collections.sort(list2, new Comparator<B>() {

			@Override
			public int compare(B o1, B o2) {
				return o1.age.compareTo(o2.age);// 升序
			}
		});
		System.out.println(list2);
	}

	static class A implements Comparable<A> {
		private Integer age;

		private A(Integer age) {
			super();
			this.age = age;
		}

		@Override
		public int compareTo(A o) {
//			return this.age.compareTo(o.age);// 升序
			return o.age.compareTo(this.age);// 降序
		}

		@Override
		public String toString() {
			return "A [age=" + age + "]";
		}

	}

	static class B {
		private Integer age;

		private B(Integer age) {
			super();
			this.age = age;
		}

		@Override
		public String toString() {
			return "B [age=" + age + "]";
		}
	}
}
