package com.asiainfo.p5.designPatterns.isp;

public class Bird implements IEat, IFly {// Bird类只需要实现所需要的接口即可，不要去实现不需要的接口

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("A bird can fly.");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("A bird can eat.");
	}

}
