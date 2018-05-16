package rebue.onl.ro;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import rebue.onl.dic.AddCartDic;

/**
 * 创建时间：2018年5月15日 下午3:52:02 项目名称：onl-api
 * 
 * @author daniel
 * @version 1.0
 * @since JDK 1.8 文件名称：AddCartRo.java 类说明： 加入购物车返回值
 */
@JsonInclude(Include.NON_NULL)
public class AddCartRo {

	/** 加入购物车返回值字典 **/
	private AddCartDic result;

	/** 加入购物车返回值 **/
	private String msg;

	/** 购物车数量 **/
	private int cartCount;

	public AddCartDic getResult() {
		return result;
	}

	public void setResult(AddCartDic result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCartCount() {
		return cartCount;
	}

	public void setCartCount(int cartCount) {
		this.cartCount = cartCount;
	}

	@Override
	public String toString() {
		return "AddCartRo [result=" + result + ", msg=" + msg + ", cartCount=" + cartCount + "]";
	}

}
