package com.asiainfo;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.asiainfo.controller.UserController;
import com.asiainfo.dao.IUserDao;
import com.asiainfo.entity.Cat;
import com.asiainfo.entity.Cat2;
import com.asiainfo.entity.Cat3;
import com.asiainfo.entity.User;
import com.asiainfo.entity.User3;
import com.asiainfo.service.IUserService;
import com.asiainfo.service.impl.UserServiceImpl;
import com.asiainfo.transaction.TxService;

/**
 * 模仿Spring Boot的启动类
 *
 * @author zhangzhiwang
 * @date Dec 23, 2020 1:43:57 PM
 */
@Configuration
@ComponentScan
//@EnableAspectJAutoProxy(proxyTargetClass = true)// 开启Aspec tJ，前提是引入aspectjweaver的依赖
public class AppStarter {
	public static void main(String[] args) throws Exception {
//		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppStarter.class);
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		IUserService userServiceImpl = (IUserService) applicationContext.getBean("s1");
//		System.out.println(userServiceImpl instanceof UserServiceImpl);// 如果被代理类实现了接口，那么Spring默认使用jdk动态代理，如果强制使用cglib动态代理，那么@EnableAspectJAutoProxy要加上参数proxyTargetClass并设置值为true
//		userServiceImpl.m3("", (byte)1);
//		System.out.println("-----------------");
//		
//		IUserDao userDao = (IUserDao) applicationContext.getBean("userDaoImpl");
//		userDao.test1("");
		
//		userServiceImpl.m3("10010", (byte)1);
//		System.out.println("-----------------");
//		userServiceImpl.m3("10010");
//		System.out.println("-----------------");
//		userServiceImpl.m3("10010", (byte)1);
//		System.out.println("-----------------");
//		userServiceImpl.m3((byte)1);
//		System.out.println("-----------------");
//		userServiceImpl.m3((short)1);
//		System.out.println("-----------------");
//		userServiceImpl.m3((short)1, (short)1);
//		System.out.println("-----------------");
//		userServiceImpl.m4();
//		System.out.println("-----------------");
//		userDao.m4();
//		userServiceImpl.m5(new Cat(), new Cat2(), new Cat3());
//		System.out.println("-----------------");
//		userDao.m5(new Cat(), new Cat2(), new Cat3());
//		userServiceImpl.m6();
//		System.out.println("-----------------");
//		userDao.m6();
//		userDao.insertUser(new User("ls", 19));
//		List<User> users = userDao.queryAllUsers();
//		System.out.println(users);
		
		TxService txService = applicationContext.getBean(TxService.class);
		txService.serviceMethod();
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:mysql://localhost:3306/test", "root", "zzw1234");
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
