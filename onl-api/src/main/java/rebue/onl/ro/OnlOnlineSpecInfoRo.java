package rebue.onl.ro;

import java.math.BigDecimal;

/**
 * 创建时间：2018年4月1日 下午4:16:49 项目名称：onl-api
 * 
 * @author daniel
 * @version 1.0
 * @since JDK 1.8 文件名称：OnlOnlineSpecInfoRo.java 类说明： 上线规格详情信息
 */
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
	 * 图片路径
	 */
	private String picPath;

	private int saleCount;

	public OnlOnlineSpecInfoRo() {
		super();
	}

	public OnlOnlineSpecInfoRo(long specId, String onlineSpec, BigDecimal salePrice, BigDecimal cashbackAmount,
			String picPath, int saleCount) {
		super();
		this.specId = specId;
		this.onlineSpec = onlineSpec;
		this.salePrice = salePrice;
		this.cashbackAmount = cashbackAmount;
		this.picPath = picPath;
		this.saleCount = saleCount;
	}

	public long getSpecId() {
		return specId;
	}

	public void setSpecId(long specId) {
		this.specId = specId;
	}

	public String getOnlineSpec() {
		return onlineSpec;
	}

	public void setOnlineSpec(String onlineSpec) {
		this.onlineSpec = onlineSpec;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public BigDecimal getCashbackAmount() {
		return cashbackAmount;
	}

	public void setCashbackAmount(BigDecimal cashbackAmount) {
		this.cashbackAmount = cashbackAmount;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public int getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}

	@Override
	public String toString() {
		return "OnlOnlineSpecInfoRo [specId=" + specId + ", onlineSpec=" + onlineSpec + ", salePrice=" + salePrice
				+ ", cashbackAmount=" + cashbackAmount + ", picPath=" + picPath + ", saleCount=" + saleCount + "]";
	}

}
