package test.ejb3;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * <pre>
 * EJB 3.0组件的远程客户端。
 * </pre>
 * 
 * @author http://www.open-v.com
 * @version 1.00.00
 * 
 *          <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 * </pre>
 */
public class BusinessExampleClient {

	private static final Log log = LogFactory
			.getLog(BusinessExampleClient.class);

	public static void main(String[] args) throws Exception {

		// jndiofb.xml、access.xml、remoteslsb.xml
		ListableBeanFactory lbf = new ClassPathXmlApplicationContext(
				"jndiofb.xml");
		IBusinessInterface se = (IBusinessInterface) lbf.getBean("sbe");
		log.info(se.getStr("worldheart"));

	}

}