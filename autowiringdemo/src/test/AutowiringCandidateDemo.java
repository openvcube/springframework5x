package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * <pre>
 * 使用autowire。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class AutowiringCandidateDemo {

	protected static final Log log = LogFactory.getLog(AutowiringCandidateDemo.class);

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("autowire-candidate.xml");
		
		TestBean4 testBean4 = (TestBean4)ac.getBean("testBean4");
		
		log.info(testBean4.getTestBean5());
		
		TestBean6 testBean6 = (TestBean6)ac.getBean("testBean6");
		
		log.info(testBean6.getTestBean4());
				
	}

}