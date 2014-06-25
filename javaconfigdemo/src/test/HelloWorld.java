package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HelloWorld implements IHelloWorld {
	
    protected static final Log log = LogFactory.getLog(HelloWorld.class);

    private IHelloStr helloStr;
    
    public void setHelloStr(IHelloStr str) {
		this.helloStr = str;
	}

    public String getContent() {
        return helloStr.getContent();
    }
    
}