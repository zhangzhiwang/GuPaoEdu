package com.asiainfo.p6_2020.designPatterns.factory.simpleFactory;

import com.asiainfo.p6_2020.designPatterns.factory.entity.car.AudiCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.car.BMWCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.car.BenzCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.car.ICar;

/**
 * 生产所有汽车的简单工厂
 *
 * @author zhangzhiwang
 * @date Feb 23, 2020 9:03:01 PM
 */
public class SimpleCarFactory {
	// 简单工厂中只需要有一个获取实例的方法即可，这里写了三个主要是为了演示createACar方法优化的过程
	/**
	 * 第一版获取ICar实例的方法
	 * 
	 * @param name
	 * @return
	 * @author zhangzhiwang
	 * @date Feb 23, 2020 10:52:44 PM
	 */
	public static ICar createACar(String name) {
		if("Benz".equals(name)) {
			return new BenzCar();
		} else if("BMW".equals(name)) {
			return new BMWCar();
		} else if("Audi".equals(name)) {
			return new AudiCar();
		}
		
		return null;
	}
	
	/**
	 * 第二版获取ICar实例的方法
	 * 
	 * @param className
	 * @return
	 * @throws Exception
	 * @author zhangzhiwang
	 * @date Feb 23, 2020 10:57:00 PM
	 */
	public static ICar createACar2(String className) throws Exception {
		return (ICar)Class.forName(className).newInstance();
	}
	
	/**
	 * 第三版获取ICar实例的方法
	 * 
	 * @param className
	 * @return
	 * @throws Exception
	 * @author zhangzhiwang
	 * @date Feb 23, 2020 10:57:00 PM
	 */
	public static ICar createACar3(Class<? extends ICar> clazz) throws Exception {
		return clazz.newInstance();
	}
}
