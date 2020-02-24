package com.asiainfo.p6_2020.designPatterns.factory.entity.sportsCar;

public class BenzSportsCar implements ISportsCar {

	@Override
	public void run() {
		System.out.println("奔驰跑车开动了");
	}

}
