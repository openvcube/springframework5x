package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * ΩË÷˙Spring JavaMail≥ÈœÛ∑¢ÀÕ” º˛
 * 
 * @author worldheart
 * 
 */
public class SendMailDemoSpringJavaMailVersion {

	protected static final Log log = LogFactory
			.getLog(SendMailDemoSpringJavaMailVersion.class);

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"springjavamailversion.xml");
		JavaMailSender ms = (JavaMailSender) ac.getBean("mailSender");
		
		SimpleMailMessage mm = (SimpleMailMessage)ac.getBean("mailMessage");
		
		ms.send(mm);
		
	}

}
