package rebue.onl.ro;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
@Data
@JsonInclude(Include.NON_NULL)
public class SupplierGoodsRo {
	
    /**
     *    上线ID
     *

     */
    private Long id;

    /**
     *    板块类型（0：普通，1：全返）

     */
    private Byte subjectType;

    /**
     *    上线标题

     */
    private String onlineTitle;

    /**
     *    上线描述

     */
    private String onlineDetail;


    /**
     *    上线状态（0：下线，1：上线  ）

     */
    private Byte onlineState;

    /**
     *    上线时间

     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date onlineTime;



    /**
     *    发货组织ID(默认填入上线组织ID，可变更为供应商的ID)

     */
    private Long deliverOrgId;

}
