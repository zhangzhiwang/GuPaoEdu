package com.asiainfo.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * 自定义工作监听器
 *
 * @author zhangzhiwang
 * @date 2021年3月8日 下午2:17:30
 */
public class MyJobListener implements JobListener {

	/**
	 * 获取本监听器的名称
	 */
	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}

	/**
	 * job即将被执行的时候调用本方法
	 */
	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		String jobName = context.getJobDetail().getJobClass().getSimpleName();
		System.out.println(jobName + "即将被执行...");
	}

	/**
	 * job执行被取消的时候执行本方法
	 */
	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
		String jobName = context.getJobDetail().getJobClass().getSimpleName();
		System.out.println(jobName + "被取消");
	}

	/**
	 * job执行完之后执行此方法
	 */
	@Override
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
		String jobName = context.getJobDetail().getJobClass().getSimpleName();
		System.out.println(jobName + "执行完成！");
	}
}
