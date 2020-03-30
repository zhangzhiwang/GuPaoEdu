package com.asiainfo.p6_2020.designPatterns.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文角色
 *
 * @author zhangzhiwang
 * @date Mar 30, 2020 7:23:57 PM
 */
public class Context {
	private static final Map<StrategyEnum, IStrategy> CONTAINER = new HashMap<StrategyEnum, IStrategy>();
	
	static {
		CONTAINER.put(StrategyEnum.ALI_PAY, new AliPay());
		CONTAINER.put(StrategyEnum.WECHAT_PAY, new WeChatPay());
		CONTAINER.put(StrategyEnum.UNION_PAY, new UnionPay());
		CONTAINER.put(StrategyEnum.CASH_PAY_DEFAULT, new CashPay());
	}
	
	public void pay(StrategyEnum strategyEnum) {
		if(CONTAINER.get(strategyEnum) == null) {
			System.out.println("没有制定的支付方式，将选择默认支付方式——现金支付");
			CONTAINER.get(StrategyEnum.CASH_PAY_DEFAULT).pay();
			return;
		}
		
		CONTAINER.get(strategyEnum).pay();
	}
	

}
