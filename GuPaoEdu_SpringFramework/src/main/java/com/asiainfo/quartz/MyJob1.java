package com.asiainfo.quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob1 implements Job {

	/**
	 * 该方法在本任务被调度的时候执行
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
//		System.out.println("jobExecutionContext = " + context);
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		for(String key : jobDataMap.keySet()) {
			System.out.println(key + " : " + jobDataMap.getString(key));
		}
	}
}
