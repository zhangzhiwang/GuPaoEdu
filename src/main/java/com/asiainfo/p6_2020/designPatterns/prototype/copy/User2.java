package com.asiainfo.p6_2020.designPatterns.prototype.copy;

import java.io.Serializable;

public class User2 implements Serializable {
	private int age;
	private String name;
	private IdentityCard2 id;

	public User2(int age, String name, IdentityCard2 id) {
		super();
		this.age = age;
		this.name = name;
		this.id = id;
	}

	public User2() {
		super();
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IdentityCard2 getId() {
		return id;
	}

	public void setId(IdentityCard2 id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + ", id=" + id + "]";
	}

}
