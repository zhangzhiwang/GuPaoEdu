package com.asiainfo.p6_2020.designPatterns.adapter.homework;

/**
 * 用户实体类
 *
 * @author zhangzhiwang
 * @date Mar 25, 2020 10:42:12 AM
 */
public class User {
	private String name;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}
}
