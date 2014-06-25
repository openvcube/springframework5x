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
public class PropertyPlaceholderConfigurerDemo {

	protected final static Log log = LogFactory.getLog(PropertyPlaceholderConfigurerDemo.class);

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"propertyplaceholderconfigurer.xml");

		IUserInfo ui = (IUserInfo) ac.getBean("userInfo");

		log.info(ui.getUserInfo());
	}
}
