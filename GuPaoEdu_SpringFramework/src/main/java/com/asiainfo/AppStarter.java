package com.asiainfo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.asiainfo.controller.UserController;
import com.asiainfo.entity.User;
import com.asiainfo.service.IUserService;
import com.asiainfo.service.impl.UserServiceImpl;

/**
 * 模仿Spring Boot的启动类
 *
 * @author zhangzhiwang
 * @date Dec 23, 2020 1:43:57 PM
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy// 开启AspectJ，前提是引入aspectjweaver的依赖
public class AppStarter {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppStarter.class);
		IUserService userServiceImpl = (IUserService) applicationContext.getBean("s1_ext");
		userServiceImpl.m1();
		System.out.println("-----------------");
		userServiceImpl.m3(10010);
		System.out.println("-----------------");
		userServiceImpl.m3("10010");
		System.out.println("-----------------");
		userServiceImpl.m3("10010", (byte)1);
		System.out.println("-----------------");
		userServiceImpl.m3((byte)1);
		System.out.println("-----------------");
		userServiceImpl.m3((short)1);
		System.out.println("-----------------");
		userServiceImpl.m3((short)1, (short)1);
		System.out.println("-----------------");
		userServiceImpl.m4();
	}
}
