package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.config.java.annotation.Bean;
import org.springframework.config.java.annotation.Configuration;
import org.springframework.config.java.context.JavaConfigApplicationContext;

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
@Configuration
public class JavaConfigDemo {

	private static final Log log = 
		LogFactory.getLog(JavaConfigDemo.class);

	@Bean
	public IHelloWorld helloWorld(){
		HelloWorld hw = new HelloWorld();
		hw.setHelloStr(helloStr());
		return hw;
	}
	
	@Bean
	public IHelloStr helloStr(){
		return new FileHelloStrImpl("helloworld.properties");
	}
	
	public static void main(String[] args) {
		//从注解中装载DI容器配置元数据
		JavaConfigApplicationContext context = 
				new JavaConfigApplicationContext(JavaConfigDemo.class);
		
		//获得受管Bean
		IHelloWorld hw = context.getBean(IHelloWorld.class);

		//返回字符串
		log.info(hw.getContent());
	}

}