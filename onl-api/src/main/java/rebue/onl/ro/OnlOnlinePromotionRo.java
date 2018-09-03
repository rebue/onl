package rebue.onl.ro;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import rebue.onl.mo.OnlOnlinePromotionMo;

@JsonInclude(Include.NON_NULL)
public class OnlOnlinePromotionRo {

	/**
	 * This field was generated by MyBatis Generator.
	 *
	 * 返回值 1:成功 -1:失败
	 *
	 * @mbg.generated
	 */
	private Byte result;

	/**
	 * This field was generated by MyBatis Generator.
	 *
	 * 返回的结果
	 *
	 * @mbg.generated
	 */
	private String msg;

	private OnlOnlinePromotionMo record;

	public Byte getResult() {
		return result;
	}

	public void setResult(Byte result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public OnlOnlinePromotionMo getRecord() {
		return record;
	}

	public void setRecord(OnlOnlinePromotionMo record) {
		this.record = record;
	}

	@Override
	public String toString() {
		return "OnlOnlinePromotionRo [result=" + result + ", msg=" + msg + ", record=" + record + "]";
	}

}