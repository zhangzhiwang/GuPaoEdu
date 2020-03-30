package com.asiainfo.p6_2020.designPatterns.strategy;

/**
 * 微信支付（具体策略2）
 *
 * @author zhangzhiwang
 * @date Mar 30, 2020 7:21:21 PM
 */
public class WeChatPay implements IStrategy {

	@Override
	public void pay() {
		System.out.println("微信支付");
	}

}
