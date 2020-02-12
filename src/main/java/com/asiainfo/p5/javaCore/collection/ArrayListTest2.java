package com.asiainfo.p5.javaCore.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 在遍历ArrayList时删除元素
 *
 * @author zhangzhiwang
 * @date Dec 12, 2019 8:01:41 PM
 */
public class ArrayListTest2 {
	public static void main(String[] args) {
		// 需求：删除list里面值为2的元素
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("2");
		list.add("2");
		list.add("5");
		
//		System.out.println("初始list.size = " + list.size());
//		// 1、使用普通for循环遍历时删除会导致有连续两个一样的元素时第二个元素删除不掉
////		for(int i = 0; i < list.size(); i++) {
////			String e = list.get(i);
////			if(e.equals("2")) {
////				System.out.println("remove");
////				list.remove(e);
////			}
////		}
//		
//		// 针对普通for循环的解决方案是倒序遍历
//		for(int i = list.size() - 1; i >= 0 ; i--) {
//			String e = list.get(i);
//			if(e.equals("2")) {
//				System.out.println("remove");
//				list.remove(e);
//			}
//		}
//		
//		System.out.println("size = " + list.size());
//		for(int i = 0; i < list.size(); i++) {
//			String e = list.get(i);
//			System.out.println(e);
//		}
		
		// 2、使用foreach遍历，这种方式下在遍历过程中移除元素会报java.util.ConcurrentModificationException异常
//		for(String e : list) {
//			if(e.equals("2")) {
//				System.out.println("remove");
//				list.remove(e);
//			}
//		}
		
		// foreach相当于用迭代器遍历，下面的代码和上面是等价的
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			String e = iterator.next();
			if(e.equals("2")) {
				System.out.println("remove");
//				list.remove(e);// 报java.util.ConcurrentModificationException异常
				iterator.remove();// 解决方法是通过迭代器来移除而不是用list移除
			}
		}
		
		System.out.println("size = " + list.size());
		for(int i = 0; i < list.size(); i++) {
			String e = list.get(i);
			System.out.println(e);
		}
	}
}
