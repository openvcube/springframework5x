package test;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

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
public class HSQLJdbcDemoSpringVersion {

	private static final Log log = LogFactory
			.getLog(HSQLJdbcDemoSpringVersion.class);

	public static void main(String[] args) {
		ListableBeanFactory cbf = new ClassPathXmlApplicationContext("jdbc.xml");

		JdbcTemplate jt = (JdbcTemplate) cbf.getBean("jdbcTemplate");
		List rsList = jt.queryForList("select * from pets");

		for (Iterator iterator = rsList.iterator(); iterator.hasNext();) {
			log.info(iterator.next());
		}
	}

}
