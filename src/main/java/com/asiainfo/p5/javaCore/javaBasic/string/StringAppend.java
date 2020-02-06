/**
 * 
 */
package com.asiainfo.p5.javaCore.javaBasic.string;

/**
 * 
 *
 * @author Administrator
 * @date 2020年2月2日 下午12:58:04
 */
public class StringAppend {
	public static void main(String[] args) {
//		String s = "hello";
//		String result = s + " world!";
//		System.out.println(result);
		
		long start = System.currentTimeMillis();
		String s = "";
		for(int i = 0; i < 10000; i++) {
			s = s + i;// 由于不是两个字面量相拼接而是变量和字面量拼接，所以底层是使用StringBuilder来实现的。由于新建StringBuilder对象是在循环的里面，所以每循环一次就会创建一个该对象，导致效率下降。优化方法是再循环外面创建StringBuilder对象，这样该对象只创建一个。
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		long start2 = System.currentTimeMillis();
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < 10000; i++) {
			stringBuilder.append(i);
		}
		long end2 = System.currentTimeMillis();
		System.out.println(end2 - start2);
		// 运行结果的差距还是很大的
	}
}
