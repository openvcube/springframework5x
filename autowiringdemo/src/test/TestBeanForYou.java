package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TestBeanForYou implements ITestBean{
	
	protected static final Log log = LogFactory.getLog(TestBeanForYou.class);
	
	private HelloWorld hw;
	
	public HelloWorld getHw() {
		return hw;
	}
	
	@ForYou
	public void setHw(HelloWorld hw) {
		this.hw = hw;
	}
	
	public void testBean() {
		if(this.hw  != null){
			log.info("HelloWorld对象不为null!");
		}
	}

}
