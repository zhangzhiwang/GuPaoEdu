package com.asiainfo.p6.designPatterns.factory.abstractFactory;

/**
 * 工厂接口
 *
 * @author zhangzhiwang
 * @date Oct 24, 2019 1:33:18 PM
 */
public interface IFactory {
	/**
	 * 生产轿车
	 * 
	 * @return
	 * @author zhangzhiwang
	 * @date Oct 24, 2019 1:33:46 PM
	 */
	ICar createCar();
	
	/**
	 * 生产跑车
	 * 
	 * @return
	 * @author zhangzhiwang
	 * @date Oct 24, 2019 1:34:03 PM
	 */
	ISportsCar createSportsCar();
	
	/**
	 * 生产SUV
	 * 
	 * @return
	 * @author zhangzhiwang
	 * @date Oct 24, 2019 1:34:39 PM
	 */
	ISUV createSUV();
}
