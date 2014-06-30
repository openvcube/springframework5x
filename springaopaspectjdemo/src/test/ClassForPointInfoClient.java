package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.pointcut.AnnotationParam;
import test.pointcut.ClassForPointInfo;

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
public class ClassForPointInfoClient {

	private static final Log log = LogFactory.getLog(ClassForPointInfoClient.class);

	public static void main(String[] args) {

		ListableBeanFactory factory = new ClassPathXmlApplicationContext("pointcut.xml");

		ClassForPointInfo hw = (ClassForPointInfo)factory.getBean("classForPointInfo");

		log.info(hw.getInfo1());

		log.info(hw.getInfo1(null));
		
		log.info(hw.getInfo1(null,0));
		
		hw.setInfo2(new AnnotationParam());
		
		hw.setInfo3();
	}

}
