package com.asiainfo.p5.javaCore.javaBasic;

public class HashCodeTest {
	public static void main(String[] args) {
		User user = new User(10, "zhangsan");
//		User user2 = new User(10, "zhangsan");
		System.out.println(user.hashCode());
		System.out.println(user.hashCode());
		System.out.println(user.hashCode());
		System.out.println(user.hashCode());
//		System.out.println(user2.hashCode());
//		
//		User u1 = user;
//		System.out.println(u1.hashCode());
		
	}
}
