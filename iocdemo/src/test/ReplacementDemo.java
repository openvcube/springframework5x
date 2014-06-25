package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 查找方法注入
 * 
 * @author worldheart
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