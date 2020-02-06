package com.asiainfo.p5.javaCore.javaBasic;

/**
 * 测试static方法的继承
 *
 * @author Administrator
 * @date 2020年1月30日 下午9:58:14
 */
public class ExtendsStaticTest {
	public int num = 10;
	
	static class Son extends ExtendsStaticTest {
		public int num = 20;
		public static void met2() {
			met1();
			System.out.println("son");
		}
	}
	
	public static void met1() {
		System.out.println("father");
	}
	
	public static void main(String[] args) {
//		ExtendsStaticTest e = new Son();
//		e.met1();
//		System.out.println(e.num);
		
		new Son().met2();// 子类可以调用父类的静态方法但是不能复写
	}
}
