package com.asiainfo.p6.designPatterns.factory.abstractFactory;

/**
 * 抽象工厂模式：抽象工厂模式是前两种工厂模式的抽象，它最具有一般性，简单工厂模式和工厂方法模式可以看作是抽象工厂模式的一个特例——如果所有产品族和所有产品等级结构里面的产品都由一个工厂生产，那么就是简单工厂模式，如果一个企业只有一个产品等级结构，那么就是工厂方法模式。
 * </p>
 * 有关产品等级结构和产品族的概念可以参考：https://blog.csdn.net/w405722907/article/details/87798453
 * </p>
 *
 * @author zhangzhiwang
 * @date Oct 24, 2019 12:59:20 PM
 */
public class AbstractFactoryTest {
	/**
	 * 为什么会有抽象工厂模式：是为了解决工厂方法模式的缺点。工厂方法模式解决了简单工厂模式的缺点，但自己也有缺点，那就是每增加一个产品就要相应地增加产品类和对应的工厂类，这样会导致工厂类文件增多，如果产品很多的话就会有大量的工厂类存在，导致项目文件变多。
	 * </p>
	 * 那么怎么样既解决简单工厂模式的缺点又使项目文件减少呢？我们就要扩大“单一职责原则”中“职责”的粒度。在工厂方法模式中，“单一职责”是指一个工厂只负责创建一个产品，不负责创建其他产品，现在要把这个职责放大——一个公司的工厂只负责本公司产品的创建，不负责其他公司产品的创建，而本公司的所有产品都由本公司这一个工厂来创建，这样就减少了工厂的个数。
	 * </p>
	 * 抽象方法模式的缺点：不符合开闭原则，如果增加了一个产品等级结构，比如增加了一个大巴车IBus，那么抽象工厂要改，所有的工厂实现类都要改
	 */

	private static IFactory factory;

	static {// 模拟注入的工厂实现类
		factory = new AudiFactory();
	}

	public static void main(String[] args) {
		// 具体选择哪个品牌的工厂由客户端说了算
		ICar car = factory.createCar();
		car.run();
		ISportsCar sportsCar = factory.createSportsCar();
		sportsCar.run();
		ISUV suv = factory.createSUV();
		suv.run();
		
		/**
		 * 抽象工厂模式的实际案例：java.sql.Connection。Connection相当于一个抽象工厂，java.sql.Statement和java.sql.PreparedStatement相当于两个产品等级结构，Connection生产这两个抽象产品（产品族），com.mysql.jdbc.ConnectionImpl是一个具体的工厂，专门生产mysql这个“品牌”的产品族——com.mysql.jdbc.StatementImpl和com.mysql.jdbc.ServerPreparedStatement。
		 * </p>
		 * 详见：https://www.jianshu.com/p/c2a91abe3d62
		 */
	}
}
