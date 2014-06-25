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
public class HelloClientAfterReturning {

	protected static final Log log = LogFactory
			.getLog(HelloClientAfterReturning.class);

	public static void main(String[] args) {

		ListableBeanFactory factory = new ClassPathXmlApplicationContext(
				"afterreturning.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(
				factory);

		IHelloWorld hw = gbfa.getBean("helloworldbean");

		log.info(hw.getContent("worldheart"));

	}

}
