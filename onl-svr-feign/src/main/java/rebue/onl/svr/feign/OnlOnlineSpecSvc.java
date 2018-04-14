package rebue.onl.svr.feign;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import rebue.onl.ro.OnlOnlineSpecInfoRo;
import rebue.sbs.feign.FeignConfig;

/**  
* 创建时间：2018年4月10日 下午2:30:04  
* 项目名称：onl-svr-feign  
* @author daniel  
* @version 1.0   
* @since JDK 1.8  
* 文件名称：OnlOnlSpecSvc.java  
* 类说明：  上线规格对内接口
*/
@FeignClient(name = "onl-svr", configuration = FeignConfig.class)
public interface OnlOnlineSpecSvc {

	/**
	 * 修改上线规格信息
	 * Title: updateSelective
	 * Description: 
	 * @param mo
	 * @return
	 * @date 2018年4月10日 下午2:31:56
	 */
	@PutMapping(value = "/onl/onlinespec", produces="application/json")
	Map<String, Object> updateSelective(@RequestParam("onlineId") Long onlineId, @RequestParam("onlineSpec") String onlineSpec, @RequestParam("saleCount") Integer saleCount);
	
	/**
	 * 获取上线规格信息 Title: selectOnlineSpecInfoByOnlineId Description:
	 * 
	 * @param record
	 * @return
	 * @date 2018年4月1日 下午4:29:31
	 */
	@GetMapping(value = "/onl/onlinespec/details", produces="application/json")
	List<OnlOnlineSpecInfoRo> selectOnlineSpecInfo(@RequestParam("onlineId") Long onlineId, @RequestParam("onlineSpec") String onlineSpec);
	
	/**
	 * 删除购物车和修改上线数量
	 * Title: deleteCartAndUpdateOnlineCount
	 * Description: 
	 * @return
	 * @date 2018年4月11日 下午5:52:30
	 */
	@PostMapping(value = "/onl/onlinespec/deleteandupdate", produces="application/json")
	Map<String, Object> deleteCartAndUpdateOnlineCount(@RequestParam("cartAndSpecInfo") String cartAndSpecInfo);
}
  

