package com.asiainfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

import com.asiainfo.service.StudentService;
import com.asiainfo.service.UserService;

/**
 * spb的单元测试：
 * 1、引入单元测试依赖，注意引入的是spring-boot-starter-test依赖同时也要引入junit 4.12及以上的依赖，注意junit的版本必须是4.12以上。如果只使用junit而不使用spring-boot-starter-test的话，得自己在测试类编写启动Spring上下文的代码，比较费事，spb的单元测试注解已经做好了这一切。
 * 2、在测试类的生命处添加两个注解：
 * 	 （1）@RunWith(SpringRunner.class)
 *   （2）@SpringBootTest
 * 3、测试方法上的@Test是junit jar包里面的
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableCaching
public class AppTest {
	@Autowired
	private UserService userService;
	@Autowired
	private StudentService studentService;
	
	@Test
	public void test1() {
//		userService.testService1();
		studentService.queryById(1);
	}
}
