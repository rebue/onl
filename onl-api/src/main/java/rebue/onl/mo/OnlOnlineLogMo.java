package rebue.onl.mo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 上线日志
 *
 * 数据库表: ONL_ONLINE_LOG
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@JsonInclude(Include.NON_NULL)
public class OnlOnlineLogMo implements Serializable {

    /**
     *    上线日志ID
     *
     *    数据库字段: ONL_ONLINE_LOG.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long id;

    /**
     *    上线ID
     *
     *    数据库字段: ONL_ONLINE_LOG.ONLINE_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long onlineId;

    /**
     *    板块类型（0：普通，1：全返）
     *
     *    数据库字段: ONL_ONLINE_LOG.SUBJECT_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Byte subjectType;

    /**
     *    上线标题
     *
     *    数据库字段: ONL_ONLINE_LOG.ONLINE_TITLE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String onlineTitle;

    /**
     *    上线描述
     *
     *    数据库字段: ONL_ONLINE_LOG.ONLINE_DETAIL
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String onlineDetail;

    /**
     *    上线组织ID
     *
     *    数据库字段: ONL_ONLINE_LOG.ONLINE_ORG_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long onlineOrgId;

    /**
     *    供应商ID
     *
     *    数据库字段: ONL_ONLINE_LOG.SUPPLIER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long supplierId;

    /**
     *    发货组织类型（1：本组织发货 2：供应商发货）
     *
     *    数据库字段: ONL_ONLINE_LOG.DELIVER_ORG_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Byte deliverOrgType;

    /**
     *    操作人ID
     *
     *    数据库字段: ONL_ONLINE_LOG.OP_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long opId;

    /**
     *    操作时间
     *
     *    数据库字段: ONL_ONLINE_LOG.OP_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date opTime;

    /**
     *    产品ID,上一次上线的产品ID
     *
     *    数据库字段: ONL_ONLINE_LOG.PRODUCT_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long productId;

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
     *    上线日志ID
     *
     *    数据库字段: ONL_ONLINE_LOG.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getId() {
        return id;
    }

    /**
     *    上线日志ID
     *
     *    数据库字段: ONL_ONLINE_LOG.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *    上线ID
     *
     *    数据库字段: ONL_ONLINE_LOG.ONLINE_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getOnlineId() {
        return onlineId;
    }

    /**
     *    上线ID
     *
     *    数据库字段: ONL_ONLINE_LOG.ONLINE_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOnlineId(Long onlineId) {
        this.onlineId = onlineId;
    }

    /**
     *    板块类型（0：普通，1：全返）
     *
     *    数据库字段: ONL_ONLINE_LOG.SUBJECT_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Byte getSubjectType() {
        return subjectType;
    }

    /**
     *    板块类型（0：普通，1：全返）
     *
     *    数据库字段: ONL_ONLINE_LOG.SUBJECT_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSubjectType(Byte subjectType) {
        this.subjectType = subjectType;
    }

    /**
     *    上线标题
     *
     *    数据库字段: ONL_ONLINE_LOG.ONLINE_TITLE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getOnlineTitle() {
        return onlineTitle;
    }

    /**
     *    上线标题
     *
     *    数据库字段: ONL_ONLINE_LOG.ONLINE_TITLE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOnlineTitle(String onlineTitle) {
        this.onlineTitle = onlineTitle;
    }

    /**
     *    上线描述
     *
     *    数据库字段: ONL_ONLINE_LOG.ONLINE_DETAIL
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getOnlineDetail() {
        return onlineDetail;
    }

    /**
     *    上线描述
     *
     *    数据库字段: ONL_ONLINE_LOG.ONLINE_DETAIL
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOnlineDetail(String onlineDetail) {
        this.onlineDetail = onlineDetail;
    }

    /**
     *    上线组织ID
     *
     *    数据库字段: ONL_ONLINE_LOG.ONLINE_ORG_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getOnlineOrgId() {
        return onlineOrgId;
    }

    /**
     *    上线组织ID
     *
     *    数据库字段: ONL_ONLINE_LOG.ONLINE_ORG_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOnlineOrgId(Long onlineOrgId) {
        this.onlineOrgId = onlineOrgId;
    }

    /**
     *    供应商ID
     *
     *    数据库字段: ONL_ONLINE_LOG.SUPPLIER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getSupplierId() {
        return supplierId;
    }

    /**
     *    供应商ID
     *
     *    数据库字段: ONL_ONLINE_LOG.SUPPLIER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /**
     *    发货组织类型（1：本组织发货 2：供应商发货）
     *
     *    数据库字段: ONL_ONLINE_LOG.DELIVER_ORG_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Byte getDeliverOrgType() {
        return deliverOrgType;
    }

    /**
     *    发货组织类型（1：本组织发货 2：供应商发货）
     *
     *    数据库字段: ONL_ONLINE_LOG.DELIVER_ORG_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setDeliverOrgType(Byte deliverOrgType) {
        this.deliverOrgType = deliverOrgType;
    }

    /**
     *    操作人ID
     *
     *    数据库字段: ONL_ONLINE_LOG.OP_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getOpId() {
        return opId;
    }

    /**
     *    操作人ID
     *
     *    数据库字段: ONL_ONLINE_LOG.OP_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOpId(Long opId) {
        this.opId = opId;
    }

    /**
     *    操作时间
     *
     *    数据库字段: ONL_ONLINE_LOG.OP_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Date getOpTime() {
        return opTime;
    }

    /**
     *    操作时间
     *
     *    数据库字段: ONL_ONLINE_LOG.OP_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    /**
     *    产品ID,上一次上线的产品ID
     *
     *    数据库字段: ONL_ONLINE_LOG.PRODUCT_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getProductId() {
        return productId;
    }

    /**
     *    产品ID,上一次上线的产品ID
     *
     *    数据库字段: ONL_ONLINE_LOG.PRODUCT_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", onlineId=").append(onlineId);
        sb.append(", subjectType=").append(subjectType);
        sb.append(", onlineTitle=").append(onlineTitle);
        sb.append(", onlineDetail=").append(onlineDetail);
        sb.append(", onlineOrgId=").append(onlineOrgId);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", deliverOrgType=").append(deliverOrgType);
        sb.append(", opId=").append(opId);
        sb.append(", opTime=").append(opTime);
        sb.append(", productId=").append(productId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OnlOnlineLogMo other = (OnlOnlineLogMo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()));
    }

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }
}
