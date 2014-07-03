package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * <pre>
 * 程序的中文名称。
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
@Configuration
public class JavaConfigDemo {

	private static final Log log = LogFactory.getLog(JavaConfigDemo.class);

	@Bean
	public IHelloWorld helloWorld() {
		HelloWorld hw = new HelloWorld();
		hw.setHelloStr(helloStr());
		return hw;
	}

	@Bean
	public IHelloStr helloStr() {
		return new FileHelloStrImpl("helloworld.properties");
	}

	public static void main(String[] args) {
		// 从注解中装载DI容器配置元数据
		ApplicationContext context = new AnnotationConfigApplicationContext(
				JavaConfigDemo.class);

		// 获得受管Bean
		IHelloWorld hw = context.getBean(IHelloWorld.class);

		// 返回字符串
		log.info(hw.getContent());
	}

}
