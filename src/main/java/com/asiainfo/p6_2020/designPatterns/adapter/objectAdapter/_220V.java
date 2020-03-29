package com.asiainfo.p6_2020.designPatterns.adapter.objectAdapter;

/**
 * 模拟源角色——提供220V的输出电压
 *
 * @author zhangzhiwang
 * @date Mar 24, 2020 1:09:09 PM
 */
public class _220V {
	public int output220V() {
		System.out.println("输出220V电压");
		return 220;
	}
}
