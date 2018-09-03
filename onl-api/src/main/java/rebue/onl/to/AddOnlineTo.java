package rebue.onl.to;

import java.util.List;
import java.util.Map;

import rebue.onl.mo.OnlOnlineSpecMo;

/**
 * 添加上线信息参数
 * 
 * @author admin
 *
 */
public class AddOnlineTo {

	/**
	 * 产品id
	 */
	private Long productId;

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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getOnlineName() {
		return onlineName;
	}

	public void setOnlineName(String onlineName) {
		this.onlineName = onlineName;
	}

	public Byte getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(Byte subjectType) {
		this.subjectType = subjectType;
	}

	public List<OnlOnlineSpecMo> getOnlineSpecs() {
		return onlineSpecs;
	}

	public void setOnlineSpecs(List<OnlOnlineSpecMo> onlineSpecs) {
		this.onlineSpecs = onlineSpecs;
	}

	public String getGoodsQsmm() {
		return goodsQsmm;
	}

	public void setGoodsQsmm(String goodsQsmm) {
		this.goodsQsmm = goodsQsmm;
	}

	public List<Map<String, Object>> getSlideshow() {
		return slideshow;
	}

	public void setSlideshow(List<Map<String, Object>> slideshow) {
		this.slideshow = slideshow;
	}

	public String getOnlineDetail() {
		return onlineDetail;
	}

	public void setOnlineDetail(String onlineDetail) {
		this.onlineDetail = onlineDetail;
	}

	public Long getOpId() {
		return opId;
	}

	public void setOpId(Long opId) {
		this.opId = opId;
	}

	@Override
	public String toString() {
		return "AddOnlineTo [productId=" + productId + ", onlineName=" + onlineName + ", subjectType=" + subjectType
				+ ", onlineSpecs=" + onlineSpecs + ", goodsQsmm=" + goodsQsmm + ", slideshow=" + slideshow
				+ ", onlineDetail=" + onlineDetail + ", opId=" + opId + "]";
	}

}
