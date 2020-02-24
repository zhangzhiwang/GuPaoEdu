package com.asiainfo.p6_2020.designPatterns.factory.factoryMethod;

import com.asiainfo.p6_2020.designPatterns.factory.entity.car.ICar;

/**
 * 工厂方法模式的工厂接口
 *
 * @author zhangzhiwang
 * @date Feb 23, 2020 11:17:57 PM
 */
public interface ICarFactoryMethod {
	ICar createCar();
}
