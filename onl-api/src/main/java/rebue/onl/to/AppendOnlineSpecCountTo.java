package rebue.onl.to;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class AppendOnlineSpecCountTo {

	/**
	 * 上线id
	 */
	private Long onlineId;

	/**
	 * 追加数量、规格id、已上线数量
	 */
	private Map<String, Object> appends;

	/**
	 * 操作人id
	 */
	private Long opId;

	/**
	 * 上线规格id
	 */
	private Long onlineSpecId;

	/**
	 * 已上线数量
	 */
	private Integer onlineTotal;

	/**
	 * 追加数量
	 */
	private Integer appendCount;

}
