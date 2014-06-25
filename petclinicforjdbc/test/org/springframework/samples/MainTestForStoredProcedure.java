package org.springframework.samples;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.object.StoredProcedure;

/**
 * 
 * @author worldheart
 * 
 */
public class MainTestForStoredProcedure {

	private static final Log log = LogFactory
			.getLog(MainTestForStoredProcedure.class);

	public static void main(String[] args) {
		ListableBeanFactory cbf = new ClassPathXmlApplicationContext(
				"jdbctemplate.xml");
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(cbf);

		JdbcTemplate jt = gbfa.getBean("jdbcTemplate");
		DataSource ds = gbfa.getBean("dataSource");

		log.info(jt.execute("{call show_sal(?, ?, ?)}",
				new CallableStatementCallback() {
					public Object doInCallableStatement(CallableStatement cs)
							throws SQLException, DataAccessException {
						cs.setString("enames", "SMITH");
						cs.setInt("empnos", 7369);
						cs.registerOutParameter("sals", Types.FLOAT);
						cs.execute();
						return cs.getFloat("sals");
					}
				}));

		log.info(jt.execute(new CallableStatementCreator() {
			public CallableStatement createCallableStatement(Connection con)
					throws SQLException {
				return con.prepareCall("{call show_sal(?, ?, ?)}");
			}
		}, new CallableStatementCallback() {
			public Object doInCallableStatement(CallableStatement cs)
					throws SQLException, DataAccessException {
				cs.setString("enames", "SMITH");
				cs.setInt("empnos", 7369);
				cs.registerOutParameter("sals", Types.FLOAT);
				cs.execute();
				return cs.getFloat("sals");
			}
		}));
		
		StoredProcedure sp = new ShowEmpStoredProcedure(ds);

		Map<String, Object> inputParam = new HashMap<String, Object>(2);
		inputParam.put("enames", "SMITH");
		inputParam.put("empnos", 7369);
		
		log.info(sp.execute(inputParam));

		SimpleJdbcCall sjc = new SimpleJdbcCall(ds);
		sjc.withProcedureName("show_sal");

		SqlParameterSource sps = new MapSqlParameterSource().addValue("enames",
				"SMITH").addValue("empnos", 7369);
		log.info(sjc.execute(sps));

		sjc = new SimpleJdbcCall(ds).withProcedureName("show_sal");
		sjc.declareParameters(new SqlParameter("enames", Types.VARCHAR))
			.declareParameters(new SqlParameter("empnos", Types.INTEGER))
			.declareParameters(new SqlOutParameter("sals", Types.FLOAT))
			.withoutProcedureColumnMetaDataAccess();

		sps = new MapSqlParameterSource().addValue("enames",
				"SMITH").addValue("empnos", 7369);
		log.info(sjc.execute(sps));
	
	}

}

class ShowEmpStoredProcedure extends StoredProcedure {

	public ShowEmpStoredProcedure(DataSource ds) {
		super(ds, "show_sal");
		declareParameter(new SqlParameter("enames", Types.VARCHAR));
		declareParameter(new SqlParameter("empnos", Types.INTEGER));
		declareParameter(new SqlOutParameter("sals", Types.FLOAT));
		compile();
	}

}