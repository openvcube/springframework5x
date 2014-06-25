package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * 
 * @author worldheart
 *
 */
public class SimpleMailDemo {

	protected static final Log log = LogFactory
			.getLog(SimpleMailDemo.class);

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"simplemail.xml");

		MailSender ms = (MailSender) ac.getBean("mailSender");
		SimpleMailMessage mm = (SimpleMailMessage) ac.getBean("mailMessage");

		mm.setSubject("欢迎使用Spring JavaMail集成");
		mm.setText("谢谢您的到来!");

		ms.send(mm);

	}

}
