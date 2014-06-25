package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author worldheart
 * 
 */
public class HelloClientAutoProxy {

	protected static final Log log = LogFactory
			.getLog(HelloClientAutoProxy.class);

	public static void main(String[] args) {

		ListableBeanFactory factory = new ClassPathXmlApplicationContext(
				"autoproxy.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(
				factory);

		IHelloWorld hw1 = gbfa.getBean("helloworldbean1");
		log.info(hw1.getContent("worldheart"));

		IHelloWorld hw2 = gbfa.getBean("helloworldbean2");
		log.info(hw2.getContent("worldheart"));
		
	}

}
