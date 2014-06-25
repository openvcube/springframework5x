package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

/**
 * 证实Resource的各种用法
 * 
 * @author worldheart
 *
 */
public class ResourceDemo2 {

	protected static final Log log = LogFactory.getLog(ResourceDemo2.class);
	
	public static void main(String[] args){

		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:test/resource2.xml");
		
		//获得ClassPathResource
		Resource res = ac.getResource("test/resource2.xml");
		
		//获得ClassPathResource
		res = ac.getResource("classpath:resource1.xml");
		
		//获得UrlResource
		res = ac.getResource("file:D:/eclipse/workspace/resourcedemo/src/resource1.xml");
		
		//获得ClassPathResource
		res = ac.getResource("D:/eclipse/workspace/resourcedemo/src/resource1.xml");
		
		ac = new FileSystemXmlApplicationContext("file:D:/eclipse/workspace/resourcedemo/src/resource1.xml");
		
		//获得UrlResource
		res = ac.getResource("file:D:/eclipse/workspace/resourcedemo/src/resource1.xml");
		
		//获得ClassPathResource
		res = ac.getResource("classpath:resource1.xml");
		
		//获得FileSystemResource
		res = ac.getResource("D:/eclipse/workspace/resourcedemo/src/resource1.xml");
	}
	
}
