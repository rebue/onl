package rebue.onl.mo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 上线规格日志
 *
 * 数据库表: ONL_ONLINE_SPEC_LOG
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@JsonInclude(Include.NON_NULL)
public class OnlOnlineSpecLogMo implements Serializable {

    /**
     *    上线规格日志ID
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long id;

    /**
     *    上线日志ID
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.ONLINE_LOG_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long onlineLogId;

    /**
     *    上线ID
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.ONLINE_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long onlineId;

    /**
     *    上线规格
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.ONLINE_SPEC
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String onlineSpec;

    /**
     *    销售价格
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.SALE_PRICE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal salePrice;

    /**
     *    返现金额
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.CASHBACK_AMOUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal cashbackAmount;

    /**
     *    返佣金额
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.COMMISSION_AMOUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal commissionAmount;

    /**
     *    销售单位
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.SALE_UNIT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String saleUnit;

    /**
     *    上线总数
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.ONLINE_TOTAL
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Integer onlineTotal;

    /**
     *    销售数量
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.SALE_COUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Integer saleCount;

    /**
     *    排序号
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.SEQ_NO
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Integer seqNo;

    /**
     *    当前上线数量（每次追加的数量）
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.CURRENT_ONLINE_COUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Integer currentOnlineCount;

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
     *    上线规格日志ID
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getId() {
        return id;
    }

    /**
     *    上线规格日志ID
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *    上线日志ID
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.ONLINE_LOG_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getOnlineLogId() {
        return onlineLogId;
    }

    /**
     *    上线日志ID
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.ONLINE_LOG_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOnlineLogId(Long onlineLogId) {
        this.onlineLogId = onlineLogId;
    }

    /**
     *    上线ID
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.ONLINE_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getOnlineId() {
        return onlineId;
    }

    /**
     *    上线ID
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.ONLINE_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOnlineId(Long onlineId) {
        this.onlineId = onlineId;
    }

    /**
     *    上线规格
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.ONLINE_SPEC
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getOnlineSpec() {
        return onlineSpec;
    }

    /**
     *    上线规格
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.ONLINE_SPEC
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOnlineSpec(String onlineSpec) {
        this.onlineSpec = onlineSpec;
    }

    /**
     *    销售价格
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.SALE_PRICE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public BigDecimal getSalePrice() {
        return salePrice;
    }

    /**
     *    销售价格
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.SALE_PRICE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    /**
     *    返现金额
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.CASHBACK_AMOUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public BigDecimal getCashbackAmount() {
        return cashbackAmount;
    }

    /**
     *    返现金额
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.CASHBACK_AMOUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setCashbackAmount(BigDecimal cashbackAmount) {
        this.cashbackAmount = cashbackAmount;
    }

    /**
     *    返佣金额
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.COMMISSION_AMOUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public BigDecimal getCommissionAmount() {
        return commissionAmount;
    }

    /**
     *    返佣金额
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.COMMISSION_AMOUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setCommissionAmount(BigDecimal commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    /**
     *    销售单位
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.SALE_UNIT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getSaleUnit() {
        return saleUnit;
    }

    /**
     *    销售单位
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.SALE_UNIT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSaleUnit(String saleUnit) {
        this.saleUnit = saleUnit;
    }

    /**
     *    上线总数
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.ONLINE_TOTAL
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Integer getOnlineTotal() {
        return onlineTotal;
    }

    /**
     *    上线总数
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.ONLINE_TOTAL
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOnlineTotal(Integer onlineTotal) {
        this.onlineTotal = onlineTotal;
    }

    /**
     *    销售数量
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.SALE_COUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Integer getSaleCount() {
        return saleCount;
    }

    /**
     *    销售数量
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.SALE_COUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    /**
     *    排序号
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.SEQ_NO
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Integer getSeqNo() {
        return seqNo;
    }

    /**
     *    排序号
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.SEQ_NO
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    /**
     *    当前上线数量（每次追加的数量）
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.CURRENT_ONLINE_COUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Integer getCurrentOnlineCount() {
        return currentOnlineCount;
    }

    /**
     *    当前上线数量（每次追加的数量）
     *
     *    数据库字段: ONL_ONLINE_SPEC_LOG.CURRENT_ONLINE_COUNT
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setCurrentOnlineCount(Integer currentOnlineCount) {
        this.currentOnlineCount = currentOnlineCount;
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
        sb.append(", onlineLogId=").append(onlineLogId);
        sb.append(", onlineId=").append(onlineId);
        sb.append(", onlineSpec=").append(onlineSpec);
        sb.append(", salePrice=").append(salePrice);
        sb.append(", cashbackAmount=").append(cashbackAmount);
        sb.append(", commissionAmount=").append(commissionAmount);
        sb.append(", saleUnit=").append(saleUnit);
        sb.append(", onlineTotal=").append(onlineTotal);
        sb.append(", saleCount=").append(saleCount);
        sb.append(", seqNo=").append(seqNo);
        sb.append(", currentOnlineCount=").append(currentOnlineCount);
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
        OnlOnlineSpecLogMo other = (OnlOnlineSpecLogMo) that;
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
