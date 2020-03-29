package com.asiainfo.p6_2020.designPatterns.delegate;

/**
 * 前端程序员
 *
 * @author zhangzhiwang
 * @date Mar 26, 2020 10:34:42 AM
 */
public class EmployeeWebPage implements IEmployee {

	@Override
	public void doTask(String task) {
		System.out.println("我是前端程序员，我要做的工作是：" + task);
	}

}
