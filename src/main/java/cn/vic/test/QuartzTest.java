package cn.vic.test;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import cn.vic.job.HelloJob;

public class QuartzTest {
	
	public static void main(String[] args) throws Exception {
		
		//Grab the Scheduler instance from the factory
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		
		//and start it off
		scheduler.start();
		
		//define the job and tie it to our HelloJob class
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
				.withIdentity("job1", "group1")
				.build();
		
		//trigger the job to run now, and the repeat every 40 seconds
		
		Trigger trigger = TriggerBuilder.newTrigger()
		.withIdentity("trigger1", "group1")
		.startNow()
		.withSchedule(SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(2)
				.repeatForever()
				)
		.build();

		// Tell quartz to schedule the job using our trigger
		scheduler.scheduleJob(jobDetail, trigger);
		
		Thread.sleep(20000);
		scheduler.shutdown();
	}
	
}
