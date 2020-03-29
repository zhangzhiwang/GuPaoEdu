package com.asiainfo.p6_2020.designPatterns.adapter.interfaceAdapter;

public class MyInterfaceImpl2 extends MyInterfaceAdapter {// 子类选择性地复写抽象类的方法即可

	@Override
	public void a() {
		System.out.println("a");
	}

	@Override
	public void c() {
		System.out.println("c"); 
	}

}
