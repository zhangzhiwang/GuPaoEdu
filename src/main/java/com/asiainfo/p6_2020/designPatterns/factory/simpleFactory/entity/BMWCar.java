package com.asiainfo.p6_2020.designPatterns.factory.simpleFactory.entity;

/**
 * 宝马轿车
 *
 * @author zhangzhiwang
 * @date Feb 23, 2020 10:40:53 PM
 */
public class BMWCar implements ICar {
	public void run() {
		System.out.println("宝马轿车开动了");
	}
}
