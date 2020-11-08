package com.asiainfo;

import org.springframework.boot.Banner.Mode;

import javax.servlet.annotation.WebServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationImportSelector;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.asiainfo.entity.Order;
import com.asiainfo.entity.Product;
import com.asiainfo.entity.User;
import com.asiainfo.service.UserService;
import com.asiainfo.servlet.ServletTest2;

import com1.asiainfo1.service1.AutoConfigService;

/**
 * 关于@SpringBootApplication注解：
 * 1、@ComponentScan
 * 	  实现扫描并加载启动类所在包及其子包下面的注解的功能，也是默认实现
 * 2、@SpringBootConfiguration
 *    实际就是个@Configuration注解
 * 3、@EnableAutoConfiguration
 *    spb最核心的注解，实现了自动装配的功能。
 *    @Import注解可以实现将一个类对象被spring托管
 *    spb自动装配原理：主要是@EnableAutoConfiguration注解里面@Import了一个AutoConfigurationImportSelector，通过分析AutoConfigurationImportSelector.selectImports()方法的源码可以得出以下结论：
 *    自动装配就是能够自动加载所有依赖jar包里面的类对象并注册为spring的bean，spb是如何做到的呢？
 *    既然spb提倡“约定大于配置”，那么在这个问题上spb约定：如果一个第三方jar包里面的类对象想被spb加载到ioc容器，那么它必须在/META-INF下面提供两个文件，这样才能和spb集成。这两个文件是：
 *    （1）spring.factories
 *    		该文件里面有一个key叫做org.springframework.boot.autoconfigure.EnableAutoConfiguration，这个就是@EnableAutoConfiguration注解的全限定名，value是需要被spb加载的配置类（即被@Configuration标注的类）。
 *    		spb会读取所有jar包的这个文件的这个key的所有value值，并装配成bean加载到ioc容器中，从而再根据每一个配置类里面的@Bean注解加载相应的bean。
 *    （2）spring-autoconfigure-metadata.properties
 *    		spb自带的spring-boot-autoconfigure-2.3.5.RELEASE.jar里面的spring.factories里面预先配置了好多配置类，有redis的，有kafka的等，那如果工程没有用到redis或者kafka，也没有引入相关依赖，那么Spring加载这些bean的时候岂不是会报错？
 *    		这个时候spring-autoconfigure-metadata.properties就起了作用，该文件的作用就相当于是spring.factories里面加载的类的加载条件，符合条件的才会加载，也就是说spring-autoconfigure-metadata.properties起到了对spring.factories的过滤作用。
 *    		spring-autoconfigure-metadata.properties文件的key的命名规则是：需要被加载的类的全限定名+“.”+条件（比如ConditionalOnClass）
 * 
 *
 * @author zhangzhiwang
 * @date Nov 3, 2020 10:02:50 PM
 */
@SpringBootApplication// 启动main方法后，默认情况下会扫描启动类所在包及其子包下面的注解，这一默认功能是@SpringBootApplication注解里面的@ComponentScan起的作用
/**
 * spb整合servlet的方式有两种：
 * 1、自定义servlet类，并在类声明处添加@WebServlet注解，然后在启动类加上@ServletComponentScan注解来扫描@WebServlet
 * 2、自定义servlet类，不需要在类声明处添加@WebServlet注解，然后定义一个Configuration类，用@Bean的方式返回ServletRegistrationBean，此种方法也无需在启动类添加@ServletComponentScan注解
 */
//@ServletComponentScan(basePackages = {"com.asiainfo.servlet"})// 扫描@WebServlet注解
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
		ApplicationContext applicationContext = SpringApplication.run(App.class, args);// 该方法的作用就是初始化IOC容器，通过扫描注解的方式来加载bean，并没有进行自动装配。自动装配是当扫描到@SpringBootApplication注解之后，该注解里面的@EnableAutoConfiguration起到了自动装配的作用
//		System.out.println(applicationContext);
//		Order order = applicationContext.getBean(Order.class);
//		Product product = applicationContext.getBean(Product.class);
//		System.out.println(order);
//		System.out.println(product);
		
		AutoConfigService autoConfigService = applicationContext.getBean(AutoConfigService.class);
		System.out.println(autoConfigService);
		
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
	
	@Bean
	public ServletRegistrationBean<ServletTest2> servlet2() {
		ServletRegistrationBean<ServletTest2> servletRegistrationBean = new ServletRegistrationBean<>(new ServletTest2(), "/servletTest2");
		return servletRegistrationBean;
	}
}