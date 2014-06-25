package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * <pre>
 * 查找方法注入。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class ReplacementDemo {

	protected static final Log log = LogFactory.getLog(ReplacementDemo.class);

	public static void main(String[] args) {
		//实例化IoC容器
		ApplicationContext aac = new ClassPathXmlApplicationContext("replace.xml");

		//获得受管POJO
		IReplacedBean rb = (IReplacedBean) aac.getBean("replacementBean");
				
		log.info(rb.computeResult("password"));
		log.info(rb.computeResult(2008));
		
	}
	
}