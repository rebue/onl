package rebue.onl.ro;

import java.math.BigDecimal;

/**
 * 创建时间：2018年3月30日 上午11:47:44 项目名称：onl-api
 * 
 * @author daniel
 * @version 1.0
 * @since JDK 1.8 文件名称：OnlCartRo.java 类说明：购物车列表
 */
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

	public Byte getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(Byte subjectType) {
		this.subjectType = subjectType;
	}

	public OnlCartRo() {
		super();
	}

	public OnlCartRo(long id, long onlineId, String onlineTitle, long onlineSpecId, String onlineSpec,
			BigDecimal cashbackAmount, BigDecimal salePrice, Integer cartCount, String picPath, Long produceId) {
		super();
		this.id = id;
		this.onlineId = onlineId;
		this.onlineTitle = onlineTitle;
		this.onlineSpecId = onlineSpecId;
		this.onlineSpec = onlineSpec;
		this.cashbackAmount = cashbackAmount;
		this.salePrice = salePrice;
		this.cartCount = cartCount;
		this.picPath = picPath;
		this.productId = produceId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public long getOnlineSpecId() {
		return onlineSpecId;
	}

	public void setOnlineSpecId(long onlineSpecId) {
		this.onlineSpecId = onlineSpecId;
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

	public Integer getCartCount() {
		return cartCount;
	}

	public void setCartCount(Integer cartCount) {
		this.cartCount = cartCount;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long produceId) {
		this.productId = produceId;
	}

	@Override
	public String toString() {
		return "OnlCartRo [id=" + id + ", onlineId=" + onlineId + ", onlineTitle=" + onlineTitle + ", onlineSpecId="
				+ onlineSpecId + ", onlineSpec=" + onlineSpec + ", cashbackAmount=" + cashbackAmount + ", salePrice="
				+ salePrice + ", cartCount=" + cartCount + ", picPath=" + picPath + ", produceId=" + productId
				+ ", subjectType=" + subjectType + "]";
	}


}
