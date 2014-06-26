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
