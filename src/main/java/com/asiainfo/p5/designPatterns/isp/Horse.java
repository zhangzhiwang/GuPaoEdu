package com.asiainfo.p5.designPatterns.isp;

public class Horse implements IEat, IRun {
	// Horse类只需要实现所需要的接口即可，不要去实现不需要的接口
	@Override
	public void eat() {
		System.out.println("马会吃草");
	}

	@Override
	public void runOnTheGround() {
		System.out.println("马在陆地上奔跑");
	}

}
