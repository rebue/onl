package rebue.onl.to;

import java.util.List;
import java.util.Map;

import lombok.Data;
import rebue.onl.mo.OnlOnlineSpecMo;

/**
 * 添加上线信息参数
 * 
 * @author admin
 *
 */
@Data
public class AddOnlineTo {

	/**
	 * 产品id
	 */
	private Long productId;

	/**
	 * 上线id
	 */
	private Long onlineId;

	/**
	 * 上线商品名称
	 */
	private String onlineName;

	/**
	 * 商品模块
	 */
	private Byte subjectType;

	/**
	 * 商品规格信息
	 */
	private List<OnlOnlineSpecMo> onlineSpecs;

	/**
	 * 商品主图
	 */
	private String goodsQsmm;

	/**
	 * 商品轮播图
	 */
	private List<Map<String, Object>> slideshow;

	/**
	 * 商品详情
	 */
	private String onlineDetail;

	/**
	 * 操作人id
	 */
	private Long opId;

}
