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
public class HelloClientCGLIB {

	protected static final Log log = LogFactory.getLog(HelloClientCGLIB.class);

	public static void main(String[] args) {

		ListableBeanFactory factory = new ClassPathXmlApplicationContext(
				"cglib.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(
				factory);

		IHelloWorld hw1 = gbfa.getBean("helloworldbean");
		log.info(hw1.getContent("worldheart"));
		HelloWorld hw2 = gbfa.getBean("helloworldbean");
		log.info(hw2.getContent("worldheart"));

	}

}
