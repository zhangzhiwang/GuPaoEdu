package com.asiainfo.p6.softwareFrameworkDesignPrinciple.isp;

/**
 * 狗
 *
 * @author zhangzhiwang
 * @date Oct 21, 2019 1:49:14 PM
 */
public class Dog implements IAnimal {

	@Override
	public void eat() {
		System.out.println("dog eats");
		
	}

	@Override
	public void fly() {
		// 这里只能空着，Dog类依赖了它不需要的接口fly()
		
	}

	@Override
	public void swim() {
		System.out.println("dog swims");
		
	}
	
}
