package com.asiainfo.p6.softwareFrameworkDesignPrinciple.lod;

import java.util.ArrayList;
import java.util.List;

/**
 * 饭店
 *
 * @author zhangzhiwang
 * @date Oct 21, 2019 8:34:32 PM
 */
public class Restaurant {
	public void cook() {
		List list = new ArrayList();
		list.add("西红柿");
		list.add("鸡蛋");
		list.add("盘子");
		System.out.println("准备了" + list.size() + "个东西，炒了一盘菜");
	}
}
