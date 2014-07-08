package test;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.showcase.fortune.domain.Fortune;
import org.springframework.web.servlet.mvc.Controller;

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
public class ScriptSpringDemo {

	private static final Log log = LogFactory.getLog(ScriptSpringDemo.class);
	
	public static void main(String[] args) throws Exception {
			//切换到ac-beanshell.xml、ac-jruby.xml、ac-groovy.xml、ac-groovy-version2.xml
			ListableBeanFactory lbf = new ClassPathXmlApplicationContext("ac-groovy.xml");
			Controller controll = (Controller)lbf.getBean("controller");
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
