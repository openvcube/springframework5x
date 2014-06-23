package com.openv.book.springframework40.aop;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.util.Assert;

/**
 * 
 * <pre>
 * 证券帐号，领域对象
 * </pre>
 * @author luoshifei  luoshifei@yahoo.cn
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
@Configurable
public class SecurityAccount {
	
	private IBankSecurityService bankSecurityService;

//	public SecurityAccount() {
//		Assert.notNull(this.bankSecurityService);
//	}
	
	public void setBankSecurityService(IBankSecurityService bankSecurityService) {
		this.bankSecurityService = bankSecurityService;
	}

	public void toBank(Double money){
		this.bankSecurityService.securityToBank(money);
	}
	
	public void toSecurity(Double money){
		this.bankSecurityService.bankToSecurity(money);
	}
	
	private String accountId;
	
	private String accountPwd;
	
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountPwd() {
		return accountPwd;
	}

	public void setAccountPwd(String accountPwd) {
		this.accountPwd = accountPwd;
	}
		
}
