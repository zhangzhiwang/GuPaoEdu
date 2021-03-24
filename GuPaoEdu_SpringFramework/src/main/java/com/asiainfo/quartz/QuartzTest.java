package com.asiainfo.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.EverythingMatcher;
import org.quartz.impl.matchers.KeyMatcher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Quartz是一个任务调度框架，主要有两个部分：任务（要做什么）和调度（什么时候去做）
 *
 * @author zhangzhiwang
 * @date 2021年3月5日 下午5:54:18
 */
public class QuartzTest {
	public static void main(String[] args) throws Exception {
//		// ******单独使用quartz*********
//		/**
//		 *  Quartz框架的主要组件就三个：
//		 *  1、任务（Job）：负责处理具体的任务
//		 *  2、触发器（Trigger）：什么时间执行任务或者执行任务的时间规律是什么
//		 *  3、调度器（Scheduler）：建立任务和触发器的关联。注意：负责任务什么时候来执行的是触发器而不是调度器。
//		 */
//		// 1、创建触发器
//		Trigger trigger = TriggerBuilder.newTrigger()
//				.withIdentity("trigger1", "triggerGroup1")// 给trigger命名并指配一个分组
//				.withSchedule(SimpleScheduleBuilder.simpleSchedule()// 创建一个简单的调度器
////						.withIntervalInSeconds(1)// 每隔一秒执行一次
//						.repeatSecondlyForever())
//				.build();
//		
//		// 2、创建JobDetail
//		JobDetail jobDetail = JobBuilder.newJob(MyJob1.class)
//				.withIdentity("jobDetail1", "jobDetaiGroup1")
//				.usingJobData("key1", "value1")
//				.usingJobData("key2", "value2")
//				.build();
//		
//		// 3、创建SchedulerFactory
//		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
//		
//		// 4、通过SchedulerFactory创建Scheduler
//		Scheduler scheduler = schedulerFactory.getScheduler();
//		
//		// 5、绑定job和trigger，通过scheduler建立Trigger和JobDetail的关联
//		scheduler.scheduleJob(jobDetail, trigger);// jobDetail和trigger的关系是1:n的关系，即一个job可以被多个触发器触发
//		
////		scheduler.getListenerManager().addJobListener(new MyJobListener(), EverythingMatcher.allJobs());// 注册监听器并适用所有job
////		scheduler.getListenerManager().addJobListener(new MyJobListener(), KeyMatcher.keyEquals(JobKey.jobKey("jobDetail1", "jobDetaiGroup1")));// 注册监听器并适用指定job
//		
////		scheduler.getListenerManager().addTriggerListener(new MyTriggerListener(), EverythingMatcher.allTriggers());
////		scheduler.getListenerManager().addTriggerListener(new MyTriggerListener(), KeyMatcher.keyEquals(TriggerKey.triggerKey("trigger2", "triggerGroup1")));
//		
//		scheduler.getListenerManager().addSchedulerListener(new MyScheduleListener());
//		
//		// 6、启动调度器
//		scheduler.start();
//		
//		Thread.sleep(20000);
//		
//		scheduler.shutdown();
		
		// ******quartz和spring整合*********
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Scheduler scheduler2 = (Scheduler) applicationContext.getBean("scheduler");
		scheduler2.start();
	}
}
