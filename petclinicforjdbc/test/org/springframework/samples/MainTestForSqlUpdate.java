package org.springframework.samples;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.samples.petclinic.Pet;
import org.springframework.samples.petclinic.Visit;

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
public class MainTestForSqlUpdate {

	public static void main(String[] args) {
		
		ListableBeanFactory cbf = new ClassPathXmlApplicationContext("jdbctemplate.xml");		
		
		DataSource ds = (DataSource)cbf.getBean("dataSource");
		
		Pet pet = new Pet();
		pet.setId(7);
		Visit visit = new Visit();
		visit.setDescription("lsf");
		visit.setPet(pet);
		//将数据源传入到构建器中
		VisitInsert vi = new VisitInsert(ds);
		vi.insert(visit);
		
	}
	
}

class VisitInsert extends SqlUpdate {
	protected VisitInsert(DataSource ds) {
		super(ds, "INSERT INTO visits VALUES(?,?,?,?)");
		declareParameter(new SqlParameter(Types.INTEGER));
		declareParameter(new SqlParameter(Types.INTEGER));
		declareParameter(new SqlParameter(Types.DATE));
		declareParameter(new SqlParameter(Types.VARCHAR));
		compile();
	}

	protected void insert(Visit visit) {
		super.update(new Object[] { null, visit.getPet().getId(),
				new java.sql.Date(visit.getDate().getTime()),
				visit.getDescription() });
	}
}
