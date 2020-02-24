package com.asiainfo.p6_2020.designPatterns.factory.abstractFactory;

import com.asiainfo.p6_2020.designPatterns.factory.entity.car.AudiCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.car.BenzCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.car.ICar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.sportsCar.AudiSportsCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.sportsCar.BenzSportsCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.sportsCar.ISportsCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.suv.AudiSUV;
import com.asiainfo.p6_2020.designPatterns.factory.entity.suv.BenzSUV;
import com.asiainfo.p6_2020.designPatterns.factory.entity.suv.ISUV;

public class BenzFactory implements AbstractFactory {

	@Override
	public ICar createCar() {
		return new BenzCar();
	}

	@Override
	public ISUV createSUV() {
		return new BenzSUV();
	}

	@Override
	public ISportsCar createSportsCar() {
		return new BenzSportsCar();
	}

}
