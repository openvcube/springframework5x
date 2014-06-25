package test;

import org.springframework.beans.factory.annotation.Autowired;

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
public class AutowiredHelloWorld implements IHelloWorld {
	
    @Autowired
    private IHelloStr helloStr;
    
    public String getContent() {
        return helloStr.getContent();
    }
        
}