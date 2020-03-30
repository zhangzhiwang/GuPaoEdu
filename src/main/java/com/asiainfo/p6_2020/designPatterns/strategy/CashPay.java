package com.asiainfo.p6_2020.designPatterns.strategy;

/**
 * 现金支付（具体策略4）
 *
 * @author zhangzhiwang
 * @date Mar 30, 2020 7:31:34 PM
 */
public class CashPay implements IStrategy {

	@Override
	public void pay() {
		System.out.println("现金支付");
	}

}
