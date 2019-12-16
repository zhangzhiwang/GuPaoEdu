package com.asiainfo.p5.javaCore.annotation.test1.test2;

import com.asiainfo.p5.javaCore.annotation.MyBean;

public class B {
	@MyBean("getB")
	public B getB() {
		System.out.println("creating B...");
		return new B();
	}
}
