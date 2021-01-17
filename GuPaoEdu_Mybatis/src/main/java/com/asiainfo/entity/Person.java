package com.asiainfo.entity;

import lombok.Data;

@Data
public class Person {
	private int personId;
	private String name;
	private int age;
	private IdCard idCard;
}
