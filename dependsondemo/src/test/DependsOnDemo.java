package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  π”√depends-on
 * 
 * @author worldheart
 */
public class DependsOnDemo {

	protected static final Log log = LogFactory.getLog(DependsOnDemo.class);

	public static void main(String[] args) {

		//dependson1.xmlªÚdependson2.xml
		new ClassPathXmlApplicationContext("dependson1.xml");

	}

}