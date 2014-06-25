package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * <pre>
 * 提供具体方法。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class ReplacedBeanImpl implements IReplacedBean {

	private static final Log log = LogFactory.getLog(ReplacedBeanImpl.class);

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
