package com.asiainfo.entity;

import java.util.List;

import lombok.Data;

@Data
public class Person {
	private int personId;
	private String name;
	private int age;
	/** 一对一 */
	private IdCard idCard;
	/** 一对多 */
	private List<Car> carList;
}
