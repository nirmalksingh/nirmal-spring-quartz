package nirmal.singh.spring.gmail;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;

public class MailManagerSender {
	
	public static void main( String[] args ){
		
		System.out.println("start of the program");
		
		
//		GenericApplicationContext ctx = new GenericApplicationContext();
//		XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(ctx);
//		xmlReader.loadBeanDefinitions(new ClassPathResource("modelContext.xml"));
//		xmlReader.loadBeanDefinitions(new ClassPathResource("uiContext.xml"));
//		ctx.refresh();
		
		GenericApplicationContext context = new GenericApplicationContext();
		XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(context);
		xmlReader.loadBeanDefinitions(new ClassPathResource("applicationContext.xml"));
		xmlReader.loadBeanDefinitions(new ClassPathResource("Spring-Quartz.xml"));
		context.refresh();
		
//    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
    	SimpleMailManager mailMgr = (SimpleMailManager)context.getBean("emailManager");
    	if(mailMgr.notificationGroup != null && mailMgr.notificationGroup.length >0){
    		String[] str = (String[])mailMgr.notificationGroup;
    		System.out.println("Notified group email address(s) :");
    		for(int i=0;i<str.length;i++){
    			System.out.println(str[i]);
    		}
    	}
    	
    	System.out.println("Sender's address :");
    	System.out.println(mailMgr.senderAddress.toString());
    	
    	SimpleMailMessage mail = mailMgr.getTemplateNotification();
    	
    	StringBuffer sb = new StringBuffer();
		sb.append("This is a test email from Nirmal, please ignore.");
		mail.setText(sb.toString());
		mail.setSubject("This is a test message, please ignore.");
    	
    	mailMgr.process(mail);
    }
}