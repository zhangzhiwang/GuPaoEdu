package com.asiainfo.p6_2020.designPatterns.builder.standard;

/**
 * 建造者实现——奔驰建造者
 *
 * @author zhangzhiwang
 * @date Mar 12, 2020 8:06:35 PM
 */
public class BenzBuilder implements Builder {
	public Car car = new Car("奔驰");

	@Override
	public Builder createCeiling() {
		car.setCeiling("奔驰车顶");
		return this;
	}

	@Override
	public Builder createSunroof() {
		car.setSunroof("奔驰天窗");
		return this;
	}

	@Override
	public Car assembleACar() {
		return car;
	}

}
