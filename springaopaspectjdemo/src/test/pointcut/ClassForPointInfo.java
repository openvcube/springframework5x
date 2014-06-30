package test.pointcut;

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
@ForYou
public class ClassForPointInfo {

	private static final Log log = LogFactory.getLog(ClassForPointInfo.class);
		
	public String getInfo1(){
		return "getInfo1()";
	}
	
	public String getInfo1(String str){
		return "getInfo1(String str)";
	}
	
	public String getInfo1(String str, int i) throws RuntimeException{
		return "getInfo1(String str, int i) throws RuntimeException";
	}
	
	public void setInfo2(AnnotationParam ap){
		log.info(ap);
	}
	
	@ForYou
	public void setInfo3(){
		;
	}
	
}
