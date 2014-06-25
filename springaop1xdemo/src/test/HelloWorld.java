package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author worldheart
 * 
 */
public class HelloWorld implements IHelloWorld {

	protected static final Log log = LogFactory.getLog(HelloWorld.class);

	public String getContent(String helloworld) {
		log.info(helloworld);
		return helloworld;
	}

}
