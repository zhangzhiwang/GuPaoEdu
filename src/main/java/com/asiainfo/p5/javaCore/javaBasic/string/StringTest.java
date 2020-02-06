/**
 * 
 */
package com.asiainfo.p5.javaCore.javaBasic.string;

/**
 * 
 *
 * @author Administrator
 * @date 2020年2月2日 下午5:23:40
 */
public class StringTest {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1 == s2);// true
		
		String s3 = "a" + "bc";// 直接将拼接后的结果放到常量池里面，所以这行代码只创建了一个对象“abc”（如果之前没有创建过“abc”）
		
		System.out.println(s1 == s3);// true
		
		String s4 = new String("abc");
		System.out.println(s1 == s4);// false
		
		String s5 = "a";
		String s6 = s5 + "bc";// 会创建一个StringBuilder对象，然后用append方法进行拼接，最后调用toString()方法返回，而toString()方法是通过new String()来实现的
		System.out.println(s3 == s6);// false
	}
}
