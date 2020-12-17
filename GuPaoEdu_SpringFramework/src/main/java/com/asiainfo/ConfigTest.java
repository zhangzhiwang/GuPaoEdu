package com.asiainfo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.ComponentScan.Filter;

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
@Configuration
/**
 * @ComponentScan 注解相当于配置文件中的<context:component-scan>标签，默认情况下（不带任何属性）会扫描被@ComponentScan标注的类所在包及其子包下的类。
 * 以下配置相当于配置文件中的：
 * 	<context:component-scan base-package="com.asiainfo.controller" use-default-filters="false"> 
		<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/> 
	</context:component-scan> 
	<context:component-scan base-package="com.asiainfo.service" use-default-filters="true"> 
		<context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/> 
	</context:component-scan> 
 */
@ComponentScans({
	@ComponentScan(basePackages = {"com.asiainfo.controller"}, useDefaultFilters = false, includeFilters = {@Filter(type = FilterType.ANNOTATION, value = {Controller.class})}),
	@ComponentScan(basePackages = {"com.asiainfo.service"}, useDefaultFilters = true, excludeFilters = {@Filter(type = FilterType.ANNOTATION, value = {Controller.class})}),
	@ComponentScan(basePackages = {"com.asiainfo.dao"})
})
public class ConfigTest {
//	@Bean(value = {"user8","u8","uu8"})// 手动指定bean的名称，可以使用value属性，也可以使用name属性，这两个都是数组，即一个bean可以有不同的别名相当于<bean name="user8","u8","uu8" class="com.asiainfo.entity.User"></bean>
//	@Bean(name = {"user8","u8","uu8"})
//	public User getUser() {// 默认方法名为bean的名称
//		return new User();
//	}

//	@Bean
//	public UserController userController(IUserService userService) {// 在调用此方法时Spring会在ioc容器中查找类型为IUserService的bean注入进来
//		UserController userController = new UserController();
////		userController.setUserService(userService);
//		return userController;
//	}
//
//	@Bean
//	public IUserService userService1(IUserDao userDao) {
//		UserServiceImpl userServiceImpl = new UserServiceImpl();
//		userServiceImpl.setUserDao(userDao);
//		return userServiceImpl;
//	}
//
//	@Bean
//	public IUserDao userDao123() {
//		return new UserDaoImpl();
//	}
}
