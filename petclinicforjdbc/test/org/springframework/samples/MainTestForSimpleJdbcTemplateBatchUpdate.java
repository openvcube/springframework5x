package org.springframework.samples;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

/**
 * 
 * @author worldheart
 *
 */
public class MainTestForSimpleJdbcTemplateBatchUpdate {

	private static final Log log = LogFactory.getLog(MainTestForSimpleJdbcTemplateBatchUpdate.class);
	
	public static void main(String[] args) {
		
		ListableBeanFactory cbf = new ClassPathXmlApplicationContext("simplejdbctemplate.xml");		
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(cbf);
		
		SimpleJdbcTemplate sjt = gbfa.getBean("simpleJdbcTemplate");
		
		List<Object[]> paramList = new ArrayList<Object[]>();
		paramList.add(new Integer[]{7369, 7369});
		paramList.add(new Integer[]{7499, 7499});
		paramList.add(new Integer[]{7521, 7521});
		paramList.add(new Integer[]{7566, 7566});
		paramList.add(new Integer[]{7654, 7654});
		paramList.add(new Integer[]{7698, 7698});
		
		sjt.batchUpdate("update emp set sal = ? where empno = ?", paramList);
		
		sjt.batchUpdate("update emp set sal = ? where empno = ?", paramList, new int[]{Types.INTEGER});

		SqlParameterSource[] spsArray = new SqlParameterSource[2];
		
		MapSqlParameterSource msps = new MapSqlParameterSource();
		msps.addValue("sal", 7369);
		msps.addValue("empno", 7369);
		
		spsArray[0] = msps;

		msps = new MapSqlParameterSource();
		msps.addValue("sal", 7499);
		msps.addValue("empno", 7499);
		
		spsArray[1] = msps;
		
		sjt.batchUpdate("update emp set sal = :sal where empno = :empno", spsArray);
		
	}

}