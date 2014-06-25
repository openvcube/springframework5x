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
public class AttachmentMailDemo {

	protected static final Log log = LogFactory
			.getLog(AttachmentMailDemo.class);

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"attachmentmail.xml");

		JavaMailSender ms = (JavaMailSender) ac.getBean("mailSender");
		
		//使用MimeMessagePreparator回调接口
		ms.send(new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws Exception {
				//包装MimeMessage，以简化对MimeMessage的操作
				MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);

				//设置邮件元数据信息
				mmh.setTo("javaee@open-v.com");
				mmh.setFrom("test@open-v.com","openv测试用户");
				mmh.setSubject("欢迎使用Spring JavaMailSenderImpl发送附件");
				mmh.setText("谢谢，请查收附件内容！");

				//添加附件
				mmh.addAttachment("logo.gif",
						new ClassPathResource("/logo.gif"));
				mmh.addAttachment("mail.properties",
						new ClassPathResource("/mail.properties"));
			}
		});

	}

}
