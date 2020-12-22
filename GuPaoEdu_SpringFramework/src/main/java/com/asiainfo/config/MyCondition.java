package com.asiainfo.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import com.asiainfo.entity.Product5;

public class MyCondition implements Condition {

	/**
	 * 返回值true-匹配，会将该类型加入搭配ioc中；false-不匹配，不会将该类型加入搭配ioc中
	 * 实际上Spring Boot中的各种花里胡哨的@ConditionOn***的本质都是实现了org.springframework.context.annotation.Condition接口，然后重写了matches方法，在matches方法中进行各种DIY
	 */
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//		// 需求1:如果ioc中存在类型为Product5的bean就返回true，否则返回false，模拟Spring Boot的@ConditionOnBean注解
//		Product5 bean = context.getBeanFactory().getBean(Product5.class);
//		if(bean == null) {
//			return false;
//		}
//		return true;
		
		// 需求2:如果ioc中不存在Product5的class就返回true，否则返回false，模拟Spring Boot的@ConditionOnMissingBean注解
		try {
			Class<?> clazz = context.getClassLoader().loadClass("com.asiainfo.entity.Product6");
			if(clazz == null) {
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return true;
		}
		
		return false;
	}
}
