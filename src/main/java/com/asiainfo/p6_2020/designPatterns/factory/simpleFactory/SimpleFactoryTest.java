package com.asiainfo.p6_2020.designPatterns.factory.simpleFactory;

import java.util.Calendar;

import com.asiainfo.p6_2020.designPatterns.factory.entity.car.AudiCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.car.BMWCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.car.BenzCar;
import com.asiainfo.p6_2020.designPatterns.factory.entity.car.ICar;

/**
 * 简单工厂模式
 *
 * @author zhangzhiwang
 * @date Feb 23, 2020 9:03:01 PM
 */
public class SimpleFactoryTest {
	public static void main(String[] args) throws Exception {
		// 没有工厂模式的时候客户端需要位创建产品实例操心
		// 开奔驰轿车
		BenzCar benzCar = new BenzCar();
		benzCar.run();
		
		// 开宝奥迪轿车
		AudiCar audiCar = new AudiCar();
		audiCar.run();
		
		// 开宝马轿车
		BMWCar bmwCar = new BMWCar();
		bmwCar.run();
		
		System.out.println("----------");
		// 为了让客户端不在操心创建产品的具体逻辑把这个事情转交给工厂去做，客户端只需要告诉工厂你要什么就可以了
		// 第一版获取ICar实例的方法：
		ICar car = SimpleCarFactory.createACar("Benz");// 告诉简单工厂“我要一辆奔驰轿车”
		car.run();
		
		car =  SimpleCarFactory.createACar("Audi");
		car.run();
		
		car =  SimpleCarFactory.createACar("BMW");
		car.run();
		
		System.out.println("----------");
		// 第二版获取ICar实例的方法：
		car = SimpleCarFactory.createACar2("com.asiainfo.p6_2020.designPatterns.factory.simpleFactory.entity.BenzCar");// 告诉简单工厂“我要一辆奔驰轿车”
		car.run();
		
		car =  SimpleCarFactory.createACar2("com.asiainfo.p6_2020.designPatterns.factory.simpleFactory.entity.AudiCar");
		car.run();
		
		car =  SimpleCarFactory.createACar2("com.asiainfo.p6_2020.designPatterns.factory.simpleFactory.entity.BMWCar");
		car.run();
		
		System.out.println("----------");
		// 第三版获取ICar实例的方法：
		car = SimpleCarFactory.createACar3(BenzCar.class);// 告诉简单工厂“我要一辆奔驰轿车”
		car.run();
		
		car =  SimpleCarFactory.createACar3(AudiCar.class);
		car.run();
		
		car =  SimpleCarFactory.createACar3(BMWCar.class);
		car.run();
		
		/**
		 * 简单工厂模式的优缺点：</p>
		 * 优点：比没有工厂模式强，虽然它是最原始的工厂模式但是它毕竟将实例化的工作从客户端中解放了出来，挪到了工厂类里面去单独处理，使客户端不用再关心创建对象的细节问题。</p>
		 * 缺点：可以看到，简单工厂方法再怎么优化他也是一个万能工厂，就是这个工厂什么都生产。在第一种获取实例的方式下每增加一个品牌的轿车产品就要修改简单工厂的逻辑——增加if判断来迎合新产品的创建，违反了开闭原则；</p>
		 * 在第二、三种获取实例的方式下虽然不需要随着产品的增加而修改代码，但是一个工厂负责创建所有品牌的所有产品违反了类的单一职责原则。为了解决单一职责原则呢，这三个品牌商决定要分开生产——各品牌生产各品牌的矫车，这样的话一个工厂只负责生产一个品牌的轿车，工厂职责单一了代价是每个品牌都得创建自己的工厂，于是工厂方法模式诞生了。
		 */
		
		// 简单工厂模式的应用场景：
		Calendar calendar = Calendar.getInstance();// 通过源码可以看出来简单工厂模式虽然简单且原始，但仍然有在被使用，只要你创建对象的种类比较少且固定完全可以使用简单工厂模式
	}
}
