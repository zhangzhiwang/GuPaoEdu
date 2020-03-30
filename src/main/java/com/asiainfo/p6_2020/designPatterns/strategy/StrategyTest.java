package com.asiainfo.p6_2020.designPatterns.strategy;

/**
 * 策略模式</p>
 * 策略模式和委派模式的区别就是前者是由客户端选择策略，客户端要知道所有的策略然后选择一个；后者是“策略者角色”选择策略，客户端根本就不知道具体有哪些策略</p>
 * 策略模式的角色：</p>
 * 1、抽象策略角色</p>
 * 2、具体策略角色</p>
 * 3、上下文角色（静态代理，接收客户端的选择并转向客户端选择的策略）
 *
 * @author zhangzhiwang
 * @date Mar 30, 2020 6:59:55 PM
 */
public class StrategyTest {
	public static void main(String[] args) {
		/**
		 *  其实策略模式完全可以使用委派模式的例子：boss给leader下达指令，leader收到指令后决定将该任务分给哪个手下来执行。</p>
		 *  而在策略模式中，boss在给leader下达指令的同时就指定某个人来完成该任务了，即策略（具体干活的人）是由boss来选择的。
		 */
		
		Context context = new Context();
		context.pay(StrategyEnum.ALI_PAY);// 策略是客户端选择的
	}
}
