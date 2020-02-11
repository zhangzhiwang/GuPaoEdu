package com.asiainfo.p5.javaCore.generic;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型?和T的区别
 *
 * @author zhangzhiwang
 * @date Dec 12, 2019 1:25:52 PM
 */
public class GenericTest4<T> {
	public static void main(String[] args) throws Exception {
		// 1、？与T都代表不确定的类型，但是T可以更精确的翻译为“某一个”不确定的类型，就是说如果T的类型一旦确定，任何使用T的地方都必须是该类型，而?可以是任意不同的类型
		met1(new ArrayList<Integer>(), new ArrayList<Integer>());
		Number met1_12 = met1_1(1, 1.1);
//		Number met1_13 = GenericTest4.<Integer>met1_1(1, 1.1);
		Object met1_1 = met1_1(15, "abc");
//		Object met1_15 = GenericTest4.<Integer>met1_1(15, "abc");
//		met1(new ArrayList<Integer>(), new ArrayList<Double>());// 编译不通过
		
		met2(new ArrayList<Integer>(), new ArrayList<String>());// 编译可以通过
		
		// 2、T类型的对象可以参与操作，？不可以
		met3(new ArrayList<ArrayList>(), new ArrayList<ArrayList>());
		
		// 3、T一般用于泛型方法和泛型类的定义；而?一般用于调用泛型方法后接收返回值时定义的接收类型以及用于定义方法入参类型，不能用于定义泛型方法和泛型类
		List<?> list = met4(new ArrayList<Integer>());
		
		// 4、T可以指定多个上限，？只能指定一个上限
		met5();
		
		// 5、T不能指定下限而?可以指定下限
		met8(new ArrayList<Number>());
	}
	
	public static <T> void met1(List<T> list1, List<T> list2) {}
	public static <T> T met1_1(T t1, T t2) {
		return null;
	}
	public static <T> void met2(List<?> list1, List<?> list2) {}
	
	public static <T extends List> void met3(List<T> list, List<?> list2) {
		for(T t : list) {
			int i = t.size();// T类型的对象t可以参与操作，通配符就不可以
		}
		
//		?.size();
	}
	
	public static <T> List<T> met4(List<?> list) {
		return new ArrayList<T>();
	}
	
	public static <T extends GenericTest4 , FatherInterface> T met5() {// T可以指定多个上限
		return null;
	}
	
//	public static void met6(List<? extends  FatherInterface> list) {// ？只能制定一个上限
//		return null;
//	}
	
//	public static <T super GenericTest4> void met7() {}// T不能指定下限
	
	public static void met8(List<? super Integer> list) {}// ?可以指定下限
}
