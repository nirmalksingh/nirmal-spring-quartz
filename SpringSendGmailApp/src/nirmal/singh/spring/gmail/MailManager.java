package nirmal.singh.spring.gmail;
import org.springframework.mail.SimpleMailMessage;

public interface MailManager
{
	/**
	 * Gets an email instance with the typical addressing information for a general notification.
	 * 
	 * @return An email object with the configured values for addresses.
	 */
	public SimpleMailMessage getTemplateNotification();

	public void process(SimpleMailMessage mail);

}
