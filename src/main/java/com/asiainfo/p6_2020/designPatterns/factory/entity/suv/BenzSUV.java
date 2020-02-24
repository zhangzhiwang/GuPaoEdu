package com.asiainfo.p6_2020.designPatterns.factory.entity.suv;

public class BenzSUV implements ISUV {

	@Override
	public void run() {
		System.out.println("奔驰SUV开动了");
	}

}
