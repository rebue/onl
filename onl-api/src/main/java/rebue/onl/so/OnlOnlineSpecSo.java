package rebue.onl.so;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import rebue.robotech.so.So;

/**
 * 上线规格搜索对象
 * 
 */
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class OnlOnlineSpecSo extends So implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 上线ID
     *
     */
    private Long onlineId;

    /**
     * 上线规格名称
     *
     */
    private String onlineSpec;

    /**
     * 销售价格(单价)
     *
     */
    private BigDecimal salePrice;

    /**
     * 成本价格
     *
     */
    private BigDecimal costPrice;

    /**
     * 返现金额
     *
     */
    private BigDecimal cashbackAmount;

    /**
     * 返佣金额
     *
     */
    private BigDecimal commissionAmount;

    /**
     * 购买积分
     *
     */
    private BigDecimal buyPoint;

    /**
     * 首单积分
     *
     */
    private BigDecimal firstBuyPoint;

    /**
     * 销售单位
     *
     */
    private String saleUnit;

    /**
     * 限制购买数量(默认为0，不限制)
     * 每个人限制购买的数量
     *
     */
    private BigDecimal limitCount;

}
