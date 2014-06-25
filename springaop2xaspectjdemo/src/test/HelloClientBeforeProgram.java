package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.aspect.LoggingBeforeAspect;
import test.service.IHelloWorldService;

/**
 * 
 * @author worldheart
 * 
 */
public class HelloClientBeforeProgram {

	protected static final Log log = LogFactory
			.getLog(HelloClientBeforeProgram.class);

	public static void main(String[] args) {

		ListableBeanFactory factory = new ClassPathXmlApplicationContext(
				"beforeprogram.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(
				factory);

		AspectJProxyFactory ajpFactory = new AspectJProxyFactory(gbfa
				.getBean("helloworldService"));

		ajpFactory.addAspect(LoggingBeforeAspect.class);

		IHelloWorldService hw = ajpFactory.getProxy();

		log.info(hw.getContent("worldheart"));

	}

}
