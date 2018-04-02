package rebue.onl.to;
/**  
* 创建时间：2018年3月26日 下午5:23:55  
* 项目名称：onl-api  
* @author daniel  
* @version 1.0   
* @since JDK 1.8  
* 文件名称：OnlineGoodsBaseTo.java  
* 类说明：  上线商品返回值
*/

public class OnlineGoodsBaseTo {

	/**
	 * 操作人编号
	 */
	private Long opId;

	/**
	 * 上线标题
	 */
	private String onlineTitle;

	/**
	 * 商品描述
	 */
	private String onlineDetail;

	/**
	 * 商品主图
	 */
	private String goodsQsmm;

	/**
	 * 商品轮播图
	 */
	private String faceImg;

	/**
	 * 商品规格信息
	 */
	private String[] list;

	public OnlineGoodsBaseTo() {
		super();
	}

	public OnlineGoodsBaseTo(Long opId, String onlineTitle, String onlineDetail, String goodsQsmm, String faceImg,
			String[] list) {
		super();
		this.opId = opId;
		this.onlineTitle = onlineTitle;
		this.onlineDetail = onlineDetail;
		this.goodsQsmm = goodsQsmm;
		this.faceImg = faceImg;
		this.list = list;
	}

	public Long getOpId() {
		return opId;
	}

	public void setOpId(Long opId) {
		this.opId = opId;
	}

	public String getOnlineTitle() {
		return onlineTitle;
	}

	public void setOnlineTitle(String onlineTitle) {
		this.onlineTitle = onlineTitle;
	}

	public String getOnlineDetail() {
		return onlineDetail;
	}

	public void setOnlineDetail(String onlineDetail) {
		this.onlineDetail = onlineDetail;
	}

	public String getGoodsQsmm() {
		return goodsQsmm;
	}

	public void setGoodsQsmm(String goodsQsmm) {
		this.goodsQsmm = goodsQsmm;
	}

	public String getFaceImg() {
		return faceImg;
	}

	public void setFaceImg(String faceImg) {
		this.faceImg = faceImg;
	}

	public String[] getList() {
		return list;
	}

	public void setList(String[] list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "OnlineGoodsBaseTo [opId=" + opId + ", onlineTitle=" + onlineTitle + ", onlineDetail=" + onlineDetail
				+ ", goodsQsmm=" + goodsQsmm + ", faceImg=" + faceImg + ", list=" + list + "]";
	}

}
