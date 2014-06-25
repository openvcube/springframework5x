package test;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.showcase.fortune.domain.Fortune;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 
 * @author worldheart
 *
 */
public class ScriptSpringDemo {

	private static final Log log = LogFactory.getLog(ScriptSpringDemo.class);
	
	public static void main(String[] args) throws Exception {
			//ÇÐ»»µ½ac-beanshell.xml¡¢ac-jruby.xml¡¢ac-groovy.xml¡¢ac-groovy-version2.xml
			ListableBeanFactory lbf = new ClassPathXmlApplicationContext("ac-groovy.xml");
			GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(lbf);
			Controller controll = gbfa.getBean("controller");
			while(true){
				Thread.sleep(2000);
				Map map = controll.handleRequest(null, null).getModel(); 
				Iterator iterator = map.entrySet().iterator();
				Map.Entry forEntry = (Map.Entry)iterator.next();
				Fortune fortune = (Fortune)forEntry.getValue();
				log.info("source:" + fortune.getSource() + ", fortune:" + fortune.getFortune());
			}
	}

}
