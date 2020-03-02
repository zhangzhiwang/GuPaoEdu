package com.asiainfo.p6_2020.designPatterns.singleton.hungry;

public class HungrySingletonTest {
	public static void main(String[] args) {
		HungrySingleton1 instance1 = HungrySingleton1.getInstance();
		HungrySingleton1 instance2 = HungrySingleton1.getInstance();
		System.out.println(instance1 == instance2);
	}
}
