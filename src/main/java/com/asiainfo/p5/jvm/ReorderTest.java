package com.asiainfo.p5.jvm;

public class ReorderTest {
	public static void main(String[] args) {
		Dog d1 = Dog.d;
	}
}

class Dog {
	public static Dog d = new Dog();
	
	public Dog() {
		if(d == null) {
			System.out.println(1);
		} else {
			System.out.println(2);
		}
	}
}