package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

/**
 * 
 * <pre>
 * 程序的中文名称。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class JmsTemplateConverterDemo {

	private static final Log log = LogFactory.getLog(JmsTemplateConverterDemo.class);

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"converter.xml");
		
		JmsTemplate jt = (JmsTemplate)ac.getBean("jmsTemplate");
		
		UserPassInfo upi = new UserPassInfo();
		upi.setUsername("spring");
		upi.setPassword("dragon");
		
		jt.convertAndSend(upi);
		
		while(true){
			UserPassInfo up = (UserPassInfo) jt.receiveAndConvert();
			if(up == null) break;
			log.info(up);
		}		

	}
	
}
