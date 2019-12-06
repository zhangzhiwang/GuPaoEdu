package com.asiainfo.p6.designPatterns.factory.abstractFactory;

/**
 * 奥迪工厂——只负责生产奥迪这个品牌所有产品等级的车
 *
 * @author zhangzhiwang
 * @date Oct 24, 2019 1:37:14 PM
 */
public class AudiFactory implements IFactory {

	@Override
	public ICar createCar() {
		// TODO Auto-generated method stub
		return new AudiCar();
	}

	@Override
	public ISportsCar createSportsCar() {
		// TODO Auto-generated method stub
		return new AudiSportsCar();
	}

	@Override
	public ISUV createSUV() {
		// TODO Auto-generated method stub
		return new AudiSUV();
	}

}
