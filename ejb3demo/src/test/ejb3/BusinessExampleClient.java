package test.ejb3;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * EJB 3.0组件的远程客户端
 * 
 * @author worldheart
 * 
 */
public class BusinessExampleClient {

	protected static final Log log = LogFactory
			.getLog(BusinessExampleClient.class);

	public static void main(String[] args) throws Exception {

		//jndiofb.xml、access.xml、remoteslsb.xml
		ListableBeanFactory lbf = new ClassPathXmlApplicationContext(
				"jndiofb.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(lbf);
		IBusinessInterface se = gbfa.getBean("sbe");
		log.info(se.getStr("worldheart"));

	}

}