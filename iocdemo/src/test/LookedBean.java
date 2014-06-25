package test;

/**
 * 查找的目标Bean
 * 
 * @author worldheart
 *
 */
public class LookedBean {
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
