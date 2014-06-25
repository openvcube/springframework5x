package test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author Administrator
 *
 */
public class ResourceAdapterFactoryBeanDemo {

	public static void main(String[] args) {
		ConfigurableApplicationContext cac = 
			new ClassPathXmlApplicationContext("rafb.xml");
	}

}
