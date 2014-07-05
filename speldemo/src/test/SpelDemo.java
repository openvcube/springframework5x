package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * <pre>
 * 演示SpEL的使用。
 * </pre>
 * 
 * @author http://www.open-v.com
 * @version 1.00.00
 * 
 *          <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 * </pre>
 */
public class SpelDemo {

	private static final Log log = LogFactory.getLog(SpelDemo.class);

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spel.xml");
		TestBean1 testBean1 = (TestBean1)ac.getBean(test.TestBean1.class);
		log.info(testBean1.getUserName());
		log.info(testBean1.isValidFlag());
		TestBean2 testBean2 = (TestBean2)ac.getBean(test.TestBean2.class);
		log.info(testBean2.getUserName1());
		log.info(testBean2.getUserName2());
	}

}
