package com.asiainfo;

import java.util.Arrays;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class User {
	@NotBlank(message = "姓名不能为空！")
	@Length(message = "{valid.name}", min = 3, max = 10, groups = {ValidateGroup1.class})
	private String name;
	@Min(message = "年龄必须大于18岁", value = 18, groups = {ValidateGroup1.class, ValidateGroup2.class})
	@Max(message = "年龄必须小于30岁", value = 30, groups = {ValidateGroup2.class})
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
