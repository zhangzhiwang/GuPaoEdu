package com.asiainfo.p6_2020.designPatterns.facade.homework;

/**
 * 导航条装饰器接口
 *
 * @author zhangzhiwang
 * @date Mar 8, 2020 5:51:48 PM
 */
public abstract class NavigationDecorator implements Navigation {
	private Navigation navigation;
	
	public NavigationDecorator(Navigation navigation) {
		this.navigation = navigation;
	}
	
	@Override
	public String display() {
		return navigation.display();
	}
}
