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
public class ValueList implements IValueList {

	private static final Log log = LogFactory.getLog(ValueList.class);
	
	private List<String> valueList = new ArrayList<String>();
	
	public ValueList(){
		log.info("构建新的ValueList()实例");
	}
	
	public List<String> getValueList() {
		return valueList;
	}
	
	public void setValueList(List<String> valueList) {
		this.valueList = valueList;
	}
	
	@Override
	public String toString() {		
		return this.valueList.toString();
	}
	
}
