package org.springframework.samples;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.samples.petclinic.Clinic;
import org.springframework.samples.petclinic.Owner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

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
public class MainTestForCallbackPreferringPlatformTransactionManager {

	public static void main(String[] args) {		
		ListableBeanFactory cbf = new ClassPathXmlApplicationContext("tm.xml");		
		
		Clinic clinic = (Clinic)cbf.getBean("hsqlClinic");
		
		Owner owner = new Owner();

		owner.setAddress("XiDan");
		owner.setCity("Beijing");
		owner.setFirstName("FirstName");
		owner.setLastName("LastName");
		owner.setTelephone("888888");
		
		DefaultTransactionDefinition dtd = new DefaultTransactionDefinition();
		dtd.setTimeout(120);
		PlatformTransactionManager ptm = (PlatformTransactionManager)cbf.getBean("transactionManager");
		TransactionStatus ts = ptm.getTransaction(dtd); 
		clinic.storeOwner(owner);
		ptm.commit(ts);
		
	}

}
