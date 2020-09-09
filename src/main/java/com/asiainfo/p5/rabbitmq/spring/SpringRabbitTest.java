package com.asiainfo.p5.rabbitmq.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringRabbitTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		SpringRabbitProvider springRabbitProvider = (SpringRabbitProvider) applicationContext.getBean("springRabbitProvider");
		springRabbitProvider.test();
	}
}
