package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * <pre>
 * 获得HelloWorld字符串。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class HelloWorld implements IHelloWorld {
	
    private static final Log log = LogFactory.getLog(HelloWorld.class);

    private IHelloStr helloStr;
    
    public void setHelloStr(IHelloStr str) {
		this.helloStr = str;
	}

    public String getContent() {
        return helloStr.getContent();
    }
    
    public static HelloWorld getHelloWorld(){
    	return new HelloWorld();
    }
        
    public HelloWorld makeHelloWorld(){
    	return new HelloWorld();
    }
    
    public static HelloWorld getHelloWorld(IHelloStr helloStr){
    	HelloWorld hw = new HelloWorld();
    	hw.setHelloStr(helloStr);
    	return hw;
    }
    
    public HelloWorld makeHelloWorld(IHelloStr helloStr){
    	HelloWorld hw = new HelloWorld();
    	hw.setHelloStr(helloStr);
    	return hw;
    }
    
}