package com.asiainfo.p5.designPatterns.lod;

import java.util.ArrayList;
import java.util.List;

// 需求：开班会之前老师让班长去买水果，然后把买的是什么水果告诉她
// 不使用迪米特法则
//public class LoDTest {
//	public static void main(String[] args) {
//		Fruit fruit = new Fruit();
//		fruit.setName("西瓜");
//		Teacher t = new Teacher();
//		Student s = new Student();
//		String result = t.command(s, fruit);
//		System.out.println(result);
//	}
//}
//
//class Fruit {
//	private String name;
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//}
//
//class Student {
//	public String buyFruit(Fruit fruit) {
//		String name = fruit.getName();
//		return name;
//	}
//}
//
//class Teacher {
//	public String command(Student s, Fruit fruit) {
//		return s.buyFruit(fruit);
//	}
//}

// 使用迪米特法则
public class LoDTest {
	public static void main(String[] args) {
		Teacher t = new Teacher();
		Student s = new Student();
		String result = t.command(s);
		System.out.println(result);
	}
}

class Fruit {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

class Student {
	public String buyFruit() {
		Fruit fruit = new Fruit();
		fruit.setName("西瓜");// 模拟从数据库查出一个Fruit实例
		
		String name = fruit.getName();
		return name;
	}
}

class Teacher {
	public String command(Student s) {
		return s.buyFruit();
	}
}