package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.service.IHelloWorldService;

/**
 * 
 * @author worldheart
 * 
 */
public class HelloClientBefore {

	protected static final Log log = LogFactory.getLog(HelloClientBefore.class);

	public static void main(String[] args) {

		//before.xml»òadvisor.xml
		ListableBeanFactory factory = new ClassPathXmlApplicationContext(
				"before.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(
				factory);

		IHelloWorldService hw = gbfa.getBean("helloworldService");

		log.info(hw.getContent("worldheart"));

	}

}
