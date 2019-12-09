package com.asiainfo.p5.javaCore.reflect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Object bean = applicationContext.getBean("springTest3");
		System.out.println(bean);
	}
}
