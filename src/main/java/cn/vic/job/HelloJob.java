package cn.vic.job;

import java.util.Date;

//import org.apache.log4j.spi.LoggerFactory; //interface
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory; //class

public class HelloJob implements Job {
	
	Logger logger = LoggerFactory.getLogger(HelloJob.class);
	

	public void execute(JobExecutionContext context) throws JobExecutionException {
		// Say Hello to the World and display the date/time
	    logger.info("Hello World! - " + new Date());
	}
	
}
