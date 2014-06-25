package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 
 * <pre>
 * 演示factory-method。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class FactoryMethodDemo {

	private static final Log log = LogFactory.getLog(FactoryMethodDemo.class);

	public String getContent(){
		//从classpath路径上装载XML配置信息
		Resource resource = new ClassPathResource("factorymethod.xml");
		//实例化IoC容器
		BeanFactory factory = new XmlBeanFactory(resource);
		//获得受管POJO
		IHelloWorld hw = (IHelloWorld) factory.getBean("helloWorld");
		//返回字符串
		return hw.getContent();
	}

	public static void main(String[] args) {
		FactoryMethodDemo bfd = new FactoryMethodDemo();
		//输出返回结果
		log.info(bfd.getContent());
	}
	
}