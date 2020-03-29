package com.asiainfo.p6_2020.designPatterns.adapter.objectAdapter;

/**
 * 适配器模式写法2——对象适配器
 *
 * @author zhangzhiwang
 * @date Mar 24, 2020 1:26:11 PM
 */
public class AdapterTest2 {
	public static void main(String[] args) {
//		_22V adapter = new Adapter(new _220V());
		Adapter adapter = new Adapter();// 无论是否用多态，适配器对象都调用不到源角色的方法
		System.out.println(adapter.output22V());
	}
}
