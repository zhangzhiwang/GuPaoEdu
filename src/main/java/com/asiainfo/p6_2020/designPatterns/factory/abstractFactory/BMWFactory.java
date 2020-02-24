package com.asiainfo.p6_2020.designPatterns.factory.abstractFactory;

import com.asiainfo.p6_2020.designPatterns.factory.entity.car.AudiCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.car.BMWCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.car.BenzCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.car.ICar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.sportsCar.AudiSportsCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.sportsCar.BMWSportsCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.sportsCar.BenzSportsCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.sportsCar.ISportsCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.suv.AudiSUV;
import com.asiainfo.p6_2020.designPatterns.factory.entity.suv.BMWSUV;
import com.asiainfo.p6_2020.designPatterns.factory.entity.suv.BenzSUV;
import com.asiainfo.p6_2020.designPatterns.factory.entity.suv.ISUV;

public class BMWFactory implements AbstractFactory {

	@Override
	public ICar createCar() {
		return new BMWCar();
	}

	@Override
	public ISUV createSUV() {
		return new BMWSUV();
	}

	@Override
	public ISportsCar createSportsCar() {
		return new BMWSportsCar();
	}

}
