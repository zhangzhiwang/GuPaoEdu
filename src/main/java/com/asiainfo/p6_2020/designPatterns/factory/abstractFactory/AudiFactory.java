package com.asiainfo.p6_2020.designPatterns.factory.abstractFactory;

import com.asiainfo.p6_2020.designPatterns.factory.entity.car.AudiCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.car.ICar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.sportsCar.AudiSportsCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.sportsCar.ISportsCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.suv.AudiSUV;
import com.asiainfo.p6_2020.designPatterns.factory.entity.suv.ISUV;

public class AudiFactory implements AbstractFactory {

	@Override
	public ICar createCar() {
		return new AudiCar();
	}

	@Override
	public ISUV createSUV() {
		return new AudiSUV();
	}

	@Override
	public ISportsCar createSportsCar() {
		return new AudiSportsCar();
	}

}
