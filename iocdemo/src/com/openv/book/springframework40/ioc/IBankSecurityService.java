package com.openv.book.springframework40.ioc;

/**
 * <pre>
 * 银行券商服务层
 * </pre>
 * @author openvcube  openvcube@open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public interface IBankSecurityService {

	public abstract void bankToSecurity(Double money);

	public abstract void securityToBank(Double money);
	
}
