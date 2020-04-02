package com.asiainfo.p6_2020.designPatterns.chainOfResponsibility;

/**
 * 登录用户实体类
 *
 * @author zhangzhiwang
 * @date Apr 2, 2020 1:51:11 PM
 */
public class User {
	private String name;
	private String password;
	private String role;

	public User() {
		super();
	}

	public User(String name, String password, String role) {
		super();
		this.name = name;
		this.password = password;
		this.role = role;
	}

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", role=" + role + "]";
	}

}
