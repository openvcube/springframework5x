package org.springframework.samples;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.samples.petclinic.Clinic;
import org.springframework.samples.petclinic.Owner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * 
 * @author worldheart
 *
 */
public class MainTestForCallbackPreferringPlatformTransactionManager {

	public static void main(String[] args) {		
		ListableBeanFactory cbf = new ClassPathXmlApplicationContext("tm.xml");		
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(cbf);
		
		Clinic clinic = gbfa.getBean("hsqlClinic");
		
		Owner owner = new Owner();

		owner.setAddress("XiDan");
		owner.setCity("Beijing");
		owner.setFirstName("FirstName");
		owner.setLastName("LastName");
		owner.setTelephone("888888");
		
		DefaultTransactionDefinition dtd = new DefaultTransactionDefinition();
		dtd.setTimeout(120);
		PlatformTransactionManager ptm = gbfa.getBean("transactionManager");
		TransactionStatus ts = ptm.getTransaction(dtd); 
		clinic.storeOwner(owner);
		ptm.commit(ts);
		
	}

}
