package com.asiainfo.p6_2020.designPatterns.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目经理
 *
 * @author zhangzhiwang
 * @date Mar 26, 2020 10:37:32 AM
 */
public class TeamLeader implements IEmployee {
	private Map<String, IEmployee> empMap = new HashMap<String, IEmployee>();
	
	{
		// 在老板分配任务前，team leader要知道手底下有多少人，每个人擅长什么
		empMap.put("webPage", new EmployeeWebPage());
		empMap.put("java", new EmployeeJava());
	}
	
	@Override
	public void doTask(String task) {// 项目经理自己不做任务，将不同的任务交给下面合适的人做
		if(empMap.get(task) == null) {
			throw new RuntimeException("无法胜任此任务：" + task);
		}
	
		empMap.get(task).doTask(task);
	}
}
