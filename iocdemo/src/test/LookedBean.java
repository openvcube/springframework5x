package test;

/**
 * 
 * <pre>
 * 查找的目标Bean。
 * </pre>
 * @author http://www.open-v.com
 * @version 1.00.00
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容: 
 * </pre>
 */
public class LookedBean{
	
	private Long time;
	
	public Long getTime() {
		return time;
	}
	
	public void setTime(Long time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return super.toString() + time;
	}
		
}
