package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * <pre>
 * 程序的中文名称。
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
    
}
