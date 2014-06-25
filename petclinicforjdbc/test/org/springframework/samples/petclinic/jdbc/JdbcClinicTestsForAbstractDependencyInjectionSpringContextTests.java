package org.springframework.samples.petclinic.jdbc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.samples.petclinic.Clinic;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

/**
 * 
 * @author worldheart
 *
 */
public class JdbcClinicTestsForAbstractDependencyInjectionSpringContextTests 
	extends AbstractDependencyInjectionSpringContextTests{

	protected static final Log log = LogFactory.getLog(
			JdbcClinicTestsForAbstractDependencyInjectionSpringContextTests.class);
	
	private Clinic clinic;
	
	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public void testXxx() {
		assertNotNull(this.clinic);
		log.info(this.clinic);
	}

	protected String[] getConfigLocations() {
		return new String[] { "/org/springframework/samples/petclinic/jdbc/applicationContext-jdbc.xml" };
	}

}
