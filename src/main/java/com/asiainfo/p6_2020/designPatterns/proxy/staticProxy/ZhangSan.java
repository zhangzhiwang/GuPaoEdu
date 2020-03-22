package com.asiainfo.p6_2020.designPatterns.proxy.staticProxy;

public class ZhangSan implements IEmployee {

	@Override
	public void huntJob() {
		System.out.println("张三找工作");
		
	}

	@Override
	public void huntHouse() {
		// TODO Auto-generated method stub
		System.out.println("张三找房子");
	}

}
