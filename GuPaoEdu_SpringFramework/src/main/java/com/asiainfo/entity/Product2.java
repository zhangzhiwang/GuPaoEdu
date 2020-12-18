package com.asiainfo.entity;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
//@Component
public class Product2 {
	@Autowired
	private User2 user2;
	
	public Product2() {
		System.out.println("Product2无参构造器");
	}
	
	/**
	 * 构造函数、注入对象和@PostConstruct方法执行顺序：
	 * 1、在初始化一个类对象时，先执行该类的构造方法
	 * 2、如果该类有被@Autowired修饰的属性，那么会初始化该属性的对象然后注入进来
	 * 3、最后执行被@PostConstruct修饰的方法
	 */
	@PostConstruct
	public void met1() {
		System.out.println("Product2的PostConstruct执行，user2 = " + user2);
	}
}
