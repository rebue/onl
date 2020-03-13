package rebue.onl.mo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 上线详情
 *
 * 数据库表: ONL_ONLINE_SPEC
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@JsonInclude(Include.NON_NULL)
public class OnlOnlineSpecMo implements Serializable {

    /**
     *    上线详情ID
     *
     *    数据库字段: ONL_ONLINE_SPEC.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long id;

    /**
     *    上线ID
     *
     *    数据库字段: ONL_ONLINE_SPEC.ONLINE_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long onlineId;

    /**
     *    产品详情ID
     *
     *    数据库字段: ONL_ONLINE_SPEC.PRODUCT_SPEC_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long productSpecId;

    /**
     *    上线详情名称
     *
     *    数据库字段: ONL_ONLINE_SPEC.ONLINE_SPEC
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String onlineSpec;

    /**
     *    销售价格(单价)
     *
     *    数据库字段: ONL_ONLINE_SPEC.SALE_PRICE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal salePrice;

    /**
     *    成本价格
     *
     *    数据库字段: ONL_ONLINE_SPEC.COST_PRICE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal costPrice;

    /**
     *    返现金额
     *
     *    数据库字段: ONL_ONLINE_SPEC.CASHBACK_AMOUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal cashbackAmount;

    /**
     *    返佣金额
     *
     *    数据库字段: ONL_ONLINE_SPEC.COMMISSION_AMOUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal commissionAmount;

    /**
     *    购买积分
     *
     *    数据库字段: ONL_ONLINE_SPEC.BUY_POINT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal buyPoint;

    /**
     *    首单积分
     *
     *    数据库字段: ONL_ONLINE_SPEC.FIRST_BUY_POINT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal firstBuyPoint;

    /**
     *    销售单位
     *
     *    数据库字段: ONL_ONLINE_SPEC.SALE_UNIT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String saleUnit;

    /**
     *    当前上线数量（每次追加的数量）
     *
     *    数据库字段: ONL_ONLINE_SPEC.CURRENT_ONLINE_COUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal currentOnlineCount;

    /**
     *    限制购买数量(默认为0，不限制)
     *                每个人限制购买的数量
     *
     *    数据库字段: ONL_ONLINE_SPEC.LIMIT_COUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal limitCount;

    /**
     *    销售数量
     *
     *    数据库字段: ONL_ONLINE_SPEC.SALE_COUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal saleCount;

    /**
     *    排序号
     *
     *    数据库字段: ONL_ONLINE_SPEC.SEQ_NO
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Integer seqNo;

    /**
     *    是否有首单
     *
     *    数据库字段: ONL_ONLINE_SPEC.IS_HAVE_FIRST_ORDER
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Boolean isHaveFirstOrder;

    /**
     *    店铺ID
     *
     *    数据库字段: ONL_ONLINE_SPEC.SHOP_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long shopId;

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
     *    上线详情ID
     *
     *    数据库字段: ONL_ONLINE_SPEC.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getId() {
        return id;
    }

    /**
     *    上线详情ID
     *
     *    数据库字段: ONL_ONLINE_SPEC.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *    上线ID
     *
     *    数据库字段: ONL_ONLINE_SPEC.ONLINE_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getOnlineId() {
        return onlineId;
    }

    /**
     *    上线ID
     *
     *    数据库字段: ONL_ONLINE_SPEC.ONLINE_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOnlineId(Long onlineId) {
        this.onlineId = onlineId;
    }

    /**
     *    产品详情ID
     *
     *    数据库字段: ONL_ONLINE_SPEC.PRODUCT_SPEC_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getProductSpecId() {
        return productSpecId;
    }

    /**
     *    产品详情ID
     *
     *    数据库字段: ONL_ONLINE_SPEC.PRODUCT_SPEC_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setProductSpecId(Long productSpecId) {
        this.productSpecId = productSpecId;
    }

    /**
     *    上线详情名称
     *
     *    数据库字段: ONL_ONLINE_SPEC.ONLINE_SPEC
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getOnlineSpec() {
        return onlineSpec;
    }

    /**
     *    上线详情名称
     *
     *    数据库字段: ONL_ONLINE_SPEC.ONLINE_SPEC
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOnlineSpec(String onlineSpec) {
        this.onlineSpec = onlineSpec;
    }

    /**
     *    销售价格(单价)
     *
     *    数据库字段: ONL_ONLINE_SPEC.SALE_PRICE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public BigDecimal getSalePrice() {
        return salePrice;
    }

    /**
     *    销售价格(单价)
     *
     *    数据库字段: ONL_ONLINE_SPEC.SALE_PRICE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    /**
     *    成本价格
     *
     *    数据库字段: ONL_ONLINE_SPEC.COST_PRICE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public BigDecimal getCostPrice() {
        return costPrice;
    }

    /**
     *    成本价格
     *
     *    数据库字段: ONL_ONLINE_SPEC.COST_PRICE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    /**
     *    返现金额
     *
     *    数据库字段: ONL_ONLINE_SPEC.CASHBACK_AMOUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public BigDecimal getCashbackAmount() {
        return cashbackAmount;
    }

    /**
     *    返现金额
     *
     *    数据库字段: ONL_ONLINE_SPEC.CASHBACK_AMOUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setCashbackAmount(BigDecimal cashbackAmount) {
        this.cashbackAmount = cashbackAmount;
    }

    /**
     *    返佣金额
     *
     *    数据库字段: ONL_ONLINE_SPEC.COMMISSION_AMOUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public BigDecimal getCommissionAmount() {
        return commissionAmount;
    }

    /**
     *    返佣金额
     *
     *    数据库字段: ONL_ONLINE_SPEC.COMMISSION_AMOUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setCommissionAmount(BigDecimal commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    /**
     *    购买积分
     *
     *    数据库字段: ONL_ONLINE_SPEC.BUY_POINT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public BigDecimal getBuyPoint() {
        return buyPoint;
    }

    /**
     *    购买积分
     *
     *    数据库字段: ONL_ONLINE_SPEC.BUY_POINT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setBuyPoint(BigDecimal buyPoint) {
        this.buyPoint = buyPoint;
    }

    /**
     *    首单积分
     *
     *    数据库字段: ONL_ONLINE_SPEC.FIRST_BUY_POINT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public BigDecimal getFirstBuyPoint() {
        return firstBuyPoint;
    }

    /**
     *    首单积分
     *
     *    数据库字段: ONL_ONLINE_SPEC.FIRST_BUY_POINT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setFirstBuyPoint(BigDecimal firstBuyPoint) {
        this.firstBuyPoint = firstBuyPoint;
    }

    /**
     *    销售单位
     *
     *    数据库字段: ONL_ONLINE_SPEC.SALE_UNIT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getSaleUnit() {
        return saleUnit;
    }

    /**
     *    销售单位
     *
     *    数据库字段: ONL_ONLINE_SPEC.SALE_UNIT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSaleUnit(String saleUnit) {
        this.saleUnit = saleUnit;
    }

    /**
     *    当前上线数量（每次追加的数量）
     *
     *    数据库字段: ONL_ONLINE_SPEC.CURRENT_ONLINE_COUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public BigDecimal getCurrentOnlineCount() {
        return currentOnlineCount;
    }

    /**
     *    当前上线数量（每次追加的数量）
     *
     *    数据库字段: ONL_ONLINE_SPEC.CURRENT_ONLINE_COUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setCurrentOnlineCount(BigDecimal currentOnlineCount) {
        this.currentOnlineCount = currentOnlineCount;
    }

    /**
     *    限制购买数量(默认为0，不限制)
     *                每个人限制购买的数量
     *
     *    数据库字段: ONL_ONLINE_SPEC.LIMIT_COUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public BigDecimal getLimitCount() {
        return limitCount;
    }

    /**
     *    限制购买数量(默认为0，不限制)
     *                每个人限制购买的数量
     *
     *    数据库字段: ONL_ONLINE_SPEC.LIMIT_COUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setLimitCount(BigDecimal limitCount) {
        this.limitCount = limitCount;
    }

    /**
     *    销售数量
     *
     *    数据库字段: ONL_ONLINE_SPEC.SALE_COUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public BigDecimal getSaleCount() {
        return saleCount;
    }

    /**
     *    销售数量
     *
     *    数据库字段: ONL_ONLINE_SPEC.SALE_COUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSaleCount(BigDecimal saleCount) {
        this.saleCount = saleCount;
    }

    /**
     *    排序号
     *
     *    数据库字段: ONL_ONLINE_SPEC.SEQ_NO
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Integer getSeqNo() {
        return seqNo;
    }

    /**
     *    排序号
     *
     *    数据库字段: ONL_ONLINE_SPEC.SEQ_NO
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    /**
     *    是否有首单
     *
     *    数据库字段: ONL_ONLINE_SPEC.IS_HAVE_FIRST_ORDER
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Boolean getIsHaveFirstOrder() {
        return isHaveFirstOrder;
    }

    /**
     *    是否有首单
     *
     *    数据库字段: ONL_ONLINE_SPEC.IS_HAVE_FIRST_ORDER
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setIsHaveFirstOrder(Boolean isHaveFirstOrder) {
        this.isHaveFirstOrder = isHaveFirstOrder;
    }

    /**
     *    店铺ID
     *
     *    数据库字段: ONL_ONLINE_SPEC.SHOP_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     *    店铺ID
     *
     *    数据库字段: ONL_ONLINE_SPEC.SHOP_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
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
        sb.append(", productSpecId=").append(productSpecId);
        sb.append(", onlineSpec=").append(onlineSpec);
        sb.append(", salePrice=").append(salePrice);
        sb.append(", costPrice=").append(costPrice);
        sb.append(", cashbackAmount=").append(cashbackAmount);
        sb.append(", commissionAmount=").append(commissionAmount);
        sb.append(", buyPoint=").append(buyPoint);
        sb.append(", firstBuyPoint=").append(firstBuyPoint);
        sb.append(", saleUnit=").append(saleUnit);
        sb.append(", currentOnlineCount=").append(currentOnlineCount);
        sb.append(", limitCount=").append(limitCount);
        sb.append(", saleCount=").append(saleCount);
        sb.append(", seqNo=").append(seqNo);
        sb.append(", isHaveFirstOrder=").append(isHaveFirstOrder);
        sb.append(", shopId=").append(shopId);
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
        OnlOnlineSpecMo other = (OnlOnlineSpecMo) that;
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
