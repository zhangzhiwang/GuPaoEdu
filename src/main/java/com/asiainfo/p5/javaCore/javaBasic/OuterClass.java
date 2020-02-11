package com.asiainfo.p5.javaCore.javaBasic;

/**
 * 静态内部类和非静态内部类的区别：</p>
 * 
 *
 * @author zhangzhiwang
 * @date 2020年2月10日 下午4:35:20
 */
public class OuterClass {
	private int outerNum;
	private static String outerName;
	
	public void met1() {
		// 静态内部类不能定义在方法（无论是静态方法还是实例方法）里面，而非静态内部类可以定义在方法（无论是静态方法还是实例方法）里面
//		static class A {}
		class A {}
	}
	public static void met2() {
//		static class A {}
		class A {}
	}
	
	/**
	 * 静态内部类
	 *
	 * @author zhangzhiwang
	 * @date 2020年2月10日 下午3:42:20
	 */
	public static class StaticInnerClass {
		private int staticInnerNum;
		private static String staticInnerName;
		
		public void met10() {// 静态内部类不能访问外部类的成员变量和成员方法，只能访问静态变量和静态方法，因为静态内部类没有指向外部类的引用
			System.out.println(outerName);
//			System.out.println(outerNum);
			
//			met1();
			met2();
		}
		
		public static void met11() {}
	}
	
	/**
	 * 非静态内部类
	 *
	 * @author zhangzhiwang
	 * @date 2020年2月10日 下午3:43:07
	 */
	public class NonStaticInnerClass {
		private int nonStaticInnerNum;
//		private static String nonStaticInnerName;// 非静态内部类不能定义静态的属性，但是可以定义static final属性
		private static final String nonStaticInnerName = "zs";
		
		public void met20() {// 非静态内部类持有对外部类的引用，所以既可以访问外部类的成员变量和方法，也可以访问静态成员和方法。
			System.out.println(outerName);
			System.out.println(outerNum);
			
			met1();
			met2();
		}
		
//		public static void met21() {} // 非静态内部类不能定义静态方法
	}
	
	public static void main(String[] args) {
		// 静态内部类对象的创建
		// 1、可以直接创建而不需要外部类的任何帮助
		StaticInnerClass staticInnerClass = new StaticInnerClass();
		staticInnerClass.met10();
		StaticInnerClass.met11();
		
		// 2、使用外部类.静态内部类的方式
		OuterClass.StaticInnerClass staticInnerClass2 = new OuterClass.StaticInnerClass();
		staticInnerClass2.met10();
		OuterClass.StaticInnerClass.met11();
		
		// 非静态内部类对象的创建
		OuterClass outerClass = new OuterClass();
		NonStaticInnerClass nonStaticInnerClass = outerClass.new NonStaticInnerClass();
		nonStaticInnerClass.met20();
	}
}