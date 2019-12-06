package com.asiainfo.p6.softwareFrameworkDesignPrinciple.isp;

/**
 * 狗
 *
 * @author zhangzhiwang
 * @date Oct 21, 2019 1:49:14 PM
 */
public class Dog2 implements EatAnimal, SwimAnimal {

	@Override
	public void eat() {
		System.out.println("dog eats");
		
	}

//	@Override
//	public void fly() {// 这样Dog类就不需要依赖fly()方法了
//	}

	@Override
	public void swim() {
		System.out.println("dog swims");
		
	}
	
}
