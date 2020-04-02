package com.asiainfo.p5.jvm;

/**
 * 栈内存溢出</br>
 * 注意：堆益处和方法区溢出都会抛出OOM，即OutOfMemoryError，但是虚拟机栈溢出不会抛出OOM，会抛出StackOverflowError，StackOverflowError不是OutOfMemoryError的子类，它俩是平级的
 *
 * @author zhangzhiwang
 * @date Jan 14, 2020 11:09:39 AM
 */
public class OOM_StackOverflowError {
	private static int num;
	
	public static void main(String[] args) {
		// 用递归使Java栈溢出
		met1(num);
	}
	
	private static void met1(int i) {
//		System.out.println(i);
		met1(num++);
	}
}
