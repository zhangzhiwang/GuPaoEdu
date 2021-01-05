package com.asiainfo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	private int id;
	private String name;
	private int age;
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
}
