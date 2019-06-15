package rebue.onl.ro;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import rebue.onl.mo.OnlOnlinePicMo;
import rebue.onl.mo.OnlOnlineSpecAttrMo;
import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.mo.OnlSearchCategoryMo;

@Data
public class OnlinesRo {
	
	/**
	 * 上线id
	 */
	private Long id;

	/**
	 * 上线标题
	 */
	private String onlineTitle;

	/**
	 * 上线详情
	 */
	private String onlineDetail;

	/**
	 * 上线状态
	 */
	private Byte onlineState;

	private Long opId;
	
	/**
     *    发货组织ID(默认填入上线组织ID，可变更为供应商的ID)
     *
     *    数据库字段: ONL_ONLINE.DELIVER_ORG_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long deliverOrgId;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date onlineTime;

	/**
	 * 产品id
	 */
	private Long productId;

	/**
	 * 板块类型
	 */
	private Byte subjectType;
	
	/**
	 * 发货类型
	 */
	private Byte deliveryType;
	
	/**
	 * 是否线下
	 */
	private Byte isBelow;
	
	/**
	 * 是否线上
	 */
	private Byte isOnline;
	
	/**
	 * 是否上线到平台
	 */
	private Byte isOnlinePlatform;
	
	/**
	 * 规格信息
	 */
	private List<OnlOnlineSpecMo> onlineSpecList;
	
	/**
	 * 规格属性信息
	 */
	private List<OnlOnlineSpecAttrMo> onlOnlineSpecAttrList;
	
	/**
	 * 图片信息
	 */
	private List<OnlOnlinePicMo> onlinePicList;
	
	/**
	 * 搜索分类
	 */
	private List<OnlSearchCategoryMo> searchCategoryMo; 
}
