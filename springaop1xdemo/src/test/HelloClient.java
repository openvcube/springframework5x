package test;

import org.aopalliance.aop.Advice;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;

/**
 * 
 * @author worldheart
 *
 */
public class HelloClient {
	
    private static final Log log = LogFactory.getLog(HelloClient.class);

    public static void main(String[] args) {    	
        //创建ProxyFactory，从而不需要借助Spring IoC容器提供控制反转功能
        ProxyFactory factory = new ProxyFactory(new HelloWorld());
    	    	
        //创建LoggingAroundAdvice装备
        Advice advice = new LoggingAroundAdvice();        
        
        //创建Advisor对象
        RegexpMethodPointcutAdvisor advisor = new RegexpMethodPointcutAdvisor();
        advisor.setAdvice(advice);
        advisor.setPatterns(new String[]{".*"});
        
        factory.addAdvisor(advisor);

        //调用业务操作
        IHelloWorld hw = (IHelloWorld) factory.getProxy();
        log.info(hw.getContent("worldheart"));        
    }

}
