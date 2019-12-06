package com.asiainfo.p6.designPatterns.factory.abstractFactory;

/**
 * 宝马工厂——只负责生产宝马这个品牌所有产品等级的车
 *
 * @author zhangzhiwang
 * @date Oct 24, 2019 1:35:14 PM
 */
public class BMWFactory implements IFactory {

	@Override
	public ICar createCar() {
		// TODO Auto-generated method stub
		return new BMWCar();
	}

	@Override
	public ISportsCar createSportsCar() {
		// TODO Auto-generated method stub
		return new BMWSportsCar();
	}

	@Override
	public ISUV createSUV() {
		// TODO Auto-generated method stub
		return new BMWSUV();
	}

}
