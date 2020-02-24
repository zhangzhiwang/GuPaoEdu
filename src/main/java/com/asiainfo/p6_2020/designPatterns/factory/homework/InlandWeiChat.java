package com.asiainfo.p6_2020.designPatterns.factory.homework;

/**
 * 境内微信
 *
 * @author zhangzhiwang
 * @date Feb 24, 2020 10:48:40 PM
 */
public class InlandWeiChat implements InlandPay {

	@Override
	public void pay() {
		System.out.println("微信境内支付");
	}

}
