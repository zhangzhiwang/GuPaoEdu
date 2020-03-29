package com.asiainfo.p6_2020.designPatterns.delegate;

/**
 * 老板——模拟客户端
 *
 * @author zhangzhiwang
 * @date Mar 26, 2020 10:42:24 AM
 */
public class Boss {
	/**
	 * 给某个项目经理下达研发任务
	 * 
	 * @param task
	 * @param teamLeader
	 * @author zhangzhiwang
	 * @date Mar 26, 2020 10:43:53 AM
	 */
	public void command(String task, TeamLeader teamLeader) {
		teamLeader.doTask(task);
	}
}
