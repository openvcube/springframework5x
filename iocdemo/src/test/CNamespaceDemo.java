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
 * 演示<c/>命名空间的使用。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class CNamespaceDemo {

	private static final Log log = LogFactory.getLog(CNamespaceDemo.class);

	public void getContent(){
		//从classpath路径上装载XML配置信息
		Resource resource = new ClassPathResource("cnamespace.xml");
		//实例化IoC容器
		BeanFactory factory = new XmlBeanFactory(resource);
		//获得受管POJO
		IHelloStr hs1 = (IHelloStr) factory.getBean("fileHello1");
		IHelloStr hs2 = (IHelloStr) factory.getBean("fileHello2");
		IHelloStr hs3 = (IHelloStr) factory.getBean("fileHello3");
	}

	public static void main(String[] args) {
		CNamespaceDemo bfd = new CNamespaceDemo();
		bfd.getContent();
	}
	
}