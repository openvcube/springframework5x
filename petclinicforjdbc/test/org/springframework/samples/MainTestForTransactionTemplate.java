package org.springframework.samples;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.generic.GenericBeanFactoryAccessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.samples.petclinic.Clinic;
import org.springframework.samples.petclinic.Owner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 
 * @author worldheart
 *
 */
public class MainTestForTransactionTemplate {

	private static final Log log = LogFactory.getLog(MainTestForTransactionTemplate.class);
	
	public static void main(String[] args) {		
		ListableBeanFactory cbf = new ClassPathXmlApplicationContext("tm.xml");		
		GenericBeanFactoryAccessor gbfa = new GenericBeanFactoryAccessor(cbf);		
		
		final Clinic clinic = gbfa.getBean("clinicTarget");
		
		final TransactionTemplate tt = gbfa.getBean("transactionTemplate");		

		List list = (List)tt.execute(new TransactionCallback(){
			public Object doInTransaction(TransactionStatus status) {				
				return clinic.findOwners("");
			}
		});
		
		for(Object owner: list){
			Owner own = (Owner)owner;
			log.info(own.getId() + "," + own.getFirstName() + "," + own.getLastName());
		}
		
		final Owner owner = new Owner();

		owner.setAddress("XiDan");
		owner.setCity("Beijing");
		owner.setFirstName("FirstName");
		owner.setLastName("LastName");
		owner.setTelephone("888888");
		
		//tt.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		
		tt.execute(new TransactionCallbackWithoutResult(){
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				clinic.storeOwner(owner);
			}
		});
		
	}

}
