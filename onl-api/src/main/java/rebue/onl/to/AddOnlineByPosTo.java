package rebue.onl.to;

import java.util.List;

import lombok.Data;

/**
 * 添加收银机上线信息参数
 * 
 * @author you
 *
 */
@Data
public class AddOnlineByPosTo {
    /**
     * 产品id
     */
    private Long productId;

    /**
     * 上线id
     */
    private Long onlineId;

    /**
     * 上线商品名称
     */
    private String onlineName;

    /**
     * 商品模块
     */
    private Byte subjectType;

    /**
     * 商品规格信息
     */
    private List<OnlOnlineSpecTo> onlineSpecs;

    /**
     * 商品详情
     */
    private String onlineDetail;

    /**
     * 操作人id
     */
    private Long opId;

    /**
     * 供应商ID
     *
     * 数据库字段: ONL_ONLINE.SUPPLIER_ID
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long supplierId;

    /**
     * 发货组织ID(默认填入上线组织ID，可变更为供应商的ID)
     *
     * 数据库字段: ONL_ONLINE.DELIVER_ORG_ID
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long deliverOrgId;

    /**
     * 操作组织ID
     *
     * 数据库字段: ONL_ONLINE.ONLINE_ORG_ID
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long onlineOrgId;

    /**
     * 是否是称重商品
     */
    private Boolean isWeighGoods;

    /**
     * 店铺ID
     *
     */
    private Long shopId;
}
