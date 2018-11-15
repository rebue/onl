package rebue.onl.to;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * 下单后更新上线规格信息的传输对象
 */
@Data
@JsonInclude(Include.NON_NULL)
public class UpdateOnlineSpecAfterOrderTo {

    /**
     * 上线ID
     */
    private Long    onlineId;

    /**
     * 上线规格ID
     */
    private Long    onlineSpecId;

    /**
     * 购买数量
     */
    private Integer buyCount;

    /**
     * 购物车ID
     */
    private Long    cartId;

}
