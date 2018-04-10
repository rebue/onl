package rebue.onl.mo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Database Table Remarks:
 *   购物车
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table ONL_CART
 *
 * @mbg.generated do_not_delete_during_merge 2018-04-08 11:13:08
 */
@ApiModel(value = "OnlCartMo", description = "购物车")
@JsonInclude(Include.NON_NULL)
public class OnlCartMo implements Serializable {
    /**
     * Database Column Remarks:
     *   购物车ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ONL_CART.ID
     *
     * @mbg.generated 2018-04-08 11:13:08
     */
    @ApiModelProperty(value = "购物车ID")
    private Long id;

    /**
     * Database Column Remarks:
     *   上线规格ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ONL_CART.ONLINE_SPEC_ID
     *
     * @mbg.generated 2018-04-08 11:13:08
     */
    @ApiModelProperty(value = "上线规格ID")
    private Long onlineSpecId;

    /**
     * Database Column Remarks:
     *   上线ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ONL_CART.ONLINE_ID
     *
     * @mbg.generated 2018-04-08 11:13:08
     */
    @ApiModelProperty(value = "上线ID")
    private Long onlineId;

    /**
     * Database Column Remarks:
     *   用户编号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ONL_CART.USER_ID
     *
     * @mbg.generated 2018-04-08 11:13:08
     */
    @ApiModelProperty(value = "用户编号")
    private Long userId;

    /**
     * Database Column Remarks:
     *   购物车规格数量
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ONL_CART.CART_COUNT
     *
     * @mbg.generated 2018-04-08 11:13:08
     */
    @ApiModelProperty(value = "购物车规格数量")
    private Integer cartCount;

    /**
     * Database Column Remarks:
     *   加入时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ONL_CART.JOIN_TIME
     *
     * @mbg.generated 2018-04-08 11:13:08
     */
    @ApiModelProperty(value = "加入时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date joinTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ONL_CART
     *
     * @mbg.generated 2018-04-08 11:13:08
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ONL_CART.ID
     *
     * @return the value of ONL_CART.ID
     *
     * @mbg.generated 2018-04-08 11:13:08
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ONL_CART.ID
     *
     * @param id the value for ONL_CART.ID
     *
     * @mbg.generated 2018-04-08 11:13:08
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ONL_CART.ONLINE_SPEC_ID
     *
     * @return the value of ONL_CART.ONLINE_SPEC_ID
     *
     * @mbg.generated 2018-04-08 11:13:08
     */
    public Long getOnlineSpecId() {
        return onlineSpecId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ONL_CART.ONLINE_SPEC_ID
     *
     * @param onlineSpecId the value for ONL_CART.ONLINE_SPEC_ID
     *
     * @mbg.generated 2018-04-08 11:13:08
     */
    public void setOnlineSpecId(Long onlineSpecId) {
        this.onlineSpecId = onlineSpecId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ONL_CART.ONLINE_ID
     *
     * @return the value of ONL_CART.ONLINE_ID
     *
     * @mbg.generated 2018-04-08 11:13:08
     */
    public Long getOnlineId() {
        return onlineId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ONL_CART.ONLINE_ID
     *
     * @param onlineId the value for ONL_CART.ONLINE_ID
     *
     * @mbg.generated 2018-04-08 11:13:08
     */
    public void setOnlineId(Long onlineId) {
        this.onlineId = onlineId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ONL_CART.USER_ID
     *
     * @return the value of ONL_CART.USER_ID
     *
     * @mbg.generated 2018-04-08 11:13:08
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ONL_CART.USER_ID
     *
     * @param userId the value for ONL_CART.USER_ID
     *
     * @mbg.generated 2018-04-08 11:13:08
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ONL_CART.CART_COUNT
     *
     * @return the value of ONL_CART.CART_COUNT
     *
     * @mbg.generated 2018-04-08 11:13:08
     */
    public Integer getCartCount() {
        return cartCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ONL_CART.CART_COUNT
     *
     * @param cartCount the value for ONL_CART.CART_COUNT
     *
     * @mbg.generated 2018-04-08 11:13:08
     */
    public void setCartCount(Integer cartCount) {
        this.cartCount = cartCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ONL_CART.JOIN_TIME
     *
     * @return the value of ONL_CART.JOIN_TIME
     *
     * @mbg.generated 2018-04-08 11:13:08
     */
    public Date getJoinTime() {
        return joinTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ONL_CART.JOIN_TIME
     *
     * @param joinTime the value for ONL_CART.JOIN_TIME
     *
     * @mbg.generated 2018-04-08 11:13:08
     */
    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_CART
     *
     * @mbg.generated 2018-04-08 11:13:08
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
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_CART
     *
     * @mbg.generated 2018-04-08 11:13:08
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
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        ;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ONL_CART
     *
     * @mbg.generated 2018-04-08 11:13:08
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }
}