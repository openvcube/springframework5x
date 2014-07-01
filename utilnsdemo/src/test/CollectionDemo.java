package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * <pre>
 * 定义集合。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class CollectionDemo {

	private static final Log log = LogFactory.getLog(CollectionDemo.class);

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("list.xml");
		CollectionBean cb = (CollectionBean) ac.getBean("collectionBean");
		log.info(cb.getList());
		log.info(ac.getBean("list"));
		log.info(ac.getBean("listUtil"));
		ac = new ClassPathXmlApplicationContext("set.xml");
		cb = (CollectionBean) ac.getBean("collectionBean");
		log.info(cb.getSet());
		log.info(ac.getBean("set"));
		log.info(ac.getBean("setUtil"));
		ac = new ClassPathXmlApplicationContext("map.xml");
		cb = (CollectionBean) ac.getBean("collectionBean");
		log.info(cb.getMap());
		cb = (CollectionBean) ac.getBean("collectionBean1");
		log.info(cb.getMapTyped());
		log.info(ac.getBean("map"));
		log.info(ac.getBean("mapUtil"));
		ac = new ClassPathXmlApplicationContext("map.xml");
		cb = (CollectionBean) ac.getBean("collectionBean");
		log.info(cb.getMapTyped());
		ac = new ClassPathXmlApplicationContext("properties.xml");
		cb = (CollectionBean) ac.getBean("collectionBean");
		log.info(cb.getProperties());
		log.info(ac.getBean("properties"));
		log.info(ac.getBean("commonsLogging"));
		log.info(ac.getBean("commonsLoggingProperties"));
	}

}