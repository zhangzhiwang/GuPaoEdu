package com.asiainfo.p5.javaCore.generic;

import java.util.List;

//泛型的定义语法为：<泛型名称>，泛型只有先定义才能使用
public class GenericClass1<E extends Number> {// 泛定定义在类声明出，则该类是一个泛型类
	private E e;

	public E getE() {
		return e;
	}

	public void setE(E e) {
		this.e = e;
	}

	public E met1(E e) {// 此方法虽然通到了泛泛型，但是所用的泛型不只在方法声明出定义的，而是使用的类的泛型，所以该方法不是泛型方法而是一个普通的方法
		return e;
	}

	public void met2(List<?> list) {// 无界通配符
	}

	public void met3(List<? extends Number> list) {// 上界通配符

	}

	public void met4(List<? super Number> list) {// 下届通配符

	}

	public <T> void met5(T t) {// 泛型定义在方法声明出则该方法为一个泛型方法

	}

	public <T> void met6(T t, E e) {// 非静态方法既可以使用类的泛型，也可以使用本方法定义的泛型

	}

//	public static <T> void met7(T t, E e) {// 静态方法不可以使用类的泛型，只可以使用本方法定义的泛型
//		
//	}

	public <A extends E> void met7(A a, E e) {
	}

	public <B, C> void met8(B b, C c) {
	}

//	public <D super Number> void met8() {// 无论是在类定义处定义泛型还是在方法定义处定义泛型，都不能使用super和通配符（？），但是可以使用extends
//		
//	}

//	public <? extends Number> void met9() {}
	
	static interface MyInterface<A, B, CCC> {// 泛型接口
		A get(B b);
	}

	static class MyClass implements MyInterface<Integer, String, Thread> {
		@Override
		public Integer get(String b) {
			return null;
		}
	}
	
	static class MyClass2 implements MyInterface{
		@Override
		public Object get(Object b) {// 可见泛型类型擦除的效果
			return null;
		}
	}
}
