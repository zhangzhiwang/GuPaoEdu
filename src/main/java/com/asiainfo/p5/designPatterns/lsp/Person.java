package com.asiainfo.p5.designPatterns.lsp;

public class Person {
	public void wannafly(Bird bird) {
		String s = bird.fly();
		System.out.println("我骑着一只鸟" + s);
	}
	
	public static void main(String[] args) {
		Person person = new Person();
		// 原使用父类对象实现到天上飞的需求
		Bird bird = new Bird();
		person.wannafly(bird);
		
		// 将父类替换成子类
		bird = new Penguin();
		person.wannafly(bird);// 程序原本是到天上飞，结果替换成子类之后就钻到水里把人淹死了
	}
}

class Bird {
	public String fly() {
		return "到天上飞";
	}
}

class Penguin extends Bird {// 企鹅也是鸟
	@Override
	public String fly() {// 企鹅不会飞，实现者借用fly方法实现了到水里游的功能
		return "到水里游";
	}
}