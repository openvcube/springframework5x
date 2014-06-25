package test.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import test.pointcut.AnnotationParam;

/**
 * 
 * @author worldheart
 *
 */
@Aspect
public class LoggingAspect {
	
	private static final Log log = LogFactory.getLog(LoggingAspect.class);
	
	//within将连接点作用范围圈定在test.pointcut包中
	@Pointcut("within(test.pointcut.*)")
	public void with(){}

	//连接点对应的方法的返回值必须是void或java.lang.String
	@Pointcut("execution(public void || String test.pointcut..*(..))")
	public void service1(){}
	
	//连接点对应的方法的返回值必须是java.lang.String
	@Pointcut("execution(public String test.pointcut..*(..) throws RuntimeException)")
	public void service2(){}
	
	//service1()进行与运算
	@Before("service1() && with() && args(str) && target(obj) && this(proxy) ")
	public void before1Aspect(JoinPoint jp, String str, Object obj, Object proxy){
		log.info("before1Aspect......");
		log.info(jp);
		log.info(str);
		log.info(obj);
		log.info(proxy);
	}
	
	//service2()进行与运算
	@Before("service2() && with() && target(obj) && this(proxy) ")
	public void before2Aspect(JoinPoint jp, Object obj, Object proxy){
		log.info("before2Aspect......");
		log.info(jp);
		log.info(obj);
		log.info(proxy);
	}
	
	//@args表明，传入连接点的参数对应的类必须应用了@ForYou注解（类一级）
	@Before("service1() && with()  && args(ap) && target(obj) && this(proxy) && @args(test.pointcut.ForYou)")
	public void before3Aspect(JoinPoint jp, AnnotationParam ap, Object obj, Object proxy){
		log.info("before3Aspect......");
		log.info(jp);
		log.info(obj);
		log.info(proxy);
	}
	
	//@within表明，只有那些在类一级应用了@ForYou注解的类中的各方法才能够成为连接点候选
	@Before("service1() && with() && @within(test.pointcut.ForYou) && target(obj) && this(proxy)")
	public void before4Aspect(JoinPoint jp, Object obj, Object proxy){
		log.info("before4Aspect......");
		log.info(jp);
		log.info(obj);
		log.info(proxy);
	}
	
	//@annotation表明，被代理对象中的连接点（即目标方法）
	//必须应用了@ForYou注解（方法一级）
	@Before("service1() && with() && @annotation(test.pointcut.ForYou) && target(obj) && this(proxy)")
	public void before5Aspect(JoinPoint jp, Object obj, Object proxy){
		log.info("before5Aspect......");
		log.info(jp);
		log.info(obj);
		log.info(proxy);
	}
	
	//@target表明，被代理对象必须在类一级应用了@ForYou注解
	@Before("service1() && with() && @target(test.pointcut.ForYou) && target(obj) && this(proxy)")
	public void before6Aspect(JoinPoint jp, Object obj, Object proxy){
		log.info("before6Aspect......");
		log.info(jp);
		log.info(obj);
		log.info(proxy);
	}
	
	//PointInfo+表明，所有以PointInfo结尾的类及子类
	@Before("within(test.pointcut.*) && execution(* test..*PointInfo+.*(..) throws RuntimeException)")
	public void before7Aspect(JoinPoint jp){
		log.info("before7Aspect......");
		log.info(jp);
	}
		
	//service2()进行与运算，另外限定受管Bean的名字
	@Before("bean(classForPointInfo*) && service2()")
	public void before8Aspect(JoinPoint jp){
		log.info("before8Aspect......");
		log.info(jp);
	}

}