package com.asiainfo.p5.designPatterns.ocp;

/**
 * 开闭原则OCP（Open Close Principle）：对扩展开放，对修改关闭
 *
 * @author zhangzhiwang
 * @date Feb 18, 2020 8:02:13 PM
 */
public class OCP {
//	public static void main(String[] args) {
//		// 原始需求：张三开宝马
//		ICar car = null;
//		car = new BMW();
//		getACarRun(car);
//		
//		// 需求变更1：张三换车了，换成了奔驰。
//		// 用扩展而不是修改来适应需求的变化，如果不用开闭原则，那么就必须修改BMW类，将BMW改成Benz；如果使用开闭原则就新增一个类Benz是原来的BMW保持不变，这样调用方也不需要改代码
//		car = new Benz();
//		getACarRun(car);
//		
//		// 需求变化2:张三换的这量奔驰用了两年之后，自己打算改装它，于是装了个翅膀点一个按钮就可以飞了。如果不使用OCP，那么必须修改原有的类Benz，在类里面添加方法fly；如果使用OCP，那么要新建一个类出来继承Benz，在子类里面定义一个fly方法
//		BenzExt car2 = new BenzExt();
//		car2.fly();
//	}
//	public static void getACarRun(ICar car) {
//		car.run();
//	}
	
	private static ICar car;
	
	static {
		// 模拟Spring注入ICar实例，需要不同品牌的车就注入不同品牌的实例即可
		car = new Benz();
	}
	
	public static void main(String[] args) {
		Person person = new Person(car);
		person.drive();
	}
}
