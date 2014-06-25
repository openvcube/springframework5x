package test;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 获得HelloWorld字符串
 * 
 * @author worldheart
 */
public class AutowiredHelloWorld implements IHelloWorld {
	
    @Autowired
    private IHelloStr helloStr;
    
    public String getContent() {
        return helloStr.getContent();
    }
        
}