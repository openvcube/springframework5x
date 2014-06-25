package test.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author worldheart
 *
 */
public class HelloWorldDaoThrowingImpl implements IHelloWorldDao {
	
    protected static final Log log = LogFactory.getLog(HelloWorldDaoThrowingImpl.class);
    
	private String helloworld;
	
	public void setHelloworld(String helloworld) {
		this.helloworld = helloworld;
	}
	
	public String getHelloworld() {
		return helloworld;
	}
	
    public String getContent(String helloworld) {
        log.info(helloworld);
        if(true)
        	throw new RuntimeException("runtime exception");
    	if(helloworld == null || "".equals(helloworld.trim()))
    		return this.getHelloworld(); 
        return helloworld;
    }
    
}