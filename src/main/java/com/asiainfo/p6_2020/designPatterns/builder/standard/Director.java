package com.asiainfo.p6_2020.designPatterns.builder.standard;

/**
 * 指挥者：控制抽象建造者制定标准的实现步骤之间的顺序
 *
 * @author zhangzhiwang
 * @date Mar 12, 2020 8:08:21 PM
 */
public class Director {
	private Builder builder;

	public Director(Builder builder) {
		this.builder = builder;
	}

	public Car createACar() {
		// 这里规定调用顺序
//		builder.createCeiling();
//		builder.createSunroof();
		
		builder.createCeiling().createSunroof();// 链式编程
		return builder.assembleACar();
	}
}
