/**
 * 
 */
package com.asiainfo.p5.javaCore.javaBasic;

/**
 * 
 *
 * @author Administrator
 * @date 2020年2月1日 上午10:18:21
 */
public class CloneTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		// 使用clone方法要注意两点：1、被克隆的类要实现Cloneable接口，否则报异常：CloneNotSupportedException 2、被克隆的类虽好复写clone方法 
		User user = new User(10, "zs");
		User user2 = user.clone();
		System.out.println(user == user2);
		System.out.println(user.equals(user2));
		System.out.println(user);
		System.out.println(user2);
	}
}
