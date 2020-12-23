package com.asiainfo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.asiainfo.controller.UserController;
import com.asiainfo.entity.User;

public class AppStarter {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigTest.class);
		UserController userController = (UserController) applicationContext.getBean("userController");
		User user = userController.queryUser();
		System.out.println(user);
	}
}
