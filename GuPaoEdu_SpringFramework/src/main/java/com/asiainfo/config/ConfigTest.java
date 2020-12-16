package com.asiainfo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.asiainfo.controller.UserController;
import com.asiainfo.dao.IUserDao;
import com.asiainfo.dao.impl.UserDaoImpl;
import com.asiainfo.entity.User;
import com.asiainfo.service.IUserService;
import com.asiainfo.service.impl.UserServiceImpl;

/**
 * 基于Java配置类的方式来注入bean 此种方式随着Spring Boot的流行而流行起来
 * 
 * @author zhangzhiwang
 * @date Dec 15, 2020 9:18:58 PM
 */
//@Configuration
public class ConfigTest {
//	@Bean(value = {"user8","u8","uu8"})// 手动指定bean的名称，可以使用value属性，也可以使用name属性，这两个都是数组，即一个bean可以有不同的别名相当于<bean name="user8","u8","uu8" class="com.asiainfo.entity.User"></bean>
//	@Bean(name = {"user8","u8","uu8"})
//	public User getUser() {// 默认方法名为bean的名称
//		return new User();
//	}

	@Bean
	public UserController userController(IUserService userService) {// 在调用此方法时Spring会在ioc容器中查找类型为IUserService的bean注入进来
		UserController userController = new UserController();
		userController.setUserService(userService);
		return userController;
	}

	@Bean
	public IUserService userService1(IUserDao userDao) {
		UserServiceImpl userServiceImpl = new UserServiceImpl();
		userServiceImpl.setUserDao(userDao);
		return userServiceImpl;
	}

	@Bean
	public IUserDao userDao123() {
		return new UserDaoImpl();
	}
}
