package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.aspect.LoggingBeforeAspect;
import test.service.IHelloWorldService;

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
public class HelloClientBeforeProgram {

	private static final Log log = LogFactory
			.getLog(HelloClientBeforeProgram.class);

	public static void main(String[] args) {

		ListableBeanFactory factory = new ClassPathXmlApplicationContext(
				"beforeprogram.xml");

		AspectJProxyFactory ajpFactory = new AspectJProxyFactory(factory
				.getBean("helloworldService"));

		ajpFactory.addAspect(LoggingBeforeAspect.class);

		IHelloWorldService hw = ajpFactory.getProxy();

		log.info(hw.getContent("worldheart"));

	}

}
