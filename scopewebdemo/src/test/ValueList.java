package test;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author worldheart
 *
 */
public class ValueList implements IValueList {

	protected final static Log log = LogFactory.getLog(ValueList.class);
	
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
