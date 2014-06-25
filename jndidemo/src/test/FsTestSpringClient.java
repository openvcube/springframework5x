/**
 * 
 */
package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * File System示例使用(Spring版本)
 * 
 * @author worldheart
 * 
 */
public class FsTestSpringClient {

	protected static final Log log = LogFactory.getLog(FsTestClient.class);

	public static void main(String[] args) {
		
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext("fs.xml");
		
		Object fc = ac.getBean("fc");		
		log.info(fc);
		
	}

}
