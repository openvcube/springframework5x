package test;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * ISessionContent µœ÷
 * 
 * @author worldheart
 * 
 */
public class SessionProcess implements ISessionProcess {

	public void processSessionContent(HttpSession hs) {
		if (hs == null)
			return;
		ServletContext sc = hs.getServletContext();
		ApplicationContext ac = WebApplicationContextUtils
				.getRequiredWebApplicationContext(sc);

		ISessionContent sessionContent = (ISessionContent) ac
				.getBean("sessionContent");

		Enumeration enumer = hs.getAttributeNames();

		Map<String, String> map = new HashMap<String, String>();

		while (enumer.hasMoreElements()) {
			String name = (String) enumer.nextElement();
			if(name.indexOf("scopedTarget.nameList") == -1 && name.indexOf("scopedTarget.valueList") == -1
					&& name.indexOf("sessionProcess") == -1)
				map.put(name, (String) hs.getAttribute(name));
		}

		sessionContent.processSessionContent(map);

	}

}
