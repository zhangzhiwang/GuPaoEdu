package com.asiainfo.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.annotation.Lazy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor
public class User3 {
	private String name;
	private int age;
	private Product product;
	private String[] hobbies;
	private List<Product> products;
	private Map<String, String> myMap;
	private Properties properties;
	private String nameTest = "张三";
	
	public User3(String name, int age) {
		System.out.println("user有参构造器");
		this.name = name;
		this.age = age;
	}
	
	public User3() {
		System.out.println("user无参构造器");
	}
}
