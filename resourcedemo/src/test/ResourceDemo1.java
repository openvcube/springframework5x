package test;

import java.io.File;
import java.net.MalformedURLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

/**
 * 
 * <pre>
 * 证实Resource的各种用法。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class ResourceDemo1 {

	private static final Log log = LogFactory.getLog(ResourceDemo1.class);
	
	public static void main(String[] args){
		
		//在classpath根路径查找resource1.xml
		Resource res = new ClassPathResource("resource1.xml");
		new XmlBeanFactory(res).getBean("testBean1");
		
		//在test目录定位resource2.xml
		res = new ClassPathResource("test/resource2.xml");
		new XmlBeanFactory(res).getBean("testBean2");
		
		//在TestBean类所在目录定位resource2.xml
		res = new ClassPathResource("resource2.xml", TestBean.class);
		new XmlBeanFactory(res).getBean("testBean2");

		//直接传入文件路径
		res = new FileSystemResource("D:/sts-bundle/workspace/springframework42/resourcedemo/src/test/resource2.xml");
		new XmlBeanFactory(res).getBean("testBean2");
		
		//将构建的File Handler传入到FileSystemResource中
		File file = new File("D:/sts-bundle/workspace/springframework42/resourcedemo/src/resource1.xml");
		res = new FileSystemResource(file);
		new XmlBeanFactory(res).getBean("testBean1");
		
		try{
			//支持file:、http:、ftp:、等前缀，这些都是标准的URL格式
			res = new UrlResource("file:D:/sts-bundle/workspace/springframework42/resourcedemo/src/resource1.xml");
			new XmlBeanFactory(res).getBean("testBean1");
		} catch(MalformedURLException mue){
			log.error("", mue);
		}
		
	}
	
}
