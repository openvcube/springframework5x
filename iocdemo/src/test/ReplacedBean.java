package test;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.util.Assert;

/**
 * 实现MethodReplacer
 * 
 * @author worldheart
 *
 */
public class ReplacedBean implements MethodReplacer{
	
	//实现MethodReplacer定义的方法
	public Object reimplement(Object obj, Method method, Object[] args) 
		throws Throwable {
		Assert.notEmpty(args);
		return args[0] + ", haha!";
	}
	
}
