package com.asiainfo.p6_2020.designPatterns.factory.factoryMethod;

import com.asiainfo.p6_2020.designPatterns.factory.entity.car.AudiCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.car.BMWCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.car.BenzCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.car.ICar;

/**
 * BMW生产轿车的工厂
 *
 * @author zhangzhiwang
 * @date Feb 23, 2020 11:19:41 PM
 */
public class AudiCarFactory implements ICarFactoryMethod {
	@Override
	public ICar createCar() { 
		return new AudiCar();
	}
}
