package com.asiainfo.p6_2020.designPatterns.factory.entity.car;

/**
 * 奥迪轿车
 *
 * @author zhangzhiwang
 * @date Feb 23, 2020 10:40:53 PM
 */
public class AudiCar implements ICar {
	public void run() {
		System.out.println("奥迪轿车开动了");
	}
}
