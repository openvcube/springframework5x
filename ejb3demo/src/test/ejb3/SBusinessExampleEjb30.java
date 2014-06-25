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
 * @author worldheart
 * 
 */
@Stateless
@Remote(IBusinessInterface.class)
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class SBusinessExampleEjb30 implements IBusinessInterface {

	protected static final Log log = LogFactory
			.getLog(SBusinessExampleEjb30.class);

	@Autowired
	private IBusinessInterface sbe;

	public String getStr(String args) {
		return sbe.getStr(args);
	}

}