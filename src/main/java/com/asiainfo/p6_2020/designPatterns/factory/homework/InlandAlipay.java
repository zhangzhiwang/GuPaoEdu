package com.asiainfo.p6_2020.designPatterns.factory.homework;

/**
 * 境内支付宝
 *
 * @author zhangzhiwang
 * @date Feb 24, 2020 10:51:14 PM
 */
public class InlandAlipay implements InlandPay {

	@Override
	public void pay() {
		System.out.println("支付宝境内支付");
	}
	
}
