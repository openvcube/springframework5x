package com.openv.book.springframework40.ioc;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


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
public class BankSecurityServiceImpl implements IBankSecurityService {

	private IBankSecurityDao abcBankSecurityDao;

	private IBankSecurityDao cmbBankSecurityDao;
	
	private IBankSecurityDao bankSecurityDao;
	
	@Autowired
	private void init(@Qualifier("abc") IBankSecurityDao abcBankSecurityDao, @Qualifier("cmb") IBankSecurityDao cmbBankSecurityDao, 
			IBankSecurityDao bankSecurityDao){
		this.abcBankSecurityDao = abcBankSecurityDao;
		this.cmbBankSecurityDao = cmbBankSecurityDao;
		this.bankSecurityDao = bankSecurityDao;
	}
	
	private Properties properties;	
	
	public BankSecurityServiceImpl() {
	}

	public BankSecurityServiceImpl(IBankSecurityDao bankSecurityDao) {
		this.bankSecurityDao = bankSecurityDao;
	}

	public BankSecurityServiceImpl(IBankSecurityDao bankSecurityDao, Properties properties) {
		this.bankSecurityDao = bankSecurityDao;
		this.properties = properties;
	}
	
	public void setBankSecurityDao(IBankSecurityDao bankSecurityDao) {
		this.bankSecurityDao = bankSecurityDao;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	public void bankToSecurity(Double money){
		this.bankSecurityDao.bankToSecurity(money);
	}
	
	public void securityToBank(Double money){
		this.bankSecurityDao.securityToBank(money);
	}

}

