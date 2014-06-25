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
public class MainTestAspectAround {
	
	private static final Log log = LogFactory.getLog(MainTestAspectAround.class);
	
	public static void main(String[] args) {
		log.info("MainTestAspectAround main().........");
		
		DisPersonInfoAround dpi = new DisPersonInfoAround();
		
		dpi.compute("王二");
	}
	
}
