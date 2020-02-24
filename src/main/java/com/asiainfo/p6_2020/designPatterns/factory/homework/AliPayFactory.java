package com.asiainfo.p6_2020.designPatterns.factory.homework;

public class AliPayFactory implements IAbstractFactory {

	@Override
	public InlandPay createInlandPay() {
		return new InlandAlipay();
	}

	@Override
	public ForeignPay createForeignPay() {
		return new ForeignAlipay();
	}
}
