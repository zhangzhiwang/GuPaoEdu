package com.asiainfo.p6_2020.designPatterns.facade.homework;

/**
 * 题库
 *
 * @author zhangzhiwang
 * @date Mar 8, 2020 5:57:31 PM
 */
public class DBNavigationDecorator extends NavigationDecorator{

	public DBNavigationDecorator(Navigation navigation) {
		super(navigation);
	}
	
	@Override
	public String display() {
		return super.display() + " + 题库";
	}

}
