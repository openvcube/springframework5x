package org.springframework.samples.jpetstore.service.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author worldheart
 * 
 */
public class JmsServerDemo {

	protected static final Log log = LogFactory.getLog(JmsServerDemo.class);

	public static void main(String[] args) {
		AbstractXmlApplicationContext acc = new ClassPathXmlApplicationContext(
				"jmsServerContext.xml");
		acc.registerShutdownHook();
	}

}
