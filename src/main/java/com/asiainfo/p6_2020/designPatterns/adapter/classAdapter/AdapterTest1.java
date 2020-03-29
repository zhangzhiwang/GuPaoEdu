package com.asiainfo.p6_2020.designPatterns.adapter.classAdapter;

/**
 * 适配器模式写法1——类适配器</p>
 * 适配器模式就是将现有接口的输出做一些改造来适应新需求</p>
 * 适配器模式有三个角色：</p>
 * 1、目标角色</p>
 * 2、源角色</p>
 * 3、适配器角色</p>
 *
 * @author zhangzhiwang
 * @date Mar 24, 2020 12:55:53 PM
 */
public class AdapterTest1 {
	public static void main(String[] args) {
		// 需求：我现在有一个提供220V的电源，但是客户只需要22V的电压。
		// 这个场景代表了适配器模式的典型应用场景：本来能提供A功能的服务，但是需求要实现B功能，而且这个B功能和A功能很相似，完全开发一个B功能感觉有点小题大做，这个时候适配器模式就派上用场了。
		_22V _22v = new Adapter();// 多态
		System.out.println(_22v.output22V());
		
		System.out.println("--------------");
		// 类适配器有一个缺点，就是如果调用方不是用的多态，就会给客户端暴露源角色的方法，因为适配器继承了源角色类，所以可以访问源角色的方法
		Adapter _22v2 = new Adapter();// 多态
		System.out.println(_22v2.output220V());// 向客户端暴露了output220V的方法
		
		/**
		 * 类适配器又一个缺点就是想客户端暴露了源角色的方法，为了解决这个问题就出现了对象适配器
		 */
	}
}
