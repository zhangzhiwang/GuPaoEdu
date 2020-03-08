package com.asiainfo.p6_2020.designPatterns.facade.homework;

/**
 * 成长墙
 *
 * @author zhangzhiwang
 * @date Mar 8, 2020 5:57:31 PM
 */
public class GrowNavigationDecorator extends NavigationDecorator{

	public GrowNavigationDecorator(Navigation navigation) {
		super(navigation);
	}
	
	@Override
	public String display() {
		return super.display() + " + 成长墙";
	}

}
