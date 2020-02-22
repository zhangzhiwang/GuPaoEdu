package com.asiainfo.p5.designPatterns.dip;

/**
 * 依赖倒置原则DIP（Dependence Inversion Principle）：高层模块不直接依赖于底层模块，高层模块和底层模块都依赖于底层模块的抽象；抽象不依赖于细节，细节依赖于抽象。说白了就是只要抽象不变，调用方不随着接口提供方的变化而变化
 *
 * @author zhangzhiwang
 * @date Feb 19, 2020 7:45:58 PM
 */
public class DIP {
	private static ICourse course;
	
	static {
		course = new C();// 模拟Spring的IOC注入
	}
	
	public static void main(String[] args) {
		// 1、我们接口调用方称为高层模块，把接口的实现称为低层模块 2、依赖倒置原则的前提是抽象是不经常变动的，实现是会经常变化的，假如抽象也经常变化那么依赖抽象也没有什么意义

		// 1、在依赖倒置原则出现之前的情况：高层模块直接依赖于低层模块
		// 原始需求：学生A要学习Java
		StudentA z = new StudentA(course);
//		z.studyJava();

		// 需求变化1:学生A不想学习Java了，想学习C语言并将studyJava方法从StudentA里面移除。对底层模块的修改影响到了高层模块。
		// 在不使用DIP原则下，如果服务提供者StudentA将studyJava方法删除，那么调用方（也就是高层模块）必须跟着修改否则报错——将z.studyJava()注释掉改成下面这行：
//		z.studyC();// 这就使得高层模块和底层模块强耦合。
		
		// 2、使用DIP解决上面的问题
		z.study();
	}
}
