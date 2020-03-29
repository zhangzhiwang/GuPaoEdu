package com.asiainfo.p6_2020.designPatterns.adapter.interfaceAdapter;

public class MyInterfaceImpl1 implements MyInterface {// 实现类只需要实现a和c方法

	@Override
	public void a() {
		System.out.println("a");
	}

	@Override
	public void b() {
	}

	@Override
	public void c() {
		System.out.println("c");
	}

	@Override
	public void d() {
	}

	@Override
	public void e() {
	}

	@Override
	public void f() {// 其他不需要实现的方法要么空着，要么抛异常，这样是客户端调用的时候很疑惑。
		throw new UnsupportedOperationException("不支持该操作");
	}

}
