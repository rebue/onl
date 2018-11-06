package rebue.onl.to;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * 删除购物车和修改库存
 */
@Data
@JsonInclude(Include.NON_NULL)
public class DeleteCartAndModifyInventoryTo {

    /**
     * 购物车ID
     */
    private Long    cartId;

    /**
     * 上线ID
     */
    private Long    onlineId;

    /**
     * 上线规格
     */
    private String  onlineSpec;

    /**
     * 购买数量
     */
    private Integer buyCount;

}
