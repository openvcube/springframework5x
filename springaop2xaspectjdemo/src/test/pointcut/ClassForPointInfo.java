package test.pointcut;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author worldheart
 *
 */
@ForYou
public class ClassForPointInfo {

	protected static final Log log = LogFactory.getLog(ClassForPointInfo.class);
		
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
