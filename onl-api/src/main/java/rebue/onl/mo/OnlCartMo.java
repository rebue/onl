package rebue.onl.mo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 购物车
 *
 * 数据库表: ONL_CART
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@JsonInclude(Include.NON_NULL)
public class OnlCartMo implements Serializable {

    /**
     *    购物车ID
     *
     *    数据库字段: ONL_CART.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long id;

    /**
     *    上线规格ID
     *
     *    数据库字段: ONL_CART.ONLINE_SPEC_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long onlineSpecId;

    /**
     *    上线ID
     *
     *    数据库字段: ONL_CART.ONLINE_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long onlineId;

    /**
     *    用户编号
     *
     *    数据库字段: ONL_CART.USER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long userId;

    /**
     *    购物车规格数量
     *
     *    数据库字段: ONL_CART.CART_COUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Integer cartCount;

    /**
     *    加入时间
     *
     *    数据库字段: ONL_CART.JOIN_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date joinTime;

    /**
     *    供应商ID
     *
     *    数据库字段: ONL_CART.SUPPLIER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long supplierId;

    /**
     *    供应商结算类型（1：结算到余额 2：结算到货款）
     *
     *    数据库字段: ONL_CART.SUPPLIER_SETTLE_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Byte supplierSettleType;

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
     *    购物车ID
     *
     *    数据库字段: ONL_CART.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getId() {
        return id;
    }

    /**
     *    购物车ID
     *
     *    数据库字段: ONL_CART.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *    上线规格ID
     *
     *    数据库字段: ONL_CART.ONLINE_SPEC_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getOnlineSpecId() {
        return onlineSpecId;
    }

    /**
     *    上线规格ID
     *
     *    数据库字段: ONL_CART.ONLINE_SPEC_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOnlineSpecId(Long onlineSpecId) {
        this.onlineSpecId = onlineSpecId;
    }

    /**
     *    上线ID
     *
     *    数据库字段: ONL_CART.ONLINE_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getOnlineId() {
        return onlineId;
    }

    /**
     *    上线ID
     *
     *    数据库字段: ONL_CART.ONLINE_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOnlineId(Long onlineId) {
        this.onlineId = onlineId;
    }

    /**
     *    用户编号
     *
     *    数据库字段: ONL_CART.USER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getUserId() {
        return userId;
    }

    /**
     *    用户编号
     *
     *    数据库字段: ONL_CART.USER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     *    购物车规格数量
     *
     *    数据库字段: ONL_CART.CART_COUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Integer getCartCount() {
        return cartCount;
    }

    /**
     *    购物车规格数量
     *
     *    数据库字段: ONL_CART.CART_COUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setCartCount(Integer cartCount) {
        this.cartCount = cartCount;
    }

    /**
     *    加入时间
     *
     *    数据库字段: ONL_CART.JOIN_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Date getJoinTime() {
        return joinTime;
    }

    /**
     *    加入时间
     *
     *    数据库字段: ONL_CART.JOIN_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    /**
     *    供应商ID
     *
     *    数据库字段: ONL_CART.SUPPLIER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getSupplierId() {
        return supplierId;
    }

    /**
     *    供应商ID
     *
     *    数据库字段: ONL_CART.SUPPLIER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /**
     *    供应商结算类型（1：结算到余额 2：结算到货款）
     *
     *    数据库字段: ONL_CART.SUPPLIER_SETTLE_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Byte getSupplierSettleType() {
        return supplierSettleType;
    }

    /**
     *    供应商结算类型（1：结算到余额 2：结算到货款）
     *
     *    数据库字段: ONL_CART.SUPPLIER_SETTLE_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSupplierSettleType(Byte supplierSettleType) {
        this.supplierSettleType = supplierSettleType;
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
        sb.append(", onlineSpecId=").append(onlineSpecId);
        sb.append(", onlineId=").append(onlineId);
        sb.append(", userId=").append(userId);
        sb.append(", cartCount=").append(cartCount);
        sb.append(", joinTime=").append(joinTime);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", supplierSettleType=").append(supplierSettleType);
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
        OnlCartMo other = (OnlCartMo) that;
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
