package com.asiainfo.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
public class User2 {
	private String name;
	private int age;
	
	public User2(String name, int age) {
		System.out.println("user2有参构造器");
		this.name = name;
		this.age = age;
	}
	
	public User2() {
		System.out.println("user2无参构造器");
	}
}
