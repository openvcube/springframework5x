package com.openv.book.springframework40.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
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
public class ApplicationContextDemo {

	public static void main(String[] args) {		
		//从classpath路径上装载XML配置信息
		ApplicationContext applicationContext = 
			new ClassPathXmlApplicationContext("applicationcontext.xml");
		
		//获得受管Bean
		IBankSecurityService bankSecurityService = 
			applicationContext.getBean(IBankSecurityService.class);
		
		bankSecurityService.bankToSecurity(2000.00);
		bankSecurityService.securityToBank(2000.00);
	}

}
