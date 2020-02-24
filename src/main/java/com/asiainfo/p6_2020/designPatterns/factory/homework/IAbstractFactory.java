package com.asiainfo.p6_2020.designPatterns.factory.homework;

public interface IAbstractFactory {
	InlandPay createInlandPay();
	
	ForeignPay createForeignPay();
}
