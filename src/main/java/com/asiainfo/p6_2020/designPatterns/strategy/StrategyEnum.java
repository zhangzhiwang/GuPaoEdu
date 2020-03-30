package com.asiainfo.p6_2020.designPatterns.strategy;

/**
 * 支付策略枚举
 *
 * @author zhangzhiwang
 * @date Mar 30, 2020 7:25:29 PM
 */
public enum StrategyEnum {
	ALI_PAY(0, "支付宝"),
	WECHAT_PAY(1, "微信支付"),
	UNION_PAY(2, "银联支付"),
	CASH_PAY_DEFAULT(3, "现金支付（默认支付方式）")
	;

	private int index;
	private String name;

	private StrategyEnum() {
	}

	private StrategyEnum(int index, String name) {
		this.index = index;
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
