package com.asiainfo.p6.softwareFrameworkDesignPrinciple.lod;

/**
 * 迪米特法则(Law of Demeter LoD)：也叫最少知道原则（Least Knowledge Principle），一个对象应该对其他的最想保持最少的了解，以减少类之间的耦合性。迪米特法则强调一个对象只和他的直接朋友对话，不和陌生人讲话。
 *
 * @author zhangzhiwang
 * @date Oct 21, 2019 8:15:27 PM
 */
public class TestLoD {
	// 场景：顾客到饭店点菜。顾客是不是只要最终的结果，就是炒熟的那盘菜，是不是不需要知道自己准备食材、锅碗瓢盆？这些是不是应该饭店来提供？
	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.order(new Restaurant());
	}
}
