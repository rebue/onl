package rebue.onl.to;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class SelectOnlineTo {
	
	/**
	 * 上线id集合
	 */
	private String onlineIds;
	
	
	/**
	 * 上线标题
	 */
	private String onlineTitle;
	
	
	/**
	 * 上线状态
	 */
	private byte onlineState;
	
}
