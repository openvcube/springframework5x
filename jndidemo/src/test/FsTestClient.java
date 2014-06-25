/**
 * 
 */
package test;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * File System示例使用
 * 
 * @author worldheart
 * 
 */
public class FsTestClient {

	protected static final Log log = LogFactory.getLog(FsTestClient.class);

	public static void main(String[] args) {
		
		Hashtable<String, String> env = new Hashtable<String, String>(2);
		
		//设定上下文工厂
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.fscontext.RefFSContextFactory");
		
		//设置文件系统路径(注意，开发者需要依据自身的机器修改"file:d://eclipse")
		env.put(Context.PROVIDER_URL, "file:d://eclipse");
		
		Context initCtx = null;
		try {
			//获得初始化上下文
			initCtx = new InitialContext(env);
			
			//借助于JNDI，查找文件
			Object fc = initCtx.lookup("eclipse.ini");
						
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
