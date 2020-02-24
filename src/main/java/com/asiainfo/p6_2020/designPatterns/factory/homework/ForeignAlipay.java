package com.asiainfo.p6_2020.designPatterns.factory.homework;

/**
 * 海外支付宝
 *
 * @author zhangzhiwang
 * @date Feb 24, 2020 10:51:14 PM
 */
public class ForeignAlipay implements ForeignPay {

	@Override
	public void pay() {
		System.out.println("支付宝海外支付");
	}
	
}
