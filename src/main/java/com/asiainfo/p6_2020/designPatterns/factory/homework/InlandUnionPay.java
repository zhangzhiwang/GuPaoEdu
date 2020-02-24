package com.asiainfo.p6_2020.designPatterns.factory.homework;

/**
 * 境内银联
 *
 * @author zhangzhiwang
 * @date Feb 24, 2020 10:49:39 PM
 */
public class InlandUnionPay implements InlandPay {

	@Override
	public void pay() {
		System.out.println("银联境内支付");
	}
	
}
