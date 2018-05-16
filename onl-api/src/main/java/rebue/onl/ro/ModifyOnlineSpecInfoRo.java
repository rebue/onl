package rebue.onl.ro;
/**  
* 创建时间：2018年5月15日 下午3:31:22  
* 项目名称：onl-api  
* @author daniel  
* @version 1.0   
* @since JDK 1.8  
* 文件名称：ModifyOnlineSpecInfoRo.java  
* 类说明：  修改上线规格信息返回值
*/

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import rebue.onl.dic.ModifyOnlineSpecInfoDic;

@JsonInclude(Include.NON_NULL)
public class ModifyOnlineSpecInfoRo {

	/** 修改上线规格信息返回值字典 **/
	private ModifyOnlineSpecInfoDic result;

	/** 修改上线规格信息返回值 **/
	private String msg;

	public ModifyOnlineSpecInfoDic getResult() {
		return result;
	}

	public void setResult(ModifyOnlineSpecInfoDic result) {
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
		return "ModifyOnlineSpecInfoRo [result=" + result + ", msg=" + msg + "]";
	}

}
