package rebue.onl.to;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class OnlOnlineSpecTo {
    /**
     * 上线规格ID
     *
     * 数据库字段: ONL_ONLINE_SPEC.ID
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long id;

    /**
     * 产品详情id
     */
    private Long productSpecId;

    /**
     * 上线ID
     *
     * 数据库字段: ONL_ONLINE_SPEC.ONLINE_ID
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long onlineId;

    /**
     * 上线规格
     *
     * 数据库字段: ONL_ONLINE_SPEC.ONLINE_SPEC
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String onlineSpec;

    /**
     * 销售价格
     *
     * 数据库字段: ONL_ONLINE_SPEC.SALE_PRICE
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal salePrice;

    /**
     * 成本价格
     *
     * 数据库字段: ONL_ONLINE_SPEC.COST_PRICE
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal costPrice;

    /**
     * 返现金额
     *
     * 数据库字段: ONL_ONLINE_SPEC.CASHBACK_AMOUNT
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal cashbackAmount;

    /**
     * 返佣金额
     *
     * 数据库字段: ONL_ONLINE_SPEC.COMMISSION_AMOUNT
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal commissionAmount;

    /**
     * 销售单位
     *
     * 数据库字段: ONL_ONLINE_SPEC.SALE_UNIT
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String saleUnit;

    /**
     * 上线总数
     *
     * 数据库字段: ONL_ONLINE_SPEC.ONLINE_TOTAL
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal onlineTotal;

    /**
     * 销售数量
     *
     * 数据库字段: ONL_ONLINE_SPEC.SALE_COUNT
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal saleCount;

    /**
     * 限制购买数量(默认为0，不限制) 每个人限制购买的数量
     *
     * 数据库字段: ONL_ONLINE_SPEC.LIMIT_COUNT
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal limitCount;

    /**
     * 排序号
     *
     * 数据库字段: ONL_ONLINE_SPEC.SEQ_NO
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Integer seqNo;

    /**
     * 购买数量
     */
    private BigDecimal buyCount;

    /**
     * 当前上线数量（每次追加的数量）
     */
    private BigDecimal currentOnlineCount;

    /**
     * 已上线总数
     */
    private BigDecimal alreadyOnlineTotal;

    /**
     * 购买积分
     */
    private BigDecimal buyPoint;

    /**
     * 首单积分
     */
    private BigDecimal firstBuyPoint;

}
