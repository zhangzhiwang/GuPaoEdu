package com.asiainfo.p6_2020.designPatterns.decorator;

/**
 * 沙发
 *
 * @author zhangzhiwang
 * @date Mar 5, 2020 3:27:08 PM
 */
public class SofaDecorator extends Decorator {

	public SofaDecorator(House house) {
		super(house);
	}
	
	@Override
	public String desc() {
		return super.desc() + " + 沙发";
	}

	@Override
	public int price() {
		return super.price() + 2;
	}
}