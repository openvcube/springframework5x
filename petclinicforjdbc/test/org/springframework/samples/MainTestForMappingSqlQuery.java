package org.springframework.samples;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.samples.petclinic.Visit;

/**
 * 
 * @author worldheart
 * 
 */
public class MainTestForMappingSqlQuery {
	
	private static final Log log = LogFactory.getLog(MainTestForMappingSqlQuery.class);

	public static void main(String[] args) {
		
		ListableBeanFactory cbf = new ClassPathXmlApplicationContext("jdbctemplate.xml");		
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(cbf);
		
		DataSource ds = gbfa.getBean("dataSource");
	
		MappingSqlQuery msq = new VisitsQuery(ds);
		
		List visits = msq.execute(7);
		Iterator vi = visits.iterator();

		while (vi.hasNext()) {
			Visit visit = (Visit) vi.next();
			log.info(visit.getDescription());
		}
		
	}
	
}

class VisitsQuery extends MappingSqlQuery {
	protected VisitsQuery(DataSource ds) {
		super(ds, "SELECT id,visit_date,description FROM visits WHERE pet_id=?");
		declareParameter(new SqlParameter(Types.INTEGER));
		compile();
	}

	protected Object mapRow(ResultSet rs, int rownum) throws SQLException {
		Visit visit = new Visit();
		visit.setId(new Integer(rs.getInt("id")));
		visit.setDate(rs.getDate("visit_date"));
		visit.setDescription(rs.getString("description"));
		return visit;
	}
}
