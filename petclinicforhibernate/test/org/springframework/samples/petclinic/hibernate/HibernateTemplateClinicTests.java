package org.springframework.samples.petclinic.hibernate;

import java.util.Collection;

import org.springframework.samples.petclinic.Clinic;
import org.springframework.samples.petclinic.Owner;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

/**
 * 
 * @author worldheart
 *
 */
public class HibernateTemplateClinicTests extends AbstractTransactionalDataSourceSpringContextTests {

	protected Clinic clinic;

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

//	public void testInsertOwnerVerson1() {
//		Collection owners = this.clinic.findOwners("Schultz");
//		int found = owners.size();
//		Owner owner = new Owner();
//		owner.setLastName("Schultz");
//		this.clinic.storeOwnerSave(owner);
//		//ΩË÷˙”⁄findOwners≤È’“Owner
//		owners = this.clinic.findOwners("Schultz");
//		assertEquals(found + 1, owners.size());
//	}
	
	public void testInsertOwnerVersion2() {
		this.deleteFromTables(new String[]{"visits","pets","owners"});
		Owner owner = new Owner();
		owner.setLastName("Schultz1");
		this.clinic.storeOwnerSave(owner);
		assertEquals(1, this.jdbcTemplate.queryForInt("select count(*) from owners where city = 'gz'"));
//		owner = new Owner();
//		owner.setLastName("Schultz2");
//		this.clinic.storeOwnerSave(owner);
//		assertEquals(2, this.jdbcTemplate.queryForInt("select count(*) from owners where city = 'gz'"));
//		owner = new Owner();
//		owner.setLastName("Schultz3");
//		this.clinic.storeOwnerSave(owner);
//		assertEquals(3, this.jdbcTemplate.queryForInt("select count(*) from owners where city = 'gz'"));
	}

	protected String[] getConfigLocations() {
		return new String[] { "/org/springframework/samples/petclinic/hibernate/applicationContext-hibernate.xml" };
	}

}
