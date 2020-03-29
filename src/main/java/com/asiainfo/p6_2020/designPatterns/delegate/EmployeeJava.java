package com.asiainfo.p6_2020.designPatterns.delegate;

/**
 * 后端Java程序员
 *
 * @author zhangzhiwang
 * @date Mar 26, 2020 10:35:56 AM
 */
public class EmployeeJava implements IEmployee {

	@Override
	public void doTask(String task) {
		System.out.println("我是后端Java程序员，我要完成的任务是：" + task);
	}

}
