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
		
		/**
		 * 23种设计模式一共可以分成3类：</p>
		 * 1、创建型模式：创建型模式的主要关注点是“怎样创建对象？”，它的主要特点是“将对象的创建与使用分离”。这样可以降低系统的耦合度，使用者不需要关注对象的创建细节，对象的创建由相关的工厂来完成。就像我们去商场购买商品时，不需要知道商品是怎么生产出来一样，因为它们由专门的厂商生产。</p>
		 * 2、结构型模式：描述如何将类或对象按某种布局组成更大的结构。它分为类结构型模式和对象结构型模式，前者采用继承机制来组织接口和类，后者釆用组合或聚合来组合对象。由于组合关系或聚合关系比继承关系耦合度低，满足“合成复用原则”，所以对象结构型模式比类结构型模式具有更大的灵活性。</p>
		 * 3、行为型模式：用于描述程序在运行时复杂的流程控制，即描述多个类或对象之间怎样相互协作共同完成单个对象都无法单独完成的任务，它涉及算法与对象间职责的分配。行为型模式分为类行为模式和对象行为模式，前者采用继承机制来在类间分派行为，后者采用组合或聚合在对象间分配行为。由于组合关系或聚合关系比继承关系耦合度低，满足“合成复用原则”，所以对象行为模式比类行为模式具有更大的灵活性。</p>
		 * 可参考：http://c.biancheng.net/design_pattern/
		 */
	}
}
