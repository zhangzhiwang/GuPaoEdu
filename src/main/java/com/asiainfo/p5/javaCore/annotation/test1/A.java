package com.asiainfo.p5.javaCore.annotation.test1;

import com.asiainfo.p5.javaCore.annotation.MyBean;

public class A {
	@MyBean("getA")
	public static A getA() {
		System.out.println("creating A...");
		return new A();
	}
}
