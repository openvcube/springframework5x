package test;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
public class SessionContent implements ISessionContent {

	private final static Log log = LogFactory.getLog(SessionContent.class);
	
	private INameList nameList;
	
	private IValueList valueList;

	public SessionContent(){
		log.info("构建新的SessionContent()实例");
	}	
	
	public void processSessionContent(Map map) {
		this.nameList.getNameList().clear();
		this.valueList.getValueList().clear();
		
		Set set = map.keySet();
		Iterator iterator = set.iterator();
		if(!set.isEmpty()){
			while(iterator.hasNext()){
				String sessionKey = (String)iterator.next();
				this.nameList.getNameList().add(sessionKey);
				this.valueList.getValueList().add((String)map.get(sessionKey));
			}
			log.info(nameList);
			log.info(valueList);
		}
		
	}
	
	public void setNameList(INameList nameList) {
		this.nameList = nameList;
	}
	
	public void setValueList(IValueList valueList) {
		this.valueList = valueList;
	}

}
