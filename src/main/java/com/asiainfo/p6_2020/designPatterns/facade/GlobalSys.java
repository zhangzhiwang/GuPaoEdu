package com.asiainfo.p6_2020.designPatterns.facade;

/**
 * 对外暴露一个统一的总体接口
 *
 * @author zhangzhiwang
 * @date Mar 5, 2020 9:41:49 AM
 */
public class GlobalSys {
	public static void global(String s) {
		OrderSys.order(s);
		PaymentSys.pay(s);
		LogisticsSys.check(s);
	}
}
