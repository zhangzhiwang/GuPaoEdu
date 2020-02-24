package com.asiainfo.p6_2020.designPatterns.factory.entity.suv;

public class BMWSUV implements ISUV {

	@Override
	public void run() {
		System.out.println("宝马SUV开动了");
	}

}
