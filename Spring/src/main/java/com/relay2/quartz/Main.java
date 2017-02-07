package com.relay2.quartz;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		
		JobDetail jobDetail = JobBuilder.newJob(MyJob.class).build();
		
		Trigger trigger = new SimpleTriggerImpl().getTriggerBuilder().withIdentity("job").startNow().build();
		
		scheduler.scheduleJob(jobDetail, trigger);
		
		scheduler.start();
		
		Thread.sleep(2000);
		
		scheduler.shutdown(true);
	}
	
	public static class MyJob implements Job{

		@Override
		public void execute(JobExecutionContext context) throws JobExecutionException {
			System.out.println("MyJob is running###########context: " + context);
		}
		
	}
	
}
