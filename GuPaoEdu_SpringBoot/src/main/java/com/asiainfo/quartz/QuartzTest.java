package com.asiainfo.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzTest {
	public static void main(String[] args) throws SchedulerException {
		// 创建Job，Job用来描述任务
		JobDetail jobDetail = JobBuilder.newJob(MyJob.class).build();
		
		// 创建Trigger，Trigger用来描述什么时候去执行任务
		Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?")).build();
		
		// 创建Scheduler，Scheduler用来建立Job和Trigger的关系，将二者进行绑定
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.scheduleJob(jobDetail, trigger);
		scheduler.start();
	}
}
