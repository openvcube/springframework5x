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
public class HttpServerDemo {

	protected static final Log log = LogFactory.getLog(HttpServerDemo.class);

	public static void main(String[] args) {
		AbstractXmlApplicationContext acc = new ClassPathXmlApplicationContext(
				"httpServerContext.xml");
		acc.registerShutdownHook();
	}

}
