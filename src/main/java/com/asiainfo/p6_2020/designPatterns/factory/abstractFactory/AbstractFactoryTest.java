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
		
		/**
		 * 抽象工厂模式的应用场景：jdbc</p>
		 * java.sql.Connection可以看作是抽象工厂，这个抽象工厂生产两个产品等级结构的产品（这里只拿两个举例子），且它们都是抽象产品接口，分别是Statement、PreparedStatement。</p>
		 * Connection有好多实现类，比如MySql的实现类com.mysql.jdbc.ConnectionImpl生产com.mysql.jdbc.StatementImpl、com.mysql.jdbc.PreparedStatement；Oracle的实现类oracle.jdbc.OracleConnectionWrapper生产具体产品com.mysql.jdbc.jdbc2.optional.StatementWrapper、com.mysql.jdbc.jdbc2.optional.PreparedStatementWrapper。
		 */
	}
}
