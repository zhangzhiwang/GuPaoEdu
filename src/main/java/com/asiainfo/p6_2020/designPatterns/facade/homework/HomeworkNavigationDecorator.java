package com.asiainfo.p6_2020.designPatterns.facade.homework;

/**
 * 作业装饰器
 *
 * @author zhangzhiwang
 * @date Mar 8, 2020 5:54:47 PM
 */
public class HomeworkNavigationDecorator extends NavigationDecorator{

	public HomeworkNavigationDecorator(Navigation navigation) {
		super(navigation);
	}
	
	@Override
	public String display() {
		return super.display() + " + 作业";
	}
	
}
