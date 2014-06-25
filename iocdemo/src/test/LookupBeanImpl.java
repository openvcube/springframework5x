package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 提供抽象和具体方法
 * 
 * @author worldheart
 *
 */
public abstract class LookupBeanImpl {
	
	protected static final Log log = LogFactory.getLog(LookupBeanImpl.class);
	
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
