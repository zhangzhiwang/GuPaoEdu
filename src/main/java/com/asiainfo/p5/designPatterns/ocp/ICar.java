package com.asiainfo.p5.designPatterns.ocp;

public interface ICar {
	/**
	 * 将具体的车抽象出来形成一个更高层的概念，可以是一个接口或者抽象类，
	 * 它里面有一个run方法，所有具体品牌的车都继承或者实现这个更高层的类。
	 */
	void run();
}
