package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.pointcut.AnnotationParam;
import test.pointcut.ClassForPointInfo;

/**
 * 
 * @author worldheart
 * 
 */
public class ClassForPointInfoClient {

	protected static final Log log = LogFactory.getLog(ClassForPointInfoClient.class);

	public static void main(String[] args) {

		ListableBeanFactory factory = new ClassPathXmlApplicationContext("pointcut.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(
				factory);

		ClassForPointInfo hw = gbfa.getBean("classForPointInfo");

		log.info(hw.getInfo1());

		log.info(hw.getInfo1(null));
		
		log.info(hw.getInfo1(null,0));
		
		hw.setInfo2(new AnnotationParam());
		
		hw.setInfo3();
	}

}
