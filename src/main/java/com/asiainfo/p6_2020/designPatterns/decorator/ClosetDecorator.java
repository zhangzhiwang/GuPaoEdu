package com.asiainfo.p6_2020.designPatterns.decorator;

/**
 * 衣柜
 *
 * @author zhangzhiwang
 * @date Mar 5, 2020 3:26:56 PM
 */
public class ClosetDecorator extends Decorator {

	public ClosetDecorator(House house) {
		super(house);
	}

	@Override
	public String desc() {
		return super.desc() + " + 衣柜";
	}

	@Override
	public int price() {
		return super.price() + 1;
	}

}
