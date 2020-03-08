package com.asiainfo.p6_2020.designPatterns.facade.homework;

public class NavigationTest {
	public static void main(String[] args) {
		BaseNavigation baseNavigation = new BaseNavigation();
		System.out.println("未登录：" + baseNavigation.display());
		
		System.out.println("已登陆！");
		
		NavigationDecorator navigationDecorator = new HomeworkNavigationDecorator(baseNavigation);
		System.out.println(navigationDecorator.display());
		navigationDecorator = new GrowNavigationDecorator(navigationDecorator);
		System.out.println(navigationDecorator.display());
		navigationDecorator = new DBNavigationDecorator(navigationDecorator);
		System.out.println(navigationDecorator.display());
	}
}
