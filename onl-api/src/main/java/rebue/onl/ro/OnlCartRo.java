package rebue.onl.ro;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 创建时间：2018年3月30日 上午11:47:44 项目名称：onl-api
 * 
 * @author daniel
 * @version 1.0
 * @since JDK 1.8 文件名称：OnlCartRo.java 类说明：购物车列表
 */
@Data
public class OnlCartRo {

	/**
	 * 购物车编号
	 */
	private long id;

	/**
	 * 上线编号
	 */
	private long onlineId;

	/**
	 * 上线标题
	 */
	private String onlineTitle;

	/**
	 * 上线规格编号
	 */
	private long onlineSpecId;

	/**
	 * 上线规格名称
	 */
	private String onlineSpec;

	/**
	 * 返现金额
	 */
	private BigDecimal cashbackAmount;

	/**
	 * 销售金额
	 */
	private BigDecimal salePrice;

	/**
	 * 购物车数量
	 */
	private Integer cartCount;

	/**
	 * 商品主图路径
	 */
	private String picPath;

	/**
	 * 产品Id
	 */
	private Long productId;
	
	/**
	 * 产品类型
	 */
	private Byte subjectType;
	
	/**
     *    供应商ID
     *
     *    数据库字段: ONL_CART.SUPPLIER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long supplierId;

    /**
     *    押货类型（1：押货 2：供应商发货）
     *
     *    数据库字段: ONL_CART.PLEDGE_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Byte pledgeType;

}
