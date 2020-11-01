package com.asiainfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.asiainfo.entity.User;
import com.asiainfo.service.UserService;

//@SpringBootApplication
public class App {
	public static void main(String[] args) {
//		ConfigurableApplicationContext applicationContext = SpringApplication.run(App.class, args);
//		System.out.println(applicationContext);
		
		// 思考：如果不使用SpringBoot（以后简称spb）而是直接使用原生的spring，如何在不启动tomcat的情况下通过main方法获取bean？
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		User user = (User) applicationContext.getBean("user");
//		System.out.println(user);
		
		ApplicationContext applicationContext2 = new AnnotationConfigWebApplicationContext();
		UserService userService = applicationContext2.getBean(UserService.class);
		System.out.println(userService);
	}
}