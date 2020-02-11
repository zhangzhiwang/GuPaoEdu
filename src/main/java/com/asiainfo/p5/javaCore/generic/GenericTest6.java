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
public class GenericTest6<T> {
	public static void main(String[] args) {
		// case 1:
		met1(new ArrayList<Number>());
//		met1(new ArrayList<Integer>());// 编译报错
		
		// case 2:
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = list1;
//		List<Object> list3 = list1;// 编译报错
		
		// 上面两种情况的本质都是一样的，即集合里面定义泛型的意义是集合只能存放特定一种类型的元素，如果上面两行注释代码是被允许的话，那么我可以用泛型是父类型的集合引用去添加其他类型的元素，这样集合就存在不同类型的元素了，那么集合定义泛型的意义就不存在了。
	
		// 泛型类型擦除对方法复写的影响
		
	}
	
	public static void met1(ArrayList<Number> list) {}
	
	public T met2(T t) {
		return null;
	}
	
	static class GenericTest6_Son extends GenericTest6 {
		public String met2(String s) {
			return null;
		}
	}
}
