package com.asiainfo.p5.javaCore.reflect;

import java.io.Serializable;

/**
 * 通过克隆创建对象该类必须实现标记接口Cloneable
 *
 * @author zhangzhiwang
 * @date Dec 18, 2019 10:01:46 AM
 */
public class MyObject {
	private int age;
	private String name;

	public MyObject(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "MyObject [age=" + age + ", name=" + name + "]";
	}

}
