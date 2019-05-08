package rebue.onl.ro;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import rebue.onl.mo.OnlOnlineSpecMo;

/**
 * 上线商品信息树
 * @author lbl
 *
 */
@Data
@JsonInclude(Include.NON_NULL)
public class OnlOnlineTreeRo {

	/**
	 * 上线ID
	 *
	 * 数据库字段: ONL_ONLINE.ID
	 *
	 */
	private Long id;

	/**
	 * 板块类型（0：普通，1：全返）
	 *
	 * 数据库字段: ONL_ONLINE.SUBJECT_TYPE
	 *
	 */
	private Byte subjectType;

	/**
	 * 上线标题
	 *
	 * 数据库字段: ONL_ONLINE.ONLINE_TITLE
	 *
	 */
	private String onlineTitle;
	
	/**
	 * 图片路径
	 *
	 * 
	 *
	 */
	private String picPath;

	/**
	 * 规格信息
	 */
	private List<OnlOnlineSpecMo> goodsList;
}
