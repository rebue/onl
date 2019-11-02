package rebue.onl.to;

import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * 添加上线信息参数
 * 
 * @author admin
 *
 */
@Data
public class AddOnlineTo {

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
     * 商品主图
     */
    private String goodsQsmm;

    /**
     * 商品轮播图
     */
    private List<Map<String, Object>> slideshow;

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
     * 是否能修改供应商，0：否，1：是，2：是，且修改该商品未结算订单的供应商和发货组织。
     */
    private Byte isEditSupplier;

    /**
     * 是否上线到平台，0为不上线，1为上线
     */
    private Byte isOnlinePlatform;

    /**
     * 是否为线下商品,0为否，1为是,2为既是线下商品也是线上商品
     */
    private Byte isBelowOnline;

    /**
     * 上线规格属性名
     */
    private String[] attrNames;

    /**
     * 上线规格属性值
     */
    private String[][] attrValues;

    /**
     * 搜索分类id
     */
    private List<Long> classificationId;

    /**
     * 是否为商超上线商品 0为不是 1为是
     */
    private Byte isPos;
}
