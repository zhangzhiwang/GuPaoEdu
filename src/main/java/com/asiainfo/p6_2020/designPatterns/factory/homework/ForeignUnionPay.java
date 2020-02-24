package com.asiainfo.p6_2020.designPatterns.factory.homework;

/**
 * 海外银联
 *
 * @author zhangzhiwang
 * @date Feb 24, 2020 10:49:39 PM
 */
public class ForeignUnionPay implements ForeignPay {

	@Override
	public void pay() {
		System.out.println("银联海外支付");
	}
	
}
