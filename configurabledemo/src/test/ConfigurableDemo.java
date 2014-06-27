package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * <pre>
 * 演示@Configurable注解的使用。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class ConfigurableDemo{

	protected static final Log log = LogFactory.getLog(ConfigurableDemo.class);

	public static void main(String[] args) {
		
		//启用Spring DI，并完成AspectJ 8切面的配置工作，比如将IoC容器暴露给切面
		new ClassPathXmlApplicationContext("config.xml");
				
		log.info("即将构建领域对象");
		
		//很多时候，Hibernate/JPA/应用代码会负责创建领域对象
		ConfiguredBySpringDI springDI = new ConfiguredBySpringDI();

		ConfiguredBySpringDI springDI1 = new ConfiguredBySpringDI();

		log.info("AspectJ 8已经完成了领域对象的配置工作");
		
		// 我们并没有显式设置springDI的协作者，但infoBean确实不再是null
		log.info(springDI.getInfoBean().getUserName());
		log.info(springDI.getInfoBean().getPassword());
		
	}
	
}

