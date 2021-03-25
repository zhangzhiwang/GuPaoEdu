package com.asiainfo.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.Trigger.CompletedExecutionInstruction;
import org.quartz.TriggerListener;

/**
 * 自定义Trigger监听器
 *
 * @author zhangzhiwang
 * @date 2021年3月8日 下午7:54:00
 */
public class MyTriggerListener implements TriggerListener {

	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}

	@Override
	public void triggerFired(Trigger trigger, JobExecutionContext context) {
		String name = this.getClass().getSimpleName();
		System.out.println(name + "已触发");
	}

	@Override
	public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {

		return false;
	}

	@Override
	public void triggerMisfired(Trigger trigger) {
	}

	@Override
	public void triggerComplete(Trigger trigger, JobExecutionContext context, CompletedExecutionInstruction triggerInstructionCode) {
		String name = this.getClass().getSimpleName();
		System.out.println(name + "已完成");
	}
}
