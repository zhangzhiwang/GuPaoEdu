package com.asiainfo.p5.jvm;

/**
 * 常量——常量就是用final修饰的变量，常量可以分为三种：1、静态常量 2、成员常量 3、方法内部的局部常量
 *
 * @author zhangzhiwang
 * @date Jan 16, 2020 4:46:26 PM
 */
public class FinalVariable {
	// 1、静态基本类型常量
	private static final int GENDER = 10;
	
	// 2、静态复合类型常量
	private static final FinalVariable FIANL_VARIABLE = new FinalVariable();
	
	// 3、类成员基本类型常量
	private final int AGE = 10;
	
	// 4、类成员复合类型常量
	private final Student STUDENT = new Student();
	
	public static void main(String[] args) {
		// 5、方法内部局部常量——基本类型
		final byte NUM = 12;
		
		// 6、方法内部局部常量——复合类型
		final Student student2 = new Student();
	}
}

class Student {}