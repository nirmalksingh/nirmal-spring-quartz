package nirmal.singh.spring.quartz.task;

import nirmal.singh.spring.gmail.SimpleMailManager;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.mail.SimpleMailMessage;

public class SendEmailTask {
	
	static int i = 0;
	public static GenericApplicationContext context;

	/**
	 * This job is configured to trigger with a qurtz scheduler's cron expression in Spring-Quartz.xml file. 
	 */
	public void runTheJob() {

		System.out.println("Running job #" + ++i);

		SimpleMailManager mailMgr = (SimpleMailManager) context.getBean("emailManager");
		if (mailMgr.notificationGroup != null && mailMgr.notificationGroup.length > 0) {
			String[] str = (String[]) mailMgr.notificationGroup;
			System.out.println("Notified group email address(s) :");
			for (int i = 0; i < str.length; i++) {
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