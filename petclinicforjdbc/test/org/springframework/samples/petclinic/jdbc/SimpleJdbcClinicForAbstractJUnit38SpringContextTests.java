package org.springframework.samples.petclinic.jdbc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.Clinic;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

/**
 * 
 * @author worldheart
 *
 */
@ContextConfiguration
public class SimpleJdbcClinicForAbstractJUnit38SpringContextTests 
	extends AbstractJUnit38SpringContextTests{

	protected static final Log log = LogFactory.getLog(
			SimpleJdbcClinicForAbstractJUnit38SpringContextTests.class);
	
	@Autowired
	private Clinic clinic;
	
	public void testXxx() {
		assertNotNull(this.clinic);		
		log.info(this.clinic);
	}

}
