package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 提供抽象和具体方法
 * 
 * @author worldheart
 * 
 */
public class ReplacedBeanImpl implements IReplacedBean {

	protected static final Log log = LogFactory.getLog(ReplacedBeanImpl.class);

	private String name;

	private int count;

	public ReplacedBeanImpl(String nam) {
		this.name = nam;
	}

	public String computeResult(String key) {
		log.info("进入ReplacedBeanImpl实现的computeResult(String key)方法");
		return this.name + "-" + key + "-" + count;
	}

	public String computeResult(int key) {
		log.info("进入ReplacedBeanImpl实现的computeResult(int key)方法");
		return this.name + "-" + key + "-" + count;
	}

	public String getName() {
		return name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
