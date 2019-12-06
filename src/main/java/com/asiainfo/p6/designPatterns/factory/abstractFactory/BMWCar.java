package com.asiainfo.p6.designPatterns.factory.abstractFactory;

/**
 * 宝马轿车
 *
 * @author zhangzhiwang
 * @date Oct 24, 2019 1:25:31 PM
 */
public class BMWCar implements ICar {
	@Override
	public void run() {
		System.out.println("宝马轿车在跑");
	}
}
