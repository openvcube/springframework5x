package test.dao;

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
public class HelloWorldDaoImpl implements IHelloWorldDao {
	
    private static final Log log = LogFactory.getLog(HelloWorldDaoImpl.class);
    
	private String helloworld;
	
	public void setHelloworld(String helloworld) {
		this.helloworld = helloworld;
	}
	
	public String getHelloworld() {
		return helloworld;
	}
	
    public String getContent(String helloworld) {
        log.info(helloworld);
    	if(helloworld == null || "".equals(helloworld.trim()))
    		return this.getHelloworld(); 
        return helloworld;
    }
    
}