package com.openv.book.springframework40.ioc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <pre>
 * 程序的中文名称
 * </pre>
 * @author openvcube  openvcube@open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class BankSecurityDaoImpl implements IBankSecurityDao {

	private static final Log log = LogFactory.getLog(BankSecurityDaoImpl.class);
	
	public void bankToSecurity(Double money){
		log.info("即将从银行转入" + money + "元到券商");
	}
	
	public void securityToBank(Double money){
		log.info("即将从券商转出" + money + "元到银行");
	}

}
