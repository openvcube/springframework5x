package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author worldheart
 * 
 */
public class HelloWorldThrowing implements IHelloWorld {

	protected static final Log log = LogFactory
			.getLog(HelloWorldThrowing.class);

	public String getContent(String helloworld) {
		log.info(helloworld);
		if (true)
			throw new RuntimeException("getContent");
		return helloworld;
	}

}
