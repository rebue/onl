package rebue.onl.to;

import java.math.BigDecimal;

/**
 * 创建时间：2018年3月26日 下午5:32:40 项目名称：onl-api
 * 
 * @author daniel
 * @version 1.0
 * @since JDK 1.8 文件名称：OnlineGoodsSpecBaseTo.java 类说明： 上线商品规格返回值
 */
public class OnlineGoodsSpecBaseTo {

	/**
	 * 商品规格
	 */
	private String onlineSpec;

	/**
	 * 商品返现金额
	 */
	private BigDecimal cashbackAmount;

	/**
	 * 商品销售金额
	 */
	private BigDecimal salePrice;

	/**
	 * 上线数量
	 */
	private Integer saleCount;

	/**
	 * 商品单位
	 */
	private String saleUnit;

	/**
	 * 规格排序号
	 */
	private Integer seqNo;

	public OnlineGoodsSpecBaseTo() {
		super();
	}

	public OnlineGoodsSpecBaseTo(String onlineSpec, BigDecimal cashbackAmount, BigDecimal salePrice, Integer saleCount,
			String saleUnit, Integer seqNo) {
		super();
		this.onlineSpec = onlineSpec;
		this.cashbackAmount = cashbackAmount;
		this.salePrice = salePrice;
		this.saleCount = saleCount;
		this.saleUnit = saleUnit;
		this.seqNo = seqNo;
	}

	public String getOnlineSpec() {
		return onlineSpec;
	}

	public void setOnlineSpec(String onlineSpec) {
		this.onlineSpec = onlineSpec;
	}

	public BigDecimal getCashbackAmount() {
		return cashbackAmount;
	}

	public void setCashbackAmount(BigDecimal cashbackAmount) {
		this.cashbackAmount = cashbackAmount;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public Integer getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(Integer saleCount) {
		this.saleCount = saleCount;
	}

	public String getSaleUnit() {
		return saleUnit;
	}

	public void setSaleUnit(String saleUnit) {
		this.saleUnit = saleUnit;
	}

	public Integer getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(Integer seqNo) {
		this.seqNo = seqNo;
	}

	@Override
	public String toString() {
		return "OnlineGoodsSpecBaseTo [onlineSpec=" + onlineSpec + ", cashbackAmount=" + cashbackAmount + ", salePrice="
				+ salePrice + ", saleCount=" + saleCount + ", saleUnit=" + saleUnit + ", seqNo=" + seqNo + "]";
	}

}
