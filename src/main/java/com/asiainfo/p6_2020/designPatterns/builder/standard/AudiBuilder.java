package com.asiainfo.p6_2020.designPatterns.builder.standard;

/**
 * 建造者实现——奥迪建造者
 *
 * @author zhangzhiwang
 * @date Mar 12, 2020 8:01:43 PM
 */
public class AudiBuilder implements Builder {
	public Car car = new Car("奥迪");

	@Override
	public Builder createCeiling() {
		car.setCeiling("奥迪车顶");
		return this;
	}

	@Override
	public Builder createSunroof() {
		car.setSunroof("奥迪天窗");
		return this;
	}

	@Override
	public Car assembleACar() {
		return car;
	}
	
}
