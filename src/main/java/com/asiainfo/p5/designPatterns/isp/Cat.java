package com.asiainfo.p5.designPatterns.isp;

public class Cat implements IAnimal {

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("Cat eat...");
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("???");// 猫实现fly方法明显没有什么意义，也就是说猫类依赖了他不需要的接口方法
	}

	@Override
	public void swim() {
		// TODO Auto-generated method stub
		System.out.println("Cat swim...");
	}

	@Override
	public void runOnTheGround() {
		// TODO Auto-generated method stub
		
	}

}
