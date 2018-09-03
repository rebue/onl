package rebue.onl.dic;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;

import rebue.wheel.baseintf.EnumBase;

/**
 * 创建时间：2018年5月15日 下午2:51:57 项目名称：onl-api
 * 
 * @author daniel
 * @version 1.0
 * @since JDK 1.8 文件名称：GoodsOnlineDic.java 类说明： 商品上线返回值字典
 */
public enum AddOnlineDic implements EnumBase {

	/**
	 * 上线成功
	 */
	SUCCESS(1),

	/**
	 * 上线标题不能为空
	 */
	ONLINE_TITLE_NOT_NULL(-1),

	/**
	 * 上线详情不能为空
	 */
	ONLINE_DETAIL_NOT_NULL(-2),

	/**
	 * 商品规格不能为空
	 */
	GOODS_SPEC_NOT_NULL(-3),

	/**
	 * 商品已上线
	 */
	GOODS_ALREADY_ONLINE(-4),

	/**
	 * 添加商品上线出错
	 */
	ADD_GOODS_ONLINE_ERROR(-5),

	/**
	 * 添加商品规格出错
	 */
	ADD_GOODS_SPEC_ERROR(-6),

	/**
	 * 添加商品主图出错
	 */
	ADD_GOODS_QSMM_ERROR(-7),

	/**
	 * 添加商品轮播图出错
	 */
	ADD_GOODS_CAROUSEL_ERROR(-8),

	/**
	 * 参数错误
	 */
	PARAMETER_ERROR(-9),

	/**
	 * 上线失败
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
	public static AddOnlineDic getItem(int code) {
		EnumBase result = valueMap.get(code);
		if (result == null) {
			throw new IllegalArgumentException("输入的code" + code + "不在枚举的取值范围内");
		}
		return (AddOnlineDic) result;
	}

	private int code;

	/**
	 * 构造器，传入code
	 */
	AddOnlineDic(int code) {
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
