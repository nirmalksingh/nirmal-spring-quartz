package nirmal.singh.spring.quartz.job;

import nirmal.singh.spring.quartz.task.*;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
 
public class RunJobSendEmailTask extends QuartzJobBean
{
	private SendEmailTask sendEmailTask;
 
	public void setSendEmailTask(SendEmailTask emailTask) {
		this.sendEmailTask = emailTask;
	}
 
	protected void executeInternal(JobExecutionContext context)
	throws JobExecutionException {
 
		sendEmailTask.runTheJob();
 
	}
	
	public static void main( String[] args ) throws Exception
    {
    	new ClassPathXmlApplicationContext("Spring-Quartz.xml");
    }
	
}