package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Required;

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
public class TestBean implements ITestBean {

	protected static final Log log = LogFactory.getLog(TestBean.class);

	private HelloWorld hw1;

	private HelloWorld hw2;

	private String str;

	public HelloWorld getHw1() {
		return hw1;
	}

	public HelloWorld getHw2() {
		return hw2;
	}

	public String getStr() {
		return str;
	}

	@Required
	public void setHw1(HelloWorld hw1) {
		this.hw1 = hw1;
	}

	@Required
	public void setHw2(HelloWorld hw2) {
		this.hw2 = hw2;
	}

	@Required
	public void setStr(String str) {
		this.str = str;
	}

	public void testBean() {
		if (this.hw1 != null) {
			log.info("hw1对象不为null!");
		}
		if (this.hw2 != null) {
			log.info("hw2对象不为null!");
		}
		if (this.str != null) {
			log.info("str不为null!");
		}
	}

}
