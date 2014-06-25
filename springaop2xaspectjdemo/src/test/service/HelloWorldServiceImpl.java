package test.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import test.dao.IHelloWorldDao;

/**
 * 
 * @author worldheart
 *
 */
public class HelloWorldServiceImpl implements IHelloWorldService {
	
	private IHelloWorldDao helloWorldDao;
	
	public void setHelloWorldDao(IHelloWorldDao helloWorldDao) {
		this.helloWorldDao = helloWorldDao;
	}
	
	public IHelloWorldDao getHelloWorldDao() {
		return helloWorldDao;
	}
	
    protected static final Log log = LogFactory.getLog(HelloWorldServiceImpl.class);
    
    public String getContent(String helloworld) {
        log.info(helloworld);
    	return this.getHelloWorldDao().getContent(helloworld);
    }
    
}
