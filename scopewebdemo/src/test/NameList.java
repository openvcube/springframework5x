package test;

import java.util.ArrayList;
import java.util.List;

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
public class NameList implements INameList {
	
	protected final static Log log = LogFactory.getLog(NameList.class);

	private List<String> nameList = new ArrayList<String>();

	public NameList(){
		log.info("构建新的NameList()实例");
	}
	
	public List<String> getNameList() {
		return nameList;
	}
	
	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

	@Override
	public String toString() {		
		return this.nameList.toString();
	}
	
}
