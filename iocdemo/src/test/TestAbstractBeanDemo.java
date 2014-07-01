package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * <pre>
 * 演示抽象Bean和子Bean。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class TestAbstractBeanDemo {

	private static final Log log = LogFactory.getLog(TestAbstractBeanDemo.class);

	public static void main(String[] args) {
		//实例化IoC容器
		AbstractApplicationContext aac = 
			new ClassPathXmlApplicationContext("testabstractbean.xml");

		log.info(aac.getBean("childBean1"));
		log.info(aac.getBean("childBean2"));
		log.info(aac.getBean("childBean3"));
		log.info(aac.getBean("childBean4"));
		
	}
	
}