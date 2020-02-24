package com.asiainfo.p6_2020.designPatterns.factory.homework;

/**
 * 海外微信
 *
 * @author zhangzhiwang
 * @date Feb 24, 2020 10:48:40 PM
 */
public class ForeignWeiChat implements ForeignPay {

	@Override
	public void pay() {
		System.out.println("微信海外支付");
	}

}
