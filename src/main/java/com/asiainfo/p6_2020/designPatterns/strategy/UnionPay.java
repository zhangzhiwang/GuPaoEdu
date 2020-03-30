package com.asiainfo.p6_2020.designPatterns.strategy;

/**
 * 银联支付（具体策略3）
 *
 * @author zhangzhiwang
 * @date Mar 30, 2020 7:22:32 PM
 */
public class UnionPay implements IStrategy {

	@Override
	public void pay() {
		System.out.println("银联支付");
	}

}
