/**
 * 
 */
package test;

import javax.naming.Context;
import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jndi.JndiCallback;
import org.springframework.jndi.JndiTemplate;

/**
 * 
 * <pre>
 * 演示JndiObjectFactoryBean的使用。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class JndiTemplateDemo {

	private static final Log log = LogFactory.getLog(JndiTemplateDemo.class);
	
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("jnditemplate.xml");
		
		//获得JndiTemplate
		JndiTemplate jt = (JndiTemplate)ac.getBean("jndiTemplate");

		String jndiTemplateStr = new String("jndiTemplate");
		final String jndiCallbackStr = new String("jndiCallbackStr");
		
		try{
			//将对象绑定到JNDI树上
			jt.bind("jndiTemplate",jndiTemplateStr);
			//打印出查找结果
			log.info(jt.lookup("jndiTemplate"));
			//从JNDI树上去除对象的绑定
			jt.unbind("jndiTemplate");
			
			jt.execute(new JndiCallback(){
				public Object doInContext(Context ctx) throws NamingException {
					ctx.bind("jndiCallback", jndiCallbackStr);
					log.info(ctx.lookup("jndiCallback"));
					ctx.unbind("jndiCallback");			
					return null;
				}				
			});
		} catch(NamingException ne){
			log.error("", ne);
		}
		
	}

}
