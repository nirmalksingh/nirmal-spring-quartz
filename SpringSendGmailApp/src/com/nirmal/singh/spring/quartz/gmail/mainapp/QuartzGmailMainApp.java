package com.nirmal.singh.spring.quartz.gmail.mainapp;

import nirmal.singh.spring.quartz.task.SendEmailTask;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class QuartzGmailMainApp 
{
    public static void main( String[] args ) throws Exception
    {
    	GenericApplicationContext context = new GenericApplicationContext();
    	XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(context);
		xmlReader.loadBeanDefinitions(new ClassPathResource("applicationContext-gmail.xml"));
		xmlReader.loadBeanDefinitions(new ClassPathResource("Spring-Quartz.xml"));
		context.refresh();
    	SendEmailTask.context = context;
    }
}
