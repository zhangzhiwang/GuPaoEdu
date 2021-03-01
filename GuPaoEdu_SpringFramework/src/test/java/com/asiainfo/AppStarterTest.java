package com.asiainfo;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Proxy;

import javax.annotation.PreDestroy;

//import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.asiainfo.controller.UserController;
import com.asiainfo.entity.DBInfo;
import com.asiainfo.entity.Product;
import com.asiainfo.entity.Product4;
import com.asiainfo.entity.Product5;
import com.asiainfo.entity.User3;
import com.asiainfo.proxy.jdkProxy.JdkProxyInvocationHandler;
import com.asiainfo.proxy.staticProxy.JayChou;
import com.asiainfo.proxy.staticProxy.StaticProxy;
import com.asiainfo.proxy.staticProxy.VocalConcert;
import com.asiainfo.service.impl.UserServiceImpl;

public class AppStarterTest {
	/**
	 * 不使用Spring的原始方式获取对象——自力更生
	 * 
	 * @author zhangzhiwang
	 * @date Dec 15, 2020 11:37:37 AM
	 */
//	@Test
//    public void testOriginalWithoutSpring() {
//    	User user = new User("zhangsan", 18);
//    	System.out.println(user);
//    }
	
	/**
	 * 使用Spring原始的方式获取bean
	 * 
	 * @author zhangzhiwang
	 * @date Dec 15, 2020 11:54:29 AM
	 */
//	@Test
//	public void testSpringOriginal() {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
////		Object bean = applicationContext.getBean("user3");// User要有无参构造器。通过name来获取bean，这个name可以和xml中<bean>标签的id属性相同，也可以跟name属性相同，即通过<bean>标签的id和neme都能获取到bean对象
////		System.out.println(bean);
//		
//		// <bean>标签的id属性和name属性的区别：加入id的是一个整体哪怕其中有逗号，name可以有多个，每个名称可以用“,”、“;”和“ ”（空格）分割。id相当于身份证，name可以起多个别名。
////		Object bean = applicationContext.getBean("user1,user2,user3");// 通过id获取，“user1,user2,user3”是一个整体不可分割
////		Object bean = applicationContext.getBean("u1");// 通过name获取，“u1,u2,u3”不是一个整体，不能用整体来获取bean，必须用单个name来获取
////		System.out.println(bean);
//		
//		// 通过class来获取，默认情况下如果容器中有相同类型的bean，获取时会报错
////		Object bean = applicationContext.getBean(User.class);
////		System.out.println(bean);
//		// 解决方法有两种：
//		// 1、通过名称和类型来获取
////		Object bean = applicationContext.getBean("u1", User.class);
////		System.out.println(bean);
//		
//		// 2、在bean定义的时候加上primary="true"属性，代表如果出现相同类型的bean，标识为primary="true"的bean优先被获取
//		Object bean = applicationContext.getBean(User.class);
//		System.out.println(bean);
//	}
	
//	@Test
//	public void testBeanFactory() {
//		/**
//		 * 面试题：BeanFactory和ApplicationContext的区别。
//		 * 1、从类结构上来看，ApplicationContext是BeanFactory的子接口，ApplicationContext间接继承了BeanFactory接口。既然是子接口，那么BeanFactory有的功能ApplicationContext全有。
//		 * 同时ApplicationContext还继承了其他接口，比如消息通知接口和事件发布接口等，所以ApplicationContext的功能比BeanFactory丰富。
//		 * 2、ApplicationContext会在ioc容器初始化的时候实例化所有对象（当然是已经在xml里面配置的或者其它标识为bean的情况），而BeanFactory是在使用的时候实例化用到的对象，用到什么实例化什么。
//		 */
//		
//		// 验证上面第2点
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");// 在ioc容器初始化的时候实例化所有在xml里面配置的bean
//		
////		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
////		beanFactory.getBean("product");
//	}
	
	/**
	 * 通过静态工程或动态工厂注入
	 */
//	@Test
//	public void testFactory() {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		Object bean = applicationContext.getBean("userDynamic");
//		System.out.println(bean);
//	}
	
