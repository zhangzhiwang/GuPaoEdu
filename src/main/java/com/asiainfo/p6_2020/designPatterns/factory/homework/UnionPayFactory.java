package com.asiainfo.p6_2020.designPatterns.factory.homework;

public class UnionPayFactory implements IAbstractFactory {

	@Override
	public InlandPay createInlandPay() {
		return new InlandUnionPay();
	}

	@Override
	public ForeignPay createForeignPay() {
		return new ForeignUnionPay();
	}
}
