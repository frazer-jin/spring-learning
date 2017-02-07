package com.relay2.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("MyJon is running..." + new SimpleDateFormat("yyyy-MM-dd HH:ss:mm").format(new Date()));
	}

}
