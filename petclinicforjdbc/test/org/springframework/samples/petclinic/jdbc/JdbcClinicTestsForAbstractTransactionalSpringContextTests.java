package org.springframework.samples.petclinic.jdbc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.samples.petclinic.Clinic;
import org.springframework.samples.petclinic.Pet;
import org.springframework.test.AbstractTransactionalSpringContextTests;

/**
 * 
 * @author worldheart
 * 
 */
public class JdbcClinicTestsForAbstractTransactionalSpringContextTests extends
		AbstractTransactionalSpringContextTests {

	protected static final Log log = LogFactory
			.getLog(JdbcClinicTestsForAbstractTransactionalSpringContextTests.class);

	private Clinic clinic;

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
	
	public void testXxx() {		
		Pet p7 = this.clinic.loadPet(7);
		String old = p7.getName();
		p7.setName(old + "X");
		this.clinic.storePet(p7);		
		p7 = this.clinic.loadPet(7);
		assertEquals(old + "X", p7.getName());
	}

	protected String[] getConfigLocations() {
		return new String[] { "/org/springframework/samples/petclinic/jdbc/applicationContext-jdbc.xml" };
	}

}
