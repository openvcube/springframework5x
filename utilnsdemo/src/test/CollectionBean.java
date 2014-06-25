package test;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 
 * @author worldheart
 *
 */
public class CollectionBean {

	private List list;
	
	private Set set;
	
	private Map map;
	
	private Map<String, Double> mapTyped;
	
	private Properties properties;

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}
	
	public Map<String, Double> getMapTyped() {
		return mapTyped;
	}
	
	public void setMapTyped(Map<String, Double> mapTyped) {
		this.mapTyped = mapTyped;
	}
	
}
