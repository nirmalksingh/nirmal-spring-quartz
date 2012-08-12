package nirmal.singh.spring.quartz.job.mainapp;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuartzJobMainApp 
{
    public static void main( String[] args ) throws Exception
    {
    	new ClassPathXmlApplicationContext("Spring-Quartz.xml");
		
    }
}