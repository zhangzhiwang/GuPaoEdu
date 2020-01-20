package com.asiainfo.p5.jvm;

/**
 * 常量——常量就是用final修饰的变量，常量可以分为三种：1、静态常量 2、成员常量 3、方法内部的局部常量
 *
 * @author zhangzhiwang
 * @date Jan 16, 2020 4:46:26 PM
 */
public class FinalVariable {
	// 1、静态常量
	private static final String ATTR = "aaa";
	// 2、成员常量
	private final int AGE = 10;
	
	public static void main(String[] args) {
		// 3、方法内部局部常量
		final byte NUM = 12;
	}
}