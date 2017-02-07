package com.relay2.schedule;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws Exception {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-schedule.xml");

		// MyScheduler scheduler = (MyScheduler) ctx.getBean("scheduler");

		JobDetail jobDetail = JobBuilder.newJob().ofType(MyJob.class).withIdentity("name-1", "group-1").build();
		Trigger jobTrigger = TriggerBuilder.newTrigger().withIdentity("name-1", "group-1")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).withRepeatCount(4))
				.build();
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.scheduleJob(jobDetail, jobTrigger);
		scheduler.start();
		//scheduler.shutdown(true);
	}

}