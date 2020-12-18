package com.asiainfo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.ComponentScan.Filter;

import com.asiainfo.controller.UserController;
import com.asiainfo.dao.IUserDao;
import com.asiainfo.dao.impl.UserDaoImpl;
import com.asiainfo.entity.Product;
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
//@Lazy// 延迟初始化
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
//@ComponentScans({
//	@ComponentScan(basePackages = {"com.asiainfo.controller"}, useDefaultFilters = false, includeFilters = {@Filter(type = FilterType.ANNOTATION, value = {Controller.class})}),
//	@ComponentScan(basePackages = {"com.asiainfo.service"}, useDefaultFilters = true, excludeFilters = {@Filter(type = FilterType.ANNOTATION, value = {Controller.class})}),
//	@ComponentScan(basePackages = {"com.asiainfo.dao"})
//})
@PropertySource({"classpath:db.properties"})// 必须在配置类指定读取的配置文件路径及名称才能使用@Value("${}")读取值。在spb中默认读取application.yml/properties中的属性，如果需要读取其它自定义的配置文件也要使用此种方式。
public class ConfigTest {
//	@Bean(value = {"user8","u8","uu8"})// 手动指定bean的名称，可以使用value属性，也可以使用name属性，这两个都是数组，即一个bean可以有不同的别名相当于<bean name="user8","u8","uu8" class="com.asiainfo.entity.User"></bean>
//	@Bean(name = {"user8","u8","uu8"})
//	public User getUser() {// 默认方法名为bean的名称
//		return new User();
//	}

//	@Bean(name = {"userController"})
//	public UserController userController(IUserService userService) {// 在调用此方法时Spring会在ioc容器中查找类型为IUserService的bean注入进来
//		UserController userController = new UserController();
////		userController.setUserService(userService);
//		return userController;
//	}
//	
//	@Bean(name = {"userController"})
//	public UserController userController() {
//		UserController userController = new UserController();
//		return userController;
//	}
//
//	@Bean
//	public IUserService userService(IUserDao userDao) {
//		UserServiceImpl userServiceImpl = new UserServiceImpl();
//		userServiceImpl.setUserDao(userDao);
//		return userServiceImpl;
//	}
//
//	@Bean
//	public IUserDao userDao123() {
//		return new UserDaoImpl();
//	}
	
//	@Bean(name = {"u1"})
////	@Lazy// 延迟初始化
//	public User user() {
//		return new User();
////		return new User("zs",1);
//	}
//	
//	@Bean(name = {"u2"})
////	@Primary
//	public User user2() {
//		return new User("ls",2);
//	}
	
//	@Bean
////	@Lazy// 延迟初始化
//	public Product product() {
//		return new Product();
//	}
	
	@PreDestroy// 系统被销毁之前执行
	public void met1() {
		System.out.println("被@PreDestroy标注的方法执行");
	}
}
