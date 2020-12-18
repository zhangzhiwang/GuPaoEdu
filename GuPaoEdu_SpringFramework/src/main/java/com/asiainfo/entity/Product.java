package com.asiainfo.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import lombok.Data;

@Data
public class Product {
//	private int productId;
//	private String productName;
//	
//	@Value("0001")// 值是写死的，相当于直接在属性后面赋值：private String code = "0001";
//	private String code;
//	
//	@Value("#{systemProperties['os.name']}")// 获取操作系统信息
//	private String systemProperty;
//	
//	@Value("#{T(java.lang.Math).random()}")// 调用静态方法并将其返回值进行注入，这个方法可以是jdk自带的也可以是自定义的静态方法
//	private double randomNum;
//	
//	@Value("#{T(com.asiainfo.util.CommonUtil).getNum()}")// 注入自定义静态方法的返回值
//	private double myNum;
//	
////	@Value("#{u1.nameTest}")// 注入其它bean的属性，“u1”是bean的名称
//	private String userName;
//	
//	@Value("classpath:test.txt")// 注入配置文件，将指定配置文件加载到Resource中
//	private Resource fileResource;
//	
//	@Value("http://www.baodu.com")// 注入url，将请求地址的结果注入到Resource中
//	private Resource baidu;
//	
//	@Value("${db.url}")// 读取置文件中的配置，需要在配置类加@PropertySource注解并指定读取哪个配置文件
//	private String url;
//	
//	@Value("${db.username}")
//	private String dbUserName;
//	
//	@Value("${db.password}")
//	private String password;
	
	public Product() {
		System.out.println("Product无参构造器");
	}
}
