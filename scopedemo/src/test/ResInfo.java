package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;

/**
 * 
 * <pre>
 * 实现了IResInfo接口。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class ResInfo implements IResInfo {
	
	private static final Log log = LogFactory.getLog(ResInfo.class);

	private Resource resClass;
	
	private Resource resFile;
	
	public ResInfo(){
		log.info("构建新的ResInfo实例");
	}
	
	public Resource getResClass() {
		return resClass;
	}

	public void setResClass(Resource resClass) {
		this.resClass = resClass;
	}

	public Resource getResFile() {
		return resFile;
	}

	public void setResFile(Resource resFile) {
		this.resFile = resFile;
	}

}
