package rebue.onl.ro;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import rebue.onl.mo.OnlOnlinePicMo;
import rebue.onl.mo.OnlOnlineSpecMo;

@Data
public class OnlinesRo {
	private Long id;

	private String onlineTitle;

	private String onlineDetail;

	private Byte onlineState;

	private Long opId;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date onlineTime;

	private Long productId;

	private Byte subjectType;
	
	/**
	 * 押货类型（1：押货 2：供应商发货）
	 *
	 * 数据库字段: ONL_ONLINE.PLEDGE_TYPE
	 *
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	private Byte pledgeType;

	/**
	 * 规格信息
	 */
	private List<OnlOnlineSpecMo> onlineSpecList;

	/**
	 * 图片信息
	 */
	private List<OnlOnlinePicMo> onlinePicList;

}
