package rebue.onl.ro;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * 上线信息Ro
 * 
 * @author lbl
 *
 */
@Data
@JsonInclude(Include.NON_NULL)
public class OnlOnlineListRo {

    /**
     * 上线ID
     *
     * 数据库字段: ONL_ONLINE.ID
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long id;

    /**
     * 上线id(属于推广表中的上线id)
     */
    private Long onlineId;

    /**
     * 板块类型（0：普通，1：全返）
     *
     * 数据库字段: ONL_ONLINE.SUBJECT_TYPE
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Byte subjectType;

    /**
     * 上线标题
     *
     * 数据库字段: ONL_ONLINE.ONLINE_TITLE
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String onlineTitle;

    /**
     * 上线描述
     *
     * 数据库字段: ONL_ONLINE.ONLINE_DETAIL
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String onlineDetail;

    /**
     * 操作人ID
     *
     * 数据库字段: ONL_ONLINE.OP_ID
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long opId;

    /**
     * 上线状态（0：下线，1：上线 ）
     *
     * 数据库字段: ONL_ONLINE.ONLINE_STATE
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Byte onlineState;

    /**
     * 上线时间
     *
     * 数据库字段: ONL_ONLINE.ONLINE_TIME
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date onlineTime;

    /**
     * 产品ID,上一次上线的产品ID
     *
     * 数据库字段: ONL_ONLINE.PRODUCT_ID
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long productId;

    /**
     * 供应商ID
     *
     * 数据库字段: ONL_ONLINE.SUPPLIER_ID
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long supplierId;

    /**
     * 供应商名称
     */
    private String supplierName;

    /**
     * 发货组织id
     */
    private Long deliverOrgId;

    /**
     * 发货组织名称
     */
    private String deliverOrgName;

    /**
     * 发货类型
     */
    private Byte deliveryType;

    /**
     * 当前组织id
     */
    private Long thisOrgId;

    /**
     * 店铺名称
     */
    private String shopName;

    public OnlOnlineListRo() {
        super();
    }
}
