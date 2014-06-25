package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 演示bean scope属性的使用
 * 
 * @author worldheart
 * 
 */
public class PrototypeDemo {

	protected final static Log log = LogFactory.getLog(PrototypeDemo.class);

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"prototype.xml");

		IResInfo ri = (IResInfo) ac.getBean("resInfo");		
		UserInfo ui  = (UserInfo) ac.getBean("userInfo");		
	}
	
}
