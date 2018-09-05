package rebue.onl.mo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;

/**
 * 上线推广
 *
 * 数据库表: ONL_ONLINE_PROMOTION
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@JsonInclude(Include.NON_NULL)
public class OnlOnlinePromotionMo implements Serializable {

    /**
     *    上线推广ID
     *
     *    数据库字段: ONL_ONLINE_PROMOTION.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long id;

    /**
     *    上线ID
     *
     *    数据库字段: ONL_ONLINE_PROMOTION.ONLINE_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long onlineId;

    /**
     *    推广类型
     *
     *    数据库字段: ONL_ONLINE_PROMOTION.PROMOTION_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Byte promotionType;

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
     *    上线推广ID
     *
     *    数据库字段: ONL_ONLINE_PROMOTION.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getId() {
        return id;
    }

    /**
     *    上线推广ID
     *
     *    数据库字段: ONL_ONLINE_PROMOTION.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *    上线ID
     *
     *    数据库字段: ONL_ONLINE_PROMOTION.ONLINE_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getOnlineId() {
        return onlineId;
    }

    /**
     *    上线ID
     *
     *    数据库字段: ONL_ONLINE_PROMOTION.ONLINE_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOnlineId(Long onlineId) {
        this.onlineId = onlineId;
    }

    /**
     *    推广类型
     *
     *    数据库字段: ONL_ONLINE_PROMOTION.PROMOTION_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Byte getPromotionType() {
        return promotionType;
    }

    /**
     *    推广类型
     *
     *    数据库字段: ONL_ONLINE_PROMOTION.PROMOTION_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setPromotionType(Byte promotionType) {
        this.promotionType = promotionType;
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
        sb.append(", promotionType=").append(promotionType);
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
        OnlOnlinePromotionMo other = (OnlOnlinePromotionMo) that;
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
