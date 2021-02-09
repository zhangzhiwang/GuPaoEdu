package com.asiainfo.generic;

/**
 * 泛型，即参数话类型
 *
 */
public class GenericTest<T> {
	public static void main(String[] args) throws Exception {
//		ZhangSan zhangsan = new ZhangSan();
//		Benz car = zhangsan.getCar();
//		BMW car = zhangsan.getCar();
//		System.out.println(car);
		
//		ZhangSan<Benz> zhangsan = new ZhangSan<>();// ZhangSan类的属性car的类型就是Benz
//		ZhangSan<BMW> zhangsan2 = new ZhangSan<>();// ZhangSan类的属性car的类型就是BMW
		
		// 打破集合的泛型往里面添加各种类型的元素
		// 往List<String>添加Integer类型的元素
//		List<String> list = new ArrayList<>();
//		list.add("a");
////		list.add(1);
//		
//		Class<? extends List> clazz = list.getClass();
//		Method method = clazz.getMethod("add", Object.class);
//		method.invoke(list, 1);
//		method.invoke(list, new Date());
//		
//		System.out.println(list);
	}
	
	public void met1(T t) {
		System.out.println("T = " + t);
	}
}
