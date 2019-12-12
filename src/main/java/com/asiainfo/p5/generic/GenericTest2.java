package com.asiainfo.p5.generic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型类型擦除测试
 *
 * @author zhangzhiwang
 * @date Dec 12, 2019 1:25:52 PM
 */
public class GenericTest2 {
	public static void main(String[] args) throws Exception {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
//		list.add("aa");// 编译不通过，因为泛型在编译期间起作用，进行类型检查
		
		// 通过反射将String类型的对象添加到list中
		Class clazz = list.getClass();
		clazz.getMethod("add", Object.class).invoke(list, "aa");// 因为在运行期JVM将泛型类型擦除掉了，还原成其本来面目Object
		
		System.out.println(list.size());
		System.out.println(list);
	}
}
