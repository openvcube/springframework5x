package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * <pre>
 * 程序的中文名称。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class HelloClientCGLIB {

	private static final Log log = LogFactory.getLog(HelloClientCGLIB.class);

	public static void main(String[] args) {

		ListableBeanFactory factory = new ClassPathXmlApplicationContext(
				"cglib.xml");

		IHelloWorld hw1 = (IHelloWorld)factory.getBean("helloworldbean");
		log.info(hw1.getContent("worldheart"));
		HelloWorld hw2 = (HelloWorld)factory.getBean("helloworldbean");
		log.info(hw2.getContent("worldheart"));

	}

}
