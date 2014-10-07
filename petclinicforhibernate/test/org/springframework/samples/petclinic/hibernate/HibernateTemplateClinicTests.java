package org.springframework.samples.petclinic.hibernate;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.Clinic;
import org.springframework.samples.petclinic.Owner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(inheritLocations=false,
	locations={"/org/springframework/samples/petclinic/hibernate/applicationContext-hibernate.xml"})
public class HibernateTemplateClinicTests extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	protected Clinic clinic;

	@Test
	public void insertOwnerVerson1() {
		Collection owners = this.clinic.findOwners("Schultz");
		int found = owners.size();
		Owner owner = new Owner();
		owner.setLastName("Schultz");
		this.clinic.storeOwnerSave(owner);
		//借助于findOwners查找Owner
		owners = this.clinic.findOwners("Schultz");
		assertEquals(found + 1, owners.size());
	}
	
	@Test
	public void insertOwnerVersion2() {
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

}
