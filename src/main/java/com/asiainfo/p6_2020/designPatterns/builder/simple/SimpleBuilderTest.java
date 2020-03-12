package com.asiainfo.p6_2020.designPatterns.builder.simple;

import com.asiainfo.p6_2020.designPatterns.builder.simple.Benz_E2.Benz_E2_Builder;

/**
 * 建造者模式（精简版）
 *
 * @author zhangzhiwang
 * @date Mar 12, 2020 5:34:22 PM
 */
public class SimpleBuilderTest {
	public static void main(String[] args) {
		Benz_E2_Builder benz_E2_Builder = new Benz_E2_Builder("真皮座椅", "轮胎");
		benz_E2_Builder.addBerlin("berlin").addSunroof("Sunroof").addCeiling("Ceiling").addTv("tv");// 采用链式编程的方式比调用普通的set方法代码更优雅，可读性更高，客户端也不用关心调用顺序
		Benz_E2 benz_E2 = benz_E2_Builder.assembleBenz_E2();
		System.out.println(benz_E2.toString());
		
		/**
		 * 本实现是一个简单版：只有一个构建者，所以没必要弄一个抽象抽象构建者和指挥者的角色，将构建者实现类的角色放到产品中以静态内部类的形式存在，构建顺序的控制放到产品构造器中实现。standard包下面是标准版的构造器模式。
		 */
	}
}
