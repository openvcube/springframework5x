package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 演示PropertyOverrideConfigurer的使用
 * 
 * @author worldheart
 * 
 */
public class PropertyOverrideConfigurerDemo {

	protected final static Log log = LogFactory.getLog(PropertyOverrideConfigurerDemo.class);

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"propertyoverrideconfigurer.xml");

		IUserInfo ui = (IUserInfo) ac.getBean("userInfo");

		log.info(ui.getUserInfo());
	}
	
}
