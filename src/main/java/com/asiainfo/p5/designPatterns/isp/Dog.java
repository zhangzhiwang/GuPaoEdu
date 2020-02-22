package com.asiainfo.p5.designPatterns.isp;

public class Dog implements IEat, ISwim {// Dog类只需要实现所需要的接口即可，不要去实现不需要的接口

	@Override
	public void swim() {
		// TODO Auto-generated method stub
		System.out.println("A dog can swim.");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("A dog can eat.");
	}

}
