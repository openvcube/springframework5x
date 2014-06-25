/**
 * Copyright(c) http://www.open-v.com
 */
package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
public class MainTestAspectIntroduction {
	
	private static final Log log = LogFactory.getLog(MainTestAspectIntroduction.class);
	
	public static void main(String[] args) {
		log.info("MainTestAspectIntroduction main().........");
		
		DisPersonInfoIntroduction dpi = new DisPersonInfoIntroduction();
		
		IDisPersonInfoIntroduction idpi = (IDisPersonInfoIntroduction)dpi;
		
		idpi.compute("王二");
		idpi.compute("李三", 40);
	}
	
}
