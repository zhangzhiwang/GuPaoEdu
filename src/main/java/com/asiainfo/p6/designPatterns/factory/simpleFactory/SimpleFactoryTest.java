package com.asiainfo.p6.designPatterns.factory.simpleFactory;

import java.util.Calendar;
import com.asiainfo.p6.designPatterns.factory.AICourse;
import com.asiainfo.p6.designPatterns.factory.ICourse;
import com.asiainfo.p6.designPatterns.factory.JavaCourse;

/**
 * 简单工厂模式测试
 *
 * @author zhangzhiwang
 * @date Oct 22, 2019 8:52:21 PM
 */
public class SimpleFactoryTest {
	public static void main(String[] args) {
		// 没有工厂模式，客户端需要操心对象的创建过程
		JavaCourse javaCourse = new JavaCourse();
		javaCourse.record();

		AICourse aiCourse = new AICourse();
		aiCourse.record();

		System.out.println("----------");
		// 有了简单工厂，客户端再也不用担心创建产品实例的问题了，所有工作都有工厂来承担，只要告诉简单工厂要什么就可以了，工厂会创建出你要的产品。
		ICourse iCourse = SimpleFactory.create("ai");
		iCourse.record();
		System.out.println("----------");
		iCourse = SimpleFactory.create(JavaCourse.class);
		iCourse.record();

		/**
		 * 简单工厂模式的优缺点：优点是比不使用工厂模式要强，毕竟它把创建产品的具体过成封装起来了，是客户端不用再担心创建产品的问题；缺点是简单工厂什么对象都负责创建，“有点杂”，所承担的职责比较重，违反了单一职责原则，而且如果增加一个产品就势必要修改简单工厂的代码，违反了开闭原则
		 * </p>
		 * 简单工厂模式使用场合：产品数量不多且不会变化的情况下
		 */

		// 简单工厂模式使用场景：Calendar
		Calendar calendar = Calendar.getInstance();// 看源码
	}
}
