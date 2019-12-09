package com.asiainfo.p5.javaCore.reflect;

public class MySpringIOCTest {
	public static void main(String[] args) {
		MySpringIOCContainer.init("src/main/resources/applicationContext.xml");
		SpringTest springTest1 = (SpringTest) MySpringIOCContainer.getBean("springTest1");
		SpringTest springTest2 = (SpringTest) MySpringIOCContainer.getBean("springTest2");
		SpringTest springTest3 = (SpringTest) MySpringIOCContainer.getBean("springTest3");
		System.out.println(springTest1);
		System.out.println(springTest2);
		System.out.println(springTest3);
	}
}