	/**
	 * 属性注入
	 */
//	@Test
//	public void testFieldInjection() {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		Object bean = applicationContext.getBean("user7");
//		System.out.println(bean);
//	}
	
	/**
	 * Java配置类
	 */
//	@Test
//	public void testJavaConfig() {
//		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigTest.class);
//		Object bean = applicationContext.getBean("user8");
//		System.out.println(bean);
//	}
	
	/**
	 * 测试使用xml/Java config的方式配置mvc的三层
	 * @throws IOException 
	 */
//	@Test
//	public void testController() {
////		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigTest.class);
//		UserController userController = (UserController) applicationContext.getBean("userController");
//		User user = userController.queryUser();
//		System.out.println(user);
//	}
	
//	@Test
//	public void testAnnotation() throws IOException {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
////		UserController userController = (UserController) applicationContext.getBean("userController");
////		User user = userController.queryUser();
////		System.out.println(user);
//		
////		UserController userController = (UserController) applicationContext.getBean("userController");
////		User user = (User) applicationContext.getBean("u1");
////		System.out.println(user);
////		User user = userController.queryUser();
////		System.out.println(user);
//		
////		Product product = (Product) applicationContext.getBean("product");
////		System.out.println(product);
////		Resource resource = product.getFileResource();
////		String filename = resource.getFilename();
////		System.out.println("filename = " + filename);
////		InputStream inputStream = resource.getInputStream();
////		byte[] bs = new byte[128];
////		int i = 0;
////		StringBuilder stringBuilder=new StringBuilder();
////		while((i = inputStream.read(bs, 0, bs.length)) != -1) {
////			stringBuilder.append(new String(bs));
////		}
////		System.out.println(stringBuilder.toString());
//		
////		System.out.println("spring上下文初始化完成！");
////		applicationContext.getBean("product");
////		applicationContext.getBean("u1");
//		
////		applicationContext.getBean("product2");
////		((ClassPathXmlApplicationContext)applicationContext).close();// 测试被@PreDestroy标注的方法
//	}
	
//	@Test
//	public void testImport() {
//		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigTest.class);
//		Object bean = applicationContext.getBean("product4");
////		applicationContext.getBean("p5");
//		System.out.println(bean);
//	}
	
//	@Test
//	public void testProfile() {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//		context.register(ConfigTest.class);
//		context.getEnvironment().setActiveProfiles("prod");
//		context.refresh();
//		
//		DBInfo bean = context.getBean(DBInfo.class);
//		System.out.println(bean);
//	}
	
//	@Test
//	public void testScope() {
//		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigTest.class);
//		Object bean1 = context.getBean("product4");
//		System.out.println(bean1);
//		Object bean2 = context.getBean("product4");
//		System.out.println(bean2);
//		Object bean3 = context.getBean("product4");
//		System.out.println(bean3);
//	}
	
	/**
	 * IOC原理
	 */
//	@Test
//	public void testTheory() {
//		/**
//		 * 每一个bean定义（标签也好，注解也好）在内存中都以BeanDefination对象的形式存在，所有的BeanDefination最终都会注册到Map<String, BeanDefination>里面
//		 */
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");// 这行代码是分析原理的入口，它的作用就是加载配置文件并解析配置文件到内存中从而完成ioc容器的初始化
//		context.getBean(Product.class);
//	}
	
//	@Test
//	public void testStaticProxy() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		StaticProxy staticProxy = context.getBean(StaticProxy.class);
//		staticProxy.sing();
//		System.out.println("----------------");
//		String result = staticProxy.dance(10086);
//		System.out.println("result =" + result);
//	}
	
//	@Test
	public void testJdkProxy() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		VocalConcert proxyInstance = (VocalConcert) Proxy.newProxyInstance(JayChou.class.getClassLoader(),// 目标对象的类加载器
				JayChou.class.getInterfaces(),// 弥补对象实现的接口
				new JdkProxyInvocationHandler(new JayChou()));// InvocationHandler的实现类
		
		System.out.println("proxyInstance = " + proxyInstance);
		proxyInstance.sing();
		System.out.println("------------");
		String result = proxyInstance.dance(10086);
		System.out.println("result =" + result);
	}
}