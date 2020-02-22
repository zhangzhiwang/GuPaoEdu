package com.asiainfo.p5.designPatterns.srp;

/**
 * 单一职责原则SRP（Simple Responsibility Principle）
 *
 * @author zhangzhiwang
 * @date Feb 19, 2020 8:39:40 PM
 */
public class SRP {
	public static void main(String[] args) {
		/**
		 * 单一职责原则就不用写代码来说明了。就是说一个类或者一个方法只干一件事，这样既有利于维护，也使代码的可读性增强。</p>
		 * 举个实际的例子：一个insertUser()方法再插入数据库User表之后还要更新日志表，那么在insertUser方法里面去updateLog就不合适了，因为它干了两件事。</p>
		 * 可以在上层再定义一个方法去调用insert方法和updateLog方法，或者在insert方法里面将更新日志表的方法逻辑抽离出一个单独的方法然后去调用它。
		 */
	}
}