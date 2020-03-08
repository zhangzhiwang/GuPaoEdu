package com.asiainfo.p6_2020.designPatterns.decorator;

/**
 * 抽象装饰器
 *
 * @author zhangzhiwang
 * @date Mar 5, 2020 3:20:58 PM
 */
public abstract class Decorator implements House {
	private House house;
	public Decorator(House house) {
		this.house = house;
	}
	
	@Override
	public String desc() {
		return house.desc();
	}

	@Override
	public int price() {
		return house.price();
	}
}
