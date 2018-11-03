package rebue.onl.to;

import java.util.List;
import java.util.Map;

import lombok.Data;

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
	private List<OnlOnlineSpecTo> onlineSpecs;

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

	/**
     *    供应商ID
     *
     *    数据库字段: ONL_ONLINE.SUPPLIER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long supplierId;

    /**
     *    供应商结算类型（1：结算到余额 2：结算到货款）
     *
     *    数据库字段: ONL_ONLINE.SUPPLIER_SETTLE_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Byte supplierSettleType;
}
