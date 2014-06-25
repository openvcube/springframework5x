package org.springframework.samples.petclinic.jdbc;

import static org.junit.Assert.assertNotNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.Clinic;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * 
 * @author worldheart
 *
 */
@ContextConfiguration
public class SimpleJdbcClinicForAbstractJUnit4SpringContextTests 
	extends AbstractJUnit4SpringContextTests{

	protected static final Log log = LogFactory.getLog(
			SimpleJdbcClinicForAbstractJUnit4SpringContextTests.class);
	
	@Autowired
	private Clinic clinic;
	
	@Test
	public void testXxx() {
		assertNotNull(this.clinic);		
		log.info(this.clinic);
	}

}
