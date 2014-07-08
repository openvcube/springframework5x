package test;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
public class HibernateTemplateOperDemo {

	public static void main(String[] args) {
		ListableBeanFactory lbf = new ClassPathXmlApplicationContext(
				"hibernatetemplate.xml");

		IOper hto = (IOper)lbf.getBean("hibernateTemplateOper");
		hto.testOper();

	}

}
