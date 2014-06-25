package test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;


/**
 * 实现了IResInfo接口
 * 
 * @author worldheart
 *
 */
public class ResInfo implements IResInfo {
	
	protected static final Log log = LogFactory.getLog(ResInfo.class);

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
