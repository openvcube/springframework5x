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
public class HelloClientIntroduction {

	protected static final Log log = LogFactory
			.getLog(HelloClientIntroduction.class);

	public static void main(String[] args) {

		ListableBeanFactory factory = new ClassPathXmlApplicationContext(
				"introduction.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(
				factory);

		IHelloWorldService hw = gbfa.getBean("helloworldService");
		log.info(hw.getContent("worldheart"));		
		
		IIntroductionInfo ii = gbfa.getBean("helloworldService");
		log.info(ii.getIntro());

	}

}
