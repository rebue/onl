package rebue.onl.to;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class SupplierGoodsTo {
	
	

    /**
     *    板块类型（0：普通，1：全返）
     *
     */
    private Byte subjectType;
    

    /**
     *    上线标题
     *
     */
    private String onlineTitle;
    
    /**
     *    上线状态（0：下线，1：上线  ）
     */
    private Byte onlineState;
	
    /**
     * 下单时间段 开始
     */
    @ApiModelProperty(value = "申请时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date   onlineTimeStart;
    /**
     * 下单时间段 结束
     */
    @ApiModelProperty(value = "申请时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date   onlineTimeEnd;
    
    /**
     *    供应商ID
     *

     */
    private Long supplierId;
	
}
