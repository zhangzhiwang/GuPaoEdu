package com.asiainfo.p6_2020.designPatterns.facade.homework;

/**
 * 导航条默认实现
 *
 * @author zhangzhiwang
 * @date Mar 8, 2020 5:50:17 PM
 */
public class BaseNavigation implements Navigation {

	@Override
	public String display() {
		return "默认导航条（问答、文章、精品课、冒泡、商城）";
	}

}
