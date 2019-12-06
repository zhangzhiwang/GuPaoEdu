package com.asiainfo.p6.designPatterns.factory.factoryMethod;

import com.asiainfo.p6.designPatterns.factory.ICourse;

/**
 * 工厂方法模式测试
 *
 * @author zhangzhiwang
 * @date Oct 22, 2019 10:35:27 PM
 */
public class FactoryMethodTest {
	public static void main(String[] args) {
		/**
		 * 为了解决简单工厂模式违背单一职责原则和开闭原则，产生了工厂方发模式。每一个产品会有专门的工厂来创建， 一个工厂只创建一种产品，二者是一对一的关系，这样等业务规模扩大后出现新的产品，直接新增一个产品和对应生产该产品的工厂即可，无需改动既有代码。 客户端需要做的就是需要什么产品就去找相关产品线的工厂即可（买橘子要去橘子店，买香蕉要去香蕉店，一个商店只卖一种水果）。
		 * </p>
		 * 工厂方法模式优点：解决了简单工厂模式的两个问题：一个是一个工厂负责创建所有产品职责过重同时也违背单一职责原则，同时增加新产品的时候要修改工厂的判断逻辑，违背开闭原则。</p>
		 * 工厂方法模式缺点：每增加一个产品需要增加一个产品类的实现和与其对应的工厂，虽然符合开闭原则，但是大量增加工厂类会使系统当中的工厂类过多，代码文件会增多，这势必会增加系统的开销。
		 */

		// 需要Java课程，就去管生产Java课程的工厂去要
		JavaCourseFactory javaCourseFactory = new JavaCourseFactory();
		ICourse iCourse = javaCourseFactory.create();
		System.out.println(iCourse);

		// 需要AI课程，就去管生产AI课程的工厂去要
		AICourseFactory aiCourseFactory = new AICourseFactory();
		iCourse = aiCourseFactory.create();
		System.out.println(iCourse);

		/**
		 * 抽象工厂应用案例：java.util.Collection
		 * </p>
		 * 可以把Collection看作是工厂方法模式的抽象工厂，它生产一个抽象产品Iterator。这个抽象工厂Collection有好多实现工厂类，这些工厂只负责生产一种Iterator的子产品。</p>
		 * Collection的实现工厂有java.util.Arrays.ArrayList、java.util.LinkedList等，这些实现工厂只负责生产各自的产品：ArrayList的iterator()方法生产产品Itr，LinkedList的iterator()方法生产产品ListItr，而产品Itr和ListItr都是抽象产品Iterator的实现类。
		 */

	}
}
