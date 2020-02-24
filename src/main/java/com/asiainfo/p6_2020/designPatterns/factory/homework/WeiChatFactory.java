package com.asiainfo.p6_2020.designPatterns.factory.homework;

public class WeiChatFactory implements IAbstractFactory {

	@Override
	public InlandPay createInlandPay() {
		return new InlandWeiChat();
	}

	@Override
	public ForeignPay createForeignPay() {
		return new ForeignWeiChat();
	}
}
