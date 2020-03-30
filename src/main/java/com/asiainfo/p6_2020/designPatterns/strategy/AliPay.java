package com.asiainfo.p6_2020.designPatterns.strategy;

/**
 * 支付宝（具体策略1）
 *
 * @author zhangzhiwang
 * @date Mar 30, 2020 7:19:18 PM
 */
public class AliPay implements IStrategy {

	@Override
	public void pay() {
		System.out.println("支付宝支付");
	}

}
