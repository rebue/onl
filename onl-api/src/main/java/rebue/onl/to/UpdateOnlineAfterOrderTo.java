package rebue.onl.to;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * 下单后更新上线信息的传输对象
 */
@Data
@JsonInclude(Include.NON_NULL)
public class UpdateOnlineAfterOrderTo {

    /**
     * 下单用户的ID
     */
    private Long                               userId;

    /**
     * 
     */
    private List<UpdateOnlineSpecAfterOrderTo> specList;

}
