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

	public Byte getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(Byte subjectType) {
		this.subjectType = subjectType;
	}

	public OnlOnlineGoodsInfoRo() {
		super();
	}

	public OnlOnlineGoodsInfoRo(long onlineId, String onlineTitle, String picPath, long specId, String onlineSpec,
			BigDecimal salePrice, BigDecimal cashbackAmount, String onlineDetail) {
		super();
		this.onlineId = onlineId;
		this.onlineTitle = onlineTitle;
		this.picPath = picPath;
		this.specId = specId;
		this.onlineSpec = onlineSpec;
		this.salePrice = salePrice;
		this.cashbackAmount = cashbackAmount;
		this.onlineDetail = onlineDetail;
	}

	public long getOnlineId() {
		return onlineId;
	}

	public void setOnlineId(long onlineId) {
		this.onlineId = onlineId;
	}

	public String getOnlineTitle() {
		return onlineTitle;
	}

	public void setOnlineTitle(String onlineTitle) {
		this.onlineTitle = onlineTitle;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
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

	public String getOnlineDetail() {
		return onlineDetail;
	}

	public void setOnlineDetail(String onlineDetail) {
		this.onlineDetail = onlineDetail;
	}

	@Override
	public String toString() {
		return "OnlOnlineGoodsInfoRo [onlineId=" + onlineId + ", onlineTitle=" + onlineTitle + ", picPath=" + picPath
				+ ", specId=" + specId + ", onlineSpec=" + onlineSpec + ", salePrice=" + salePrice + ", cashbackAmount="
				+ cashbackAmount + ", onlineDetail=" + onlineDetail + "]";
	}

}
