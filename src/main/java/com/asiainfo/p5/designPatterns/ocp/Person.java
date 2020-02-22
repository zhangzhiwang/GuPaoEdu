package com.asiainfo.p5.designPatterns.ocp;

/**
 * 
 *
 * @author 张三
 * @date Feb 20, 2020 3:10:52 PM
 */
public class Person {
	private ICar car;

	public Person(ICar car) {
		super();
		this.car = car;
	}

	public void drive() {
		car.run();
	}
}
