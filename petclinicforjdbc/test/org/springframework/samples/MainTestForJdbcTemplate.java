package org.springframework.samples;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.StatementCallback;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.samples.petclinic.Person;

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
public class MainTestForJdbcTemplate {

	private static final Log log = LogFactory.getLog(MainTestForJdbcTemplate.class);
	
	public static void main(String[] args) {		
		ListableBeanFactory cbf = new ClassPathXmlApplicationContext("jdbctemplate.xml");		
		
		JdbcTemplate jt = (JdbcTemplate)cbf.getBean("jdbcTemplate");
		
		jt.execute(new ConnectionCallback(){
			public Object doInConnection(Connection con) throws SQLException, DataAccessException {
				log.info(con.getMetaData().getDriverName());
				return null;
			}
		});
		
		List nameList = (List)jt.execute(new StatementCallback(){
			public Object doInStatement(Statement stmt) throws SQLException, DataAccessException {
				log.info(stmt.getConnection().getMetaData().getDatabaseProductVersion());
				List<String> nameList = new ArrayList<String>();
				ResultSet rs = null;
				try{
					rs = stmt.executeQuery("select name from types");
					while(rs.next()){
						nameList.add(rs.getString("name"));
					}
				}finally{
					JdbcUtils.closeResultSet(rs);
				}
				return nameList;
			}
		});
		log.info(nameList);
		
		List perList = (List)jt.query("select * from vets", 
				new ResultSetExtractor(){
						public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
							List<Person> personList = new ArrayList<Person>();
							while(rs.next()){
								Person per = new Person();
								per.setId(rs.getInt("id"));
								per.setFirstName(rs.getString("first_name"));
								per.setLastName(rs.getString("last_name"));
								personList.add(per);
							}
							return personList;
				}
		});
		for(Iterator iterator = perList.iterator(); iterator.hasNext();){
			Person person = (Person)iterator.next();
			log.info(person.getId() + "," + person.getFirstName() + "," + person.getLastName());
		}

		final List<Person> pSonList = new ArrayList<Person>(); 
		jt.query("select * from vets", new RowCallbackHandler(){
			public void processRow(ResultSet rs) throws SQLException {
				Person per = new Person();
				per.setId(rs.getInt("id"));
				per.setFirstName(rs.getString("first_name"));
				per.setLastName(rs.getString("last_name"));
				pSonList.add(per);
			}
		});
		for(Person pSon: pSonList){
			log.info(pSon.getId() + "," + pSon.getFirstName() + "," + pSon.getLastName());
		}
		
		RowCountCallbackHandler rcch = new RowCountCallbackHandler();
		jt.query("select * from vets", rcch);
		for(String colName: rcch.getColumnNames())
			log.info(colName);
		for(int colType: rcch.getColumnTypes())
			log.info(colType); 
		log.info(rcch.getColumnCount()); 
		log.info(rcch.getRowCount()); 
		
		List vetsList = jt.query("select * from vets", 
				new RowMapper(){
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
						Person pers = new Person();
						pers.setId(rs.getInt("id"));
						pers.setFirstName(rs.getString("first_name"));
						pers.setLastName(rs.getString("last_name"));
						return pers;
					}
		});
		log.info(vetsList);
		
		ColumnMapRowMapper cmrw = new ColumnMapRowMapper(); 
		List vList = jt.query("select * from vets", cmrw);
		log.info(vList);

		SingleColumnRowMapper scrm = new SingleColumnRowMapper();
		List firstNameList = jt.query("select first_name from vets", scrm);
		log.info(firstNameList);
		
		BeanPropertyRowMapper bprm = new BeanPropertyRowMapper(Person.class);
		List personList = jt.query("select * from vets", bprm);
		log.info(personList);
		
		log.info(jt.queryForInt("select count(*) from vets where id = ?", 
				new Object[]{3}));
						
		jt.execute("update owners set address = 'GuangZhou' where telephone = ?", 
				new PreparedStatementCallback(){
					public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
						ps.setString(1, "16068008");
						ps.addBatch();
						ps.setString(1, "6085555487");
						ps.addBatch();
						return ps.executeBatch();
					}
		});
		
		log.info(jt.query("select address from owners where first_name = ? and last_name = ?",
				new PreparedStatementSetter(){
					public void setValues(PreparedStatement ps) throws SQLException {
						ps.setString(1, "Jeff");
						ps.setString(2, "Black");
					}
				}, 
				new RowMapper(){
					public Object mapRow(ResultSet rs, int rowNum) throws SQLException {						
						return rs.getString("address");
					}
				}));
		
		log.info(jt.execute(
				new PreparedStatementCreator(){
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						return con.prepareStatement("select address from owners");
					}
				}, 
				new PreparedStatementCallback(){
					public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
						List<String> list = new ArrayList<String>();
						ResultSet rs = null;
						try{
							rs = ps.executeQuery();
							while(rs.next()){
								list.add(rs.getString("address"));
							}
						}finally{
							JdbcUtils.closeResultSet(rs);
						}
						return list;
					}
				}));

		IDaoSupport ds = (IDaoSupport)cbf.getBean("jdbcDaoSupport");
		ds.operationAll();		
	}

}
