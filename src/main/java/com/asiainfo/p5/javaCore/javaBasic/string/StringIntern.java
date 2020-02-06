/**
 * 
 */
package com.asiainfo.p5.javaCore.javaBasic.string;

/**
 * String的intern方法</p>
 * 在分析String的intern后的结果时一定要注意一个前提，代码是在jdk的哪个版本下运行的。由于jdk1.7之前字符串常量池是在方法区，而从1.7开始将字符串常量池一道堆区，所在jdk1.7之前和之后的版本进行测试结果可能会不一样。
 *
 * @author Administrator
 * @date 2020年2月2日 下午6:20:14
 */
public class StringIntern {
	public static void main(String[] args) {
		// 注意：测试本段代码的时候一定要检查下jdk的版本，一下分析是在jdk1.8的版本上进行的
		String s1 = "abc";
		String intern1 = s1.intern();
		System.out.println("intern1 = " + intern1);
		System.out.println("s1 == intern1	" + (s1 == intern1));
		
		
		String s2 = new String("abc");
		String intern2 = s2.intern();
		System.out.println("intern2 = " + intern2);
		System.out.println("intern1 == intern2	" + (intern1 == intern2));
		System.out.println("s2 == intern2	" + (s2 == intern2));
		System.out.println("s1 == s2	" + (s1 == s2));
		System.out.println("s1 == intern2	" + (s1 == intern2));
		
		System.out.println("-----------------------");
		String s5 = new String("hi") + new String("j");
		System.out.println("s5 = " + s5);
		s5.intern();
		String s6 = "hij";
		System.out.println("s5 == s6	" + (s5 == s6));// true，但在jdk1.7之前会返回false

	}
}
