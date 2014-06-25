package test;

import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

/**
 * 
 * @author worldheart
 *
 */
public class InlineMailDemo {

	protected static final Log log = LogFactory
			.getLog(InlineMailDemo.class);

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"inlinemail.xml");

		JavaMailSender ms = (JavaMailSender) ac.getBean("mailSender");
		
		//使用MimeMessagePreparator回调接口
		ms.send(new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				//包装MimeMessage，以简化对MimeMessage的操作
				MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);

				//设置邮件元数据信息
				mmh.setTo("javaee@open-v.com");
				mmh.setFrom("test@open-v.com","openv测试用户");
				mmh.setSubject("欢迎使用Spring JavaMailSenderImpl发送含有HTML、内嵌资源的邮件");
				
				//添加HTML、内嵌资源
				mmh.setText("欢迎来到这里，<a href='http://www.open-v.com'><img src='cid:logo' /></a>", true);
			    mmh.addInline("logo", new ClassPathResource("/logo.gif"));
			}
		});

	}

}
