package test;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 
 * @author worldheart
 * 
 */
public class HSQLJdbcDemoSpringVersion {

	private static final Log log = LogFactory
			.getLog(HSQLJdbcDemoSpringVersion.class);

	public static void main(String[] args) {
		ListableBeanFactory cbf = new ClassPathXmlApplicationContext("jdbc.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(cbf);

		JdbcTemplate jt = gbfa.getBean("jdbcTemplate");
		List rsList = jt.queryForList("select * from pets");

		for (Iterator iterator = rsList.iterator(); iterator.hasNext();) {
			log.info(iterator.next());
		}
	}

}
