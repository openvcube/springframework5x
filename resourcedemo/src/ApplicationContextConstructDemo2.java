
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * <pre>
 * 构建ApplicationContext。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class ApplicationContextConstructDemo2 {

	private static final Log log = LogFactory
			.getLog(ApplicationContextConstructDemo2.class);

	public static void main(String[] args) {

		// 在classpath路径上查找以resource开头的所有XML配置文件（相对当前应用）
		ApplicationContext ac1 = new ClassPathXmlApplicationContext(
				"classpath:**/resource*.xml");

		// 在classpath路径上查找所有resource1.xml配置文件（相对当前应用）
		ApplicationContext ac2 = new ClassPathXmlApplicationContext(
				"classpath*:**/resource1.xml");

		// 指定多个XML配置文件
		ApplicationContext ac3 = new ClassPathXmlApplicationContext(
				new String[] { "resource1.xml", "test/resource2.xml" });

	}

}
