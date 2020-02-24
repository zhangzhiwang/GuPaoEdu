package com.asiainfo.p6_2020.designPatterns.factory.homework;

/**
 * 支付场景</p>
 * 支付分为海外支付和境内支付，这两个相当于产品等级结构，产品族是微信支付，支付宝支付和银联支付。假设微信可以境内支付也可以境外支付，其他同理。
 *
 * @author zhangzhiwang
 * @date Feb 24, 2020 10:29:30 PM
 */
public class PaymentTest {
	private static IAbstractFactory factory;
	
	static {
//		factory = new AliPayFactory();
//		factory = new WeiChatFactory();
		factory = new UnionPayFactory();
	}
	
	public static void main(String[] args) {
		InlandPay inlandpay = factory.createInlandPay();
		inlandpay.pay();
		
		ForeignPay foreignPay = factory.createForeignPay();
		foreignPay.pay();
	}
}
