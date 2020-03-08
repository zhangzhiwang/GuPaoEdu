package com.asiainfo.p6_2020.designPatterns.decorator;

/**
 * 房子的标准配置
 *
 * @author zhangzhiwang
 * @date Mar 5, 2020 3:16:08 PM
 */
public class StandardHouse implements House {
	public String desc() {
		return "（房子的标配：地板砖、桌子、床）";
	};
	
	public int price() {
		return 100;
	};
}
