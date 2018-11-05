package rebue.onl.ro;
/**  
* 创建时间：2018年4月1日 下午3:19:25  
* 项目名称：onl-api  
* @author daniel  
* @version 1.0   
* @since JDK 1.8  
* 文件名称：OnlOnlineGoodsInfoMo.java  
* 类说明：  上线商品信息
*/

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;


@Data
@JsonInclude(Include.NON_NULL)
public class OnlOnlineGoodsInfoRo {

	/**
	 * 上线编号
	 */
	private long onlineId;

	/**
	 * 上线标题
	 */
	private String onlineTitle;

	/**
	 * 图片路径
	 */
	private String picPath;

	/**
	 * 商品规格编号
	 */
	private long specId;

	/**
	 * 商品规格
	 */
	private String onlineSpec;

	/**
	 * 上线价格
	 */
	private BigDecimal salePrice;

	/**
	 * 上线返现金额
	 */
	private BigDecimal cashbackAmount;

	/**
	 * 上线详情
	 */
	private String onlineDetail;
	
	/**
	 * 商品类型
	 */
	
	private Byte subjectType; 
	
    /**
     *    供应商ID
     *
     *    数据库字段: ONL_ONLINE.SUPPLIER_ID
     *
     */
    private Long supplierId;

    /**
     *    押货类型（1：押货 2：供应商发货）
     *
     *    数据库字段: ONL_ONLINE.PLEDGE_TYPE
     *
     */
    private Byte pledgeType;
    
    



}
