package org.springframework.samples.petclinic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * JUnit test for the {@link Owner} class.
 *
 * @author Ken Krebs
 */
public class OwnerTests {

	private static final Log log = LogFactory.getLog(OwnerTests.class);
	
	@Test
	public void testHasPet() {
		Owner owner = new Owner();
		Pet fido = new Pet();
		fido.setName("Fido");
		assertNull(owner.getPet("Fido"));
		assertNull(owner.getPet("fido"));
		owner.addPet(fido);
		assertEquals(fido, owner.getPet("Fido"));
		assertEquals(fido, owner.getPet("fido"));
	}
	
	@Test
	public void test() throws Exception{
		Owner owner = new Owner();
		ReflectionTestUtils.setField(owner, "address", 
					"GuangZhou1", String.class);
		log.info(owner.getAddress());
		log.info(ReflectionTestUtils.getField(owner, "address"));
		//可以将address替换成getAddress
		log.info(ReflectionTestUtils.invokeGetterMethod(owner, "address"));
		log.info(ReflectionTestUtils.invokeMethod(owner, "getAddress"));
		//可以将address替换成setAddress
		ReflectionTestUtils.invokeSetterMethod(owner, "address", 
					"GuangZhou2", String.class);
		log.info(owner.getAddress());
		
	}

}
