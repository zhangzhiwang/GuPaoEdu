package com.asiainfo.p6_2020.designPatterns.factory.abstractFactory;

import com.asiainfo.p6_2020.designPatterns.factory.entity.car.ICar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.sportsCar.ISportsCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.suv.ISUV;

/**
 * 抽象工厂模式</p>
 * 有产品族和产品等级结构的概念，横坐标是产品等级结构（就是产品线），纵坐标是产品族（就是不同的品牌），一个工厂负责生产一个品牌的所有产品线的产品
 *
 * @author zhangzhiwang
 * @date Feb 24, 2020 9:44:29 PM
 */
public class AbstractFactoryTest {
	private static AbstractFactory factory;
	
	static {
		factory =  new BenzFactory();
	}
	
	public static void main(String[] args) {
		// 要买奥迪任何产品线的车就去奥迪工厂要，其他工厂同理
		ICar car = factory.createCar();
		ISportsCar sportsCar = factory.createSportsCar();
		ISUV suv = factory.createSUV();
		
		car.run();
		sportsCar.run();
		suv.run();
		
	}
}
