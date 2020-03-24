package com.asiainfo.p6_2020.designPatterns.adapter.classAdapter;

/**
 * 模拟适配器角色——将源角色提供的功能转换成目标角色所需要的功能
 *
 * @author zhangzhiwang
 * @date Mar 24, 2020 1:12:01 PM
 */
public class Adapter extends _220V implements _22V {// 这里要注意：在类适配器中适配器类一定要继承源角色类实现目标角色类，不能弄反了，想一想为什么？
	@Override
	public int output22V() {
		int output220v = super.output220V();// 适配器一定是先调用源角色类的方法后在返回结果的基础上做一些适配工作以适应目标类的要求，所以必须继承源角色类实现目标角色类
		return output220v / 10;
	}

}
