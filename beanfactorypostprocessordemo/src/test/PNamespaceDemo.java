package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 演示PropertyPlaceholderConfigurer的使用
 * 
 * @author worldheart
 * 
 */
public class PNamespaceDemo {

	protected final static Log log = LogFactory.getLog(PNamespaceDemo.class);

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"pnamespace.xml");

		IUserInfo ui = (IUserInfo) ac.getBean("userInfo");

		log.info(ui.getUserInfo());
	}
}
