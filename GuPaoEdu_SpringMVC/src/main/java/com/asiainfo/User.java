package com.asiainfo;

import java.util.Arrays;
import java.util.List;

public class User {
	private String name;
	private int age;
	private String[] hobbies;
	private List<String> addresses;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public List<String> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", hobbies=" + Arrays.toString(hobbies) + ", addresses="
				+ addresses + "]";
	}

}
