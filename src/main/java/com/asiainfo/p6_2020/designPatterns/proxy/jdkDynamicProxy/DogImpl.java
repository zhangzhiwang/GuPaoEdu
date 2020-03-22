package com.asiainfo.p6_2020.designPatterns.proxy.jdkDynamicProxy;

public class DogImpl implements IDog {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("狗在吃饭");
	}

	@Override
	public void bark(String s, int i) {
		// TODO Auto-generated method stub
		System.out.println("s = " + s + ", i = " + i);
	}

}
