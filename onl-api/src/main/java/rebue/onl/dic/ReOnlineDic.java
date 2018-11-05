package rebue.onl.dic;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;

import rebue.wheel.baseintf.EnumBase;

public enum ReOnlineDic implements EnumBase {

	/**
	 * 重新上线成功
	 */
	SUCCESS(1),

	/**
	 * 参数错误
	 */
	PARAMETER_ERROR(-1),

	/**
	 * 修改上线信息出错
	 */
	MODIFY_ONLINE_ERROR(-1),

	/**
	 * 添加上线日志出错
	 */
	ADD_ONLINE_LOG_ERROR(-2),

	/**
	 * 修改上线规格出错
	 */
	MODIFY_ONLINE_SPEC_ERROR(-3),

	/**
	 * 添加上线规格日志出错
	 */
	ADD_ONLINE_SPEC_LOG_ERROR(-4),

	/**
	 * 修改主图出错
	 */
	MODIFY_QSMM_ERROR(-5),

	/**
	 * 修改轮播图出错
	 */
	MODIFY_SLIDESHOW_ERROR(-6),

	/**
	 * 添加上线图片日志出错
	 */
	ADD_ONLINE_PIC_LOG_ERROR(-7),
	
	/**
	 * 操作人不存在
	 */
	OP_NOT_EXIST(-8),
	
	/**
	 * 操作人没有组织
	 */
	OP_NOT_ORG(-9),

	/**
	 * 重新上线失败
	 */
	ERROR(-10);

	/**
	 * 枚举的所有项，注意这个变量是静态单例的
	 */
	private static Map<Integer, EnumBase> valueMap;
	// 初始化map，保存枚举的所有项到map中以方便通过code查找
	static {
		valueMap = new HashMap<>();
		for (EnumBase item : values()) {
			valueMap.put(item.getCode(), item);
		}
	}

	/**
	 * jackson反序列化时，通过code得到枚举的实例 注意：此方法必须是static的方法，且返回类型必须是本枚举类，而不能是接口EnumBase
	 * 否则jackson将调用默认的反序列化方法，而不会调用本方法
	 */
	@JsonCreator
	public static ReOnlineDic getItem(int code) {
		EnumBase result = valueMap.get(code);
		if (result == null) {
			throw new IllegalArgumentException("输入的code" + code + "不在枚举的取值范围内");
		}
		return (ReOnlineDic) result;
	}

	private int code;

	/**
	 * 构造器，传入code
	 */
	ReOnlineDic(int code) {
		this.code = code;
	}

	/**
	 * @return jackson序列化时，输出枚举实例的code
	 */
	@Override
	public int getCode() {
		return code;
	}
}
