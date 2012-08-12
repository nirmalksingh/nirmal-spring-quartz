package nirmal.singh.spring.gmail;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SimpleMailManager implements MailManager
{

	public MailSender sender = null;

	public String senderAddress;

	public String[] notificationGroup;

	public void setSender(MailSender sender)
	{
		this.sender = sender;
	}

	public void setSenderAddress(String senderAddress)
	{
		this.senderAddress = senderAddress;
	}

	public void setNotificationGroup(String delimitedAddressString)
	{
		if (delimitedAddressString != null && delimitedAddressString.trim().length() > 0)
		{
			String[] possibleAddress = delimitedAddressString.split(";");
			int nonEmptyCnt = 0;
			for (String str : possibleAddress)
			{
				if (str != null && str.trim().length() > 0)
				{
					nonEmptyCnt++;
				}
			}
			if (nonEmptyCnt > 0)
			{
				String[] nonEmpty = new String[nonEmptyCnt];
				int ind = 0;
				for (String str : possibleAddress)
				{
					if (str != null && str.trim().length() > 0)
					{
						nonEmpty[ind] = str.trim();
						ind++;
					}
				}
				this.notificationGroup = nonEmpty;
			}
		}
	}

	public void process(SimpleMailMessage mail)
	{
		if (emptyString(mail.getFrom()))
		{
			mail.setFrom(this.senderAddress);
		}
		if (mail.getTo() == null || mail.getTo().length < 1)
		{
			mail.setTo(this.notificationGroup);
		}
		
		this.sender.send(mail);
	}

	public SimpleMailMessage getTemplateNotification()
	{
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(this.senderAddress);
		message.setReplyTo(this.senderAddress);
		message.setTo(this.notificationGroup);

		return message;
	}

	private boolean emptyString(String str)
	{
		return str == null || str.trim().length() < 1;
	}

}
