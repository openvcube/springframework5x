package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author worldheart
 *
 */
public class LogRunner implements Runnable {
	
	protected static final Log log = LogFactory.getLog(LogRunner.class);
	
	public void run() {
		log.info("run().......");
		log.info(Thread.currentThread());
	}

}
