package test;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 直接借助JavaMail API发送邮件
 * 
 * @author worldheart
 * 
 */
public class SendMailDemo {

	protected static final Log log = LogFactory.getLog(SendMailDemo.class);

	public static void main(String[] args) {
		String host = "mail.open-v.com";
		String toAdd = "javaee@open-v.com";
		String fromAdd = "test@open-v.com";

		SendMailDemo smd = new SendMailDemo();
		// 构建并发送邮件
		smd.sendMail(host, toAdd, fromAdd);
	}

	public void sendMail(String host, String toAdd, String fromAdd) {
		// 提供创建Session时需要使用的属性
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");// 有些邮件服务器要求身份认证

		Session session = Session.getInstance(props, null);
		session.setDebug(true);

		Transport tran = null;
		try {
			// 构建消息
			MimeMessage msg = new MimeMessage(session);
			// 提供发件人
			msg.setFrom(new InternetAddress(fromAdd));
			// 提供收件人集合
			InternetAddress[] address = { new InternetAddress(toAdd) };
			msg.setRecipients(Message.RecipientType.TO, address);
			// 设置主题
			msg.setSubject("欢迎使用JavaMail API");
			// 设置发送日期
			msg.setSentDate(new Date());
			// 设置邮件主体
			MimeBodyPart mbp = new MimeBodyPart();
			mbp.setText("谢谢您的到来!");
			Multipart mp = new MimeMultipart();
			mp.addBodyPart(mbp);
			// 添加到消息中
			msg.setContent(mp);
			// 获得Transport，并建立到邮件服务器的传输通道
			tran = session.getTransport("smtp");
			tran.connect(host, "test@open-v.com", "mamama");
			// 发送邮件
			tran.sendMessage(msg, msg.getAllRecipients());
		} catch (MessagingException mex) {
			log.error("", mex);
		} finally {
			if (tran != null)
				try {
					tran.close();
				} catch (MessagingException me) {
					;
				}
		}
	}
	
}
