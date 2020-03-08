package com.asiainfo.p6_2020.designPatterns.prototype.copy;

public class User implements Cloneable {
	private int age;
	private String name;
	private IdentityCard id;

	public User(int age, String name, IdentityCard id) {
		super();
		this.age = age;
		this.name = name;
		this.id = id;
		System.out.println("调用有参构造方法");
	}
	
	public User() {
		System.out.println("调用无参构造方法");
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

	public IdentityCard getId() {
		return id;
	}

	public void setId(IdentityCard id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + ", id=" + id + "]";
	}

	@Override
	public User clone() {
		try {
			User newUser = (User) super.clone();
			IdentityCard newId = newUser.getId().clone();
			newUser.setId(newId);
			
			return newUser;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
