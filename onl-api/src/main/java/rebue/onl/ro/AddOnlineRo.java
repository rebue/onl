package rebue.onl.ro;
/**  
* 创建时间：2018年8月30日16:58:35 
* 项目名称：onl-api  
* @author daniel  
* @version 1.0   
* @since JDK 1.8  
* 文件名称：AddOnlineRo.java  
* 类说明：  上线返回值
*/

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import rebue.onl.dic.AddOnlineDic;

@JsonInclude(Include.NON_NULL)
public class AddOnlineRo {

	/** 上线返回值字典 **/
	private AddOnlineDic result;

	/** 上线返回值 **/
	private String msg;

	public AddOnlineDic getResult() {
		return result;
	}

	public void setResult(AddOnlineDic result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "GoodsOnlineRo [result=" + result + ", msg=" + msg + "]";
	}

}
