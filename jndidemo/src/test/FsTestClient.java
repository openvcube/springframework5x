package test;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * <pre>
 * File System示例使用。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class FsTestClient {

	private static final Log log = LogFactory.getLog(FsTestClient.class);

	public static void main(String[] args) {
		
		Hashtable<String, String> env = new Hashtable<String, String>(2);
		
		//设定上下文工厂
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.fscontext.RefFSContextFactory");
		
		//设置文件系统路径
		env.put(Context.PROVIDER_URL, "file:d://sts-bundle//workspace//springframework40");
		
		Context initCtx = null;
		try {
			//获得初始化上下文
			initCtx = new InitialContext(env);
			
			//借助于JNDI，查找文件
			Object fc = initCtx.lookup("README.md");
						
			log.info(fc);
		} catch (NamingException ne) {
			//处理命名异常
			log.error("", ne);
		} finally {
			try {
				//关闭上下文
				initCtx.close();
			} catch (NamingException ne) {
				;
			}
		}

	}

}
