package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

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
public class ResourceDemo2 {

	private static final Log log = LogFactory.getLog(ResourceDemo2.class);
	
	public static void main(String[] args){

		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:test/resource2.xml");
		
		//获得ClassPathResource
		Resource res = ac.getResource("test/resource2.xml");
		
		//获得ClassPathResource
		res = ac.getResource("classpath:resource1.xml");
		
		//获得UrlResource
		res = ac.getResource("file:D:/sts-bundle/workspace/springframework40/resourcedemo/src/resource1.xml");
		
		//获得ClassPathResource
		res = ac.getResource("D:/sts-bundle/workspace/springframework40/resourcedemo/src/resource1.xml");
		
		ac = new FileSystemXmlApplicationContext("file:D:/sts-bundle/workspace/springframework40/resourcedemo/src/resource1.xml");
		
		//获得UrlResource
		res = ac.getResource("file:D:/sts-bundle/workspace/springframework40/resourcedemo/src/resource1.xml");
		
		//获得ClassPathResource
		res = ac.getResource("classpath:resource1.xml");
		
		//获得FileSystemResource
		res = ac.getResource("D:/sts-bundle/workspace/springframework40/resourcedemo/src/resource1.xml");
	}
	
}
