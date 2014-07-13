package org.springframework.samples;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.samples.petclinic.Clinic;
import org.springframework.samples.petclinic.Owner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

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
public class MainTestForTransactionTemplate {

	private static final Log log = LogFactory.getLog(MainTestForTransactionTemplate.class);
	
	public static void main(String[] args) {		
		ListableBeanFactory cbf = new ClassPathXmlApplicationContext("tm.xml");		
		
		final Clinic clinic = (Clinic)cbf.getBean("clinicTarget");
		
		final TransactionTemplate tt = (TransactionTemplate)cbf.getBean("transactionTemplate");

		List<Owner> list = tt.execute(new TransactionCallback<List<Owner>>(){
			public List<Owner> doInTransaction(TransactionStatus status) {
				return (List<Owner>)clinic.findOwners("");
			}
		});
		
		for(Owner own: list){
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
