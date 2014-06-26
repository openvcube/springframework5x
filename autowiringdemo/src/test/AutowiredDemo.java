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
public class AutowiredDemo {

	protected static final Log log = LogFactory.getLog(AutowiredDemo.class);

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("autowired.xml");
		
		TestBean1 testBean1 = (TestBean1)ac.getBean("testBean1");
		
		log.info(testBean1.getTestBean2());
		log.info(testBean1.getTestBean3());
						
	}

}