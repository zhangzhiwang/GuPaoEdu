package com.asiainfo.p6_2020.designPatterns.factory.abstractFactory;

import com.asiainfo.p6_2020.designPatterns.factory.entity.car.ICar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.sportsCar.ISportsCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.suv.ISUV;

/**
 * 抽象工厂——一个工厂实现只负责生产一个品牌的所有产品线的产品，轿车、SUV和跑车是三个产品线
 *
 * @author zhangzhiwang
 * @date Feb 24, 2020 9:59:52 PM
 */
public interface AbstractFactory {
	ICar createCar();
	
	ISUV createSUV();
	
	ISportsCar createSportsCar();
}
