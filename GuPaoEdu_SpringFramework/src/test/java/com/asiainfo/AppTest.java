package com.asiainfo;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asiainfo.entity.User;

public class AppTest {
	/**
	 * 不使用Spring的原始方式获取对象——自力更生
	 * 
	 * @author zhangzhiwang
	 * @date Dec 15, 2020 11:37:37 AM
	 */
//	@Test
//    public void testOriginalWithoutSpring() {
//    	User user = new User("zhangsan", 18);
//    	System.out.println(user);
//    }
	
	/**
	 * 使用Spring原始的方式获取bean
	 * 
	 * @author zhangzhiwang
	 * @date Dec 15, 2020 11:54:29 AM
	 */
//	@Test
//	public void testSpringOriginal() {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
////		Object bean = applicationContext.getBean("user3");// User要有无参构造器。通过name来获取bean，这个name可以和xml中<bean>标签的id属性相同，也可以跟name属性相同，即通过<bean>标签的id和neme都能获取到bean对象
////		System.out.println(bean);
//		
//		// <bean>标签的id属性和name属性的区别：加入id的是一个整体哪怕其中有逗号，name可以有多个，每个名称可以用“,”、“;”和“ ”（空格）分割。id相当于身份证，name可以起多个别名。
////		Object bean = applicationContext.getBean("user1,user2,user3");// 通过id获取，“user1,user2,user3”是一个整体不可分割
////		Object bean = applicationContext.getBean("u1");// 通过name获取，“u1,u2,u3”不是一个整体，不能用整体来获取bean，必须用单个name来获取
////		System.out.println(bean);
//		
//		// 通过class来获取，默认情况下如果容器中有相同类型的bean，获取时会报错
////		Object bean = applicationContext.getBean(User.class);
////		System.out.println(bean);
//		// 解决方法有两种：
//		// 1、通过名称和类型来获取
////		Object bean = applicationContext.getBean("u1", User.class);
////		System.out.println(bean);
//		
//		// 2、在bean定义的时候加上primary="true"属性，代表如果出现相同类型的bean，标识为primary="true"的bean优先被获取
//		Object bean = applicationContext.getBean(User.class);
//		System.out.println(bean);
//	}
	
	@Test
	public void testBeanFactory() {
		/**
		 * 面试题：BeanFactory和ApplicationContext的区别。
		 * 1、从类结构上来看，ApplicationContext是BeanFactory的子接口，ApplicationContext间接继承了BeanFactory接口。既然是子接口，那么BeanFactory有的功能ApplicationContext全有。
		 * 同时ApplicationContext还继承了其他接口，比如消息通知接口和事件发布接口等，所以ApplicationContext的功能比BeanFactory丰富。
		 * 2、ApplicationContext会在ioc容器初始化的时候实例化所有对象，而BeanFactory实在使用的时候实例化用到的对象。
		 */
		
		// 验证上面第2点
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");// 在ioc容器初始化的时候实例化所有在xml里面配置的bean
		
//		BeanFactory bea = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
}
