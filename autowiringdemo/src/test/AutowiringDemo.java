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
public class AutowiringDemo {

	private static final Log log = LogFactory.getLog(AutowiringDemo.class);

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("autowire.xml");
		
		TestBean1 tbByName = (TestBean1)ac.getBean("tbByName");
		
		log.info(tbByName.getTestBean2());
		log.info(tbByName.getTestBean3());
		
		TestBean1 tbByType = (TestBean1)ac.getBean("tbByType");
		
		log.info(tbByType.getTestBean2());
		log.info(tbByType.getTestBean3());
		
		TestBean1 tbConstructor = (TestBean1)ac.getBean("tbConstructor");
		
		log.info(tbConstructor.getTestBean2());
		log.info(tbConstructor.getTestBean3());

	}

}