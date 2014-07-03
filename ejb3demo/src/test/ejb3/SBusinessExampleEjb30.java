package test.ejb3;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;

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
@Stateless
@Remote(IBusinessInterface.class)
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class SBusinessExampleEjb30 implements IBusinessInterface {

	private static final Log log = LogFactory
			.getLog(SBusinessExampleEjb30.class);

	@Autowired
	private IBusinessInterface sbe;

	public String getStr(String args) {
		return sbe.getStr(args);
	}

}
