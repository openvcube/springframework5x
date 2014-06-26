package test;

import org.springframework.beans.factory.BeanNameAware;

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
public class TestBean2 implements BeanNameAware{

	private String name;
	
	public void setBeanName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
