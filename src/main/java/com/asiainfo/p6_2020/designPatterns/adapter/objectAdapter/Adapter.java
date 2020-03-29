package com.asiainfo.p6_2020.designPatterns.adapter.objectAdapter;

/**
 * 对象适配器</p>
 * 类适配器是继承源角色，而对象适配器是组合源角色。继承源角色会暴露源角色的方法，而组合会屏蔽源角色的方法。
 *
 * @author zhangzhiwang
 * @date Mar 24, 2020 1:12:01 PM
 */
public class Adapter implements _22V {
	private _220V _220v;
	
	{
		_220v = new _220V();// 模拟Spring注入
	}

	@Override
	public int output22V() {
		int output220v = _220v.output220V();
		return output220v / 10;
	}
}
