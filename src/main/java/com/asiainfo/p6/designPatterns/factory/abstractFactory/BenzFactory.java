package com.asiainfo.p6.designPatterns.factory.abstractFactory;

/**
 * 奔驰工厂——只负责生产奔驰这个品牌所有产品等级的车
 *
 * @author zhangzhiwang
 * @date Oct 24, 2019 1:36:27 PM
 */
public class BenzFactory implements IFactory {

	@Override
	public ICar createCar() {
		// TODO Auto-generated method stub
		return new BenzCar();
	}

	@Override
	public ISportsCar createSportsCar() {
		// TODO Auto-generated method stub
		return new BenzSportsCar();
	}

	@Override
	public ISUV createSUV() {
		// TODO Auto-generated method stub
		return new BenzSUV();
	}

}
