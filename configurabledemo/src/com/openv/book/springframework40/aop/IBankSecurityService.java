package com.openv.book.springframework40.aop;

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
public interface IBankSecurityService {

	public abstract void bankToSecurity(Double money);

	public abstract void securityToBank(Double money);

}