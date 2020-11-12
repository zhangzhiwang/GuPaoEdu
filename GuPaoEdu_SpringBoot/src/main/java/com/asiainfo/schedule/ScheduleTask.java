package com.asiainfo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class ScheduleTask {
	@Scheduled(cron = "0/2 * * * * ?")
	public void schedule1() {
		System.out.println("schedule1...");
	}
}