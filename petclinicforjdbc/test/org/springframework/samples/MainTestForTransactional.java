package org.springframework.samples;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.samples.petclinic.Clinic;
import org.springframework.samples.petclinic.Owner;

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
public class MainTestForTransactional {

	private static final Log log = LogFactory.getLog(MainTestForTransactional.class);
	
	public static void main(String[] args) {		
		ListableBeanFactory cbf = new ClassPathXmlApplicationContext("transactional.xml");		
		
		final Clinic clinic = (Clinic)cbf.getBean("clinic");
		
		final Owner owner = new Owner();

		owner.setAddress("XiDan");
		owner.setCity("Beijing");
		owner.setFirstName("FirstName");
		owner.setLastName("LastName");
		owner.setTelephone("888888");

		clinic.storeOwner(owner);
	}

}
