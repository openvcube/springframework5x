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
public class HelloClientBefore {

	protected static final Log log = LogFactory.getLog(HelloClientBefore.class);

	public static void main(String[] args) {

		//开发者可以动态切换到不同的XML配置文件
		ListableBeanFactory factory = new ClassPathXmlApplicationContext(
				"before.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(
				factory);

		IHelloWorld hw = gbfa.getBean("helloworldbean");

		log.info(hw.getContent("worldheart"));

	}

}
