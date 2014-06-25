package test;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.util.Assert;

/**
 * 
 * <pre>
 * 实现MethodReplacer。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class ReplacedBean implements MethodReplacer{
	
	//实现MethodReplacer定义的方法
	public Object reimplement(Object obj, Method method, Object[] args) 
		throws Throwable {
		Assert.notEmpty(args);
		return args[0] + ", haha!";
	}
	
}
