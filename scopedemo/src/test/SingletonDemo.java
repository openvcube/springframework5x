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
public class SingletonDemo {

	protected final static Log log = LogFactory.getLog(SingletonDemo.class);

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"singleton.xml");

		IResInfo ri1 = (IResInfo) ac.getBean("resInfo1");
		IResInfo ri2 = (IResInfo) ac.getBean("resInfo1");
	}
	
}
