package rebue.onl.ro;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class OnlOnlineSpecEsRo {
    /**
     * 上线规格ID
     */
    private Long id;

    /**
     * 上线ID
     */
    private Long onlineId;

    /**
     * 产品规格ID
     */
    private Long productSpecId;

    /**
     * 上线规格名称
     */
    private String onlineSpec;

    /**
     * 销售价格(单价)
     */
    private BigDecimal salePrice;

    /**
     * 成本价格
     */
    private BigDecimal costPrice;

    /**
     * 返现金额
     */
    private BigDecimal cashbackAmount;

    /**
     * 返佣金额
     */
    private BigDecimal commissionAmount;

    /**
     * 购买积分
     */
    private BigDecimal buyPoint;

    /**
     * 首单积分
     */
    private BigDecimal firstBuyPoint;

    /**
     * 销售单位
     */
    private String saleUnit;

    /**
     * 当前上线数量（每次追加的数量）
     */
    private BigDecimal currentOnlineCount;

    /**
     * 限制购买数量(默认为0，不限制)
     * 每个人限制购买的数量
     */
    private BigDecimal limitCount;

    /**
     * 销售数量
     */
    private BigDecimal saleCount;

    /**
     * 排序号
     */
    private Integer seqNo;

    /**
     * 是否有首单
     */
    private Boolean isHaveFirstOrder;

    /**
     * 是否是称重商品
     */
    private Boolean           isWeighGoods;
    private static final long serialVersionUID = 1L;
}
