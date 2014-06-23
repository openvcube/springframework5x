package com.openv.book.springframework40.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * <pre>
 * 银行券商间转帐服务
 * </pre>
 * @author luoshifei  luoshifei@yahoo.cn
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class BankSecurityServiceImpl implements IBankSecurityService {

	private static final Log log = LogFactory.getLog(BankSecurityServiceImpl.class);
	
	public void bankToSecurity(Double money){
		log.info("即将从银行转入" + money + "元到券商");
	}
	
	public void securityToBank(Double money){
		log.info("即将从券商转出" + money + "元到银行");
	}

}
