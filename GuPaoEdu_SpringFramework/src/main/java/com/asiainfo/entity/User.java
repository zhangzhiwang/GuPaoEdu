package com.asiainfo.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor
public class User {
	private String name;
	private int age;
	private Product product;
	private String[] hobbies;
	private List<Product> products;
	private Map<String, String> myMap;
	private Properties properties;
	
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public User() {
		System.out.println("user无参构造器");
	}
}
