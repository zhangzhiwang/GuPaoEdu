package com.asiainfo.p6.softwareFrameworkDesignPrinciple.lod;

import java.util.ArrayList;
import java.util.List;

/**
 * 顾客
 *
 * @author zhangzhiwang
 * @date Oct 21, 2019 8:35:26 PM
 */
public class Customer {
	/**
	 * 点菜
	 * 
	 * @author zhangzhiwang
	 * @date Oct 21, 2019 8:35:40 PM
	 */
	public void order(Restaurant restaurant) {
		// 顾客是不是只要最终的结果，就是炒熟的那盘菜，是不是不需要知道自己准备食材、锅碗瓢盆？具体准备什么食材是不是饭店的事情，顾客不用关心。
//		List list = new ArrayList();// 这段逻辑挪到饭店里
//		list.add("西红柿");
//		list.add("鸡蛋");
//		list.add("盘子");
		restaurant.cook();
	}
}
