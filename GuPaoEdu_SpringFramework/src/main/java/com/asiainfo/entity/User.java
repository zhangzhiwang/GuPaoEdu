package com.asiainfo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor
public class User {
	private String name;
	private int age;
	
	public User() {
		System.out.println("user无参构造器");
	}
}
