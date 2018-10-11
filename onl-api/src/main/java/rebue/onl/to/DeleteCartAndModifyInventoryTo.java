package rebue.onl.to;

/**
 * 创建时间：2018年4月11日 下午4:42:36 项目名称：onl-api
 * 
 * @author daniel
 * @version 1.0
 * @since JDK 1.8 文件名称：DeleteCartAndModifyInventoryRo.java 类说明： 删除购物车和修改库存
 */
public class DeleteCartAndModifyInventoryTo {

	/**
	 * 购物车ID
	 */
	private long cartId;

	/**
	 * 上线ID
	 */
	private long onlineId;

	/**
	 * 上线规格
	 */
	private String onlineSpec;

	/**
	 * 购买数量
	 */
	private int buyCount;

	public DeleteCartAndModifyInventoryTo() {
		super();
	}

	public DeleteCartAndModifyInventoryTo(long cartId, long onlineId, String onlineSpec, int buyCount) {
		super();
		this.cartId = cartId;
		this.onlineId = onlineId;
		this.onlineSpec = onlineSpec;
		this.buyCount = buyCount;
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public long getOnlineId() {
		return onlineId;
	}

	public void setOnlineId(long onlineId) {
		this.onlineId = onlineId;
	}

	public String getOnlineSpec() {
		return onlineSpec;
	}

	public void setOnlineSpec(String onlineSpec) {
		this.onlineSpec = onlineSpec;
	}

	public int getBuyCount() {
		return buyCount;
	}

	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}

	@Override
	public String toString() {
		return "DeleteCartAndModifyInventoryRo [cartId=" + cartId + ", onlineId=" + onlineId + ", onlineSpec="
				+ onlineSpec + ", buyCount=" + buyCount + "]";
	}

}
