package com.asiainfo;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.asiainfo.entity.User;
import com.asiainfo.service.UserService;

@SpringBootApplication
public class App {
	public static void main(String[] args) {
		
		// 思考：如果不使用SpringBoot（以后简称spb）而是直接使用原生的spring，如何在不启动tomcat的情况下通过main方法获取bean？
		// 方式一：通过解析xml配置文件
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		User user = (User) applicationContext.getBean("user");
//		System.out.println(user);
		
		// 方式二：通过扫描注解
//		ApplicationContext applicationContext2 = new AnnotationConfigApplicationContext("com.asiainfo");
//		UserService userService = applicationContext2.getBean(UserService.class);
//		System.out.println(userService);
		
		/**
		 *  上面两种方式是在使用原生spring且不气痛tomcat的情况下获取ioc容器中的bean的，spb的原理相当于上面的方式二——启动Spring上下文之后通过扫描注解来加载并获取bean。
		 *  spb的启动顺序是先运行main方法中的SpringApplication.run()来启动并加载Spring的上下文，然后会扫描@SpringBootApplication注解来加载spb的东西，所以执行main方法在先，扫描@SpringBootApplication注解在后。
		 */
		ApplicationContext applicationContext = SpringApplication.run(App.class, args);
		System.out.println(applicationContext);
		
		/**
		 * 更换及禁用启动的banner：
		 * spb默认的banner是：
		 *   .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 
 			如果要更换默认的banner可以在resources目录下创建一个名为“banner.txt”的文件，然后访问网址：http://patorjk.com/software/taag/，在输入框输入想展示的文字，然后将生成的图案拷贝到banner.txt文件里面即可，重启会生效。
 			如果想禁用banner，需要在main方法里面创建一个SpringApplication对象，如下：
		 */
		// 禁用banner
//		SpringApplication springApplication = new SpringApplication(App.class);
//		springApplication.setBannerMode(Mode.OFF);// 关闭banner
//		springApplication.run(args);
	}
}