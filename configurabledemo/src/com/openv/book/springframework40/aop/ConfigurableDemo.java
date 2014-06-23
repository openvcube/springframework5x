package com.openv.book.springframework40.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * <pre>
 * 演示Configurable注解的使用
 * </pre>
 * @author luoshifei  luoshifei@yahoo.cn
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class ConfigurableDemo{

	protected static final Log log = LogFactory.getLog(ConfigurableDemo.class);

	public static void main(String[] args) {
		
		//启用Spring DI，并完成AspectJ切面的配置工作，比如将IoC容器暴露给切面
		new ClassPathXmlApplicationContext("config.xml");
				
		log.info("即将构建领域对象");
		
		//很多时候，Hibernate/JPA/应用代码会负责创建领域对象
		SecurityAccount securityAccount = new SecurityAccount();
		
		log.info("AspectJ已经完成了领域对象的配置工作");
		
		//没有显式设置securityAccount领域对象的协作者，但IBankSecurityService服务确实不再是null
		securityAccount.toBank(10000.00);
		securityAccount.toSecurity(10000.00);
		
	}
	
}
