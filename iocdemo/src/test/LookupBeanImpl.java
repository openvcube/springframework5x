package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * <pre>
 * 提供抽象和具体方法。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public abstract class LookupBeanImpl{
	
	private static final Log log = LogFactory.getLog(LookupBeanImpl.class);
	
	private String name;
	
	public LookupBeanImpl(String nam){
		this.name = nam;
	}
	
	private int count;

	public abstract LookedBean createAbstractLookedBean();
	
	public LookedBean createLookedBean(){
		log.info("进入LookupBeanImpl实现的createLookedBean()方法");
		return new LookedBean();
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public String getName() {
		return name;
	}
	
}
