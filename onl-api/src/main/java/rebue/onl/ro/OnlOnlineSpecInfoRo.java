package rebue.onl.ro;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 创建时间：2018年4月1日 下午4:16:49 项目名称：onl-api
 * 
 * @author daniel
 * @version 1.0
 * @since JDK 1.8 文件名称：OnlOnlineSpecInfoRo.java 类说明： 上线规格详情信息
 */
@Data
public class OnlOnlineSpecInfoRo {

	/**
	 * 规格编号
	 */
	private long specId;

	/**
	 * 上线规格
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
	 * 本次上线数量
	 */
	private Integer currentOnlineCount;

	/**
	 * 图片路径
	 */
	private String picPath;

	/**
	 * 销售数量
	 */
	private int saleCount;

	/**
	 * 购买积分
	 */
	private BigDecimal buyPoint;

	/**
	 * 首单积分
	 */
	private BigDecimal firstBuyPont;
}
