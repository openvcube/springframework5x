package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author worldheart
 *
 */
public class TestBean {
	
	protected static final Log log = LogFactory.getLog(TestBean.class);
			
	public TestBean(String location){
		log.info("TestBean(), " + location);
	}
	
}
