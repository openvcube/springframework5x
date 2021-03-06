package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * <pre>
 * 各类FactoryBean的使用。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class ConstantDemo {

	private static final Log log = LogFactory.getLog(ConstantDemo.class);

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("constant.xml");
		
		log.info(ac.getBean("test.HelloWorld.hwStatic"));
		log.info(ac.getBean("helloWorld"));
		log.info(ac.getBean("hwConstant"));			
	}

}