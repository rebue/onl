package rebue.onl.svr.feign;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.ro.ModifyOnlineSpecInfoRo;
import rebue.onl.ro.OnlOnlineSpecInfoRo;
import rebue.onl.to.ModifySaleCountByIdTo;
import rebue.robotech.ro.Ro;
import rebue.sbs.feign.FeignConfig;

/**
 * 创建时间：2018年4月10日 下午2:30:04
 * 项目名称：onl-svr-feign
 * 
 * @author daniel
 * @version 1.0
 * @since JDK 1.8
 *        文件名称：OnlOnlSpecSvc.java
 *        类说明： 上线规格对内接口
 */
@FeignClient(name = "onl-svr", configuration = FeignConfig.class)
public interface OnlOnlineSpecSvc {

    /**
     * 获取单个上线规格
     */
    @GetMapping("/onl/onlinespec/getbyid")
    OnlOnlineSpecMo getById(@RequestParam("id") Long id);

    /**
     * 根据上线规格id修改销售数量(减)
     */
    @PutMapping(value = "/onl/onlinespec/modifysalecountbyid")
    Ro modifySaleCountById(@RequestParam("id") Long id, @RequestParam("buyCount") Integer buyCount);

    /**
     * 获取上线规格信息 Title: selectOnlineSpecInfoByOnlineId Description:
     */
    @GetMapping(value = "/onl/onlinespec/details")
    List<OnlOnlineSpecInfoRo> selectOnlineSpecInfo(@RequestParam("onlineId") Long onlineId, @RequestParam("onlineSpec") String onlineSpec);

//    /**
//     * 删除购物车和修改上线数量
//     */
//    @PostMapping(value = "/onl/onlinespec/deleteandupdate")
//    Ro deleteCartAndUpdateOnlineCount(@RequestBody List<UpdateOnlineAfterOrderTo> list);
}
