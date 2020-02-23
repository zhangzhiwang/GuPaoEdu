package com.asiainfo.p6_2020.designPatterns.factory.simpleFactory.entity;

/**
 * 奔驰轿车
 *
 * @author zhangzhiwang
 * @date Feb 23, 2020 10:40:53 PM
 */
public class BenzCar implements ICar {
	public void run() {
		System.out.println("奔驰轿车开动了");
	}
}
