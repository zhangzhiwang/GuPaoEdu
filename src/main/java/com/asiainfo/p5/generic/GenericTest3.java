package com.asiainfo.p5.generic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型的意义
 *
 * @author zhangzhiwang
 * @date Dec 12, 2019 1:25:52 PM
 */
public class GenericTest3 {
	public static void main(String[] args) throws Exception {
		// 1、泛型可以在编译期间确定类型的限制，在编译起进行类型检查，确保类型安全。
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
//		list.add("aa");// 编译不通过，因为泛型在编译期间起作用，进行类型检查
		
		// 2、泛型可以避免强制类型转换避免错误的发生。
		List list2 = new ArrayList();// 如果不给List加元素类型限制的话，那么list2可以肆无忌惮地添加所有类型的元素进去，添加的时候是爽了，遍历起来就不爽了
		list2.add(1);
		list2.add("aaa");
		list2.add(new Thread());
		
		for(int i = 0; i < list2.size(); i++) {// 在遍历的时候需要根据不同元素的不同类型做不同的强制转换，稍操作不当容易发生错误。
			Object object = list2.get(i);
			if(i == 0) {// 在本例中已经事先知道第一个元素是int类型，第二个是String类型，第三个是Thread类型，所以遍历的时候可以根据不同的索引进行强制转换。在实际生产中很有可能不知道要遍历的列表那些元素是什么类型，得去除具体的元素后通过获取该元素的Class对象然后进行相关的转换，岂不很麻烦？
				int j = (int) object;
				System.out.println(j);
			} else if(i == 1) {
				String s = (String) object;
				System.out.println(s);
			} else if(i == 2) {
				Thread t = (Thread) object;
				System.out.println(t);
			}
		}
		
		// 3、可以提高代码的灵活性和通用性，避免重复创建类，提高代码的复用率
		// MyGenericClass可以被复用，否则需要创建不同的MyGenericClass类，里面有不同类型的属性
		MyGenericClass<Integer> m1 = new MyGenericClass<Integer>();
		Integer integer = m1.get();
		
		MyGenericClass<String> m2 = new MyGenericClass<String>();
		String string = m2.get();
		
		MyGenericClass<Thread> m3 = new MyGenericClass<Thread>();
		Thread thread = m3.get();
	}
	
	static class MyGenericClass<T> {
		private T t;

		public T get() {
			return t;
		}
	}
}
