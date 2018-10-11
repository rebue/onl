package rebue.onl.svr.feign;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import rebue.onl.ro.DeleteCartAndModifyInventoryRo;
import rebue.onl.ro.ModifyOnlineSpecInfoRo;
import rebue.onl.ro.OnlOnlineSpecInfoRo;
import rebue.onl.to.DeleteCartAndModifyInventoryTo;
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
	 * 查询并修改上线规格信息
	 * Title: updateSpenInfo
	 * Description: 
	 * @param specList
	 * @return
	 * @date 2018年4月23日 下午6:18:40
	 */
	@PostMapping(value = "/onl/onlinespec/selectandupdate")
	ModifyOnlineSpecInfoRo modifyOnlineSpecInfo(@RequestBody List<Map<String, Object>> specList);
	
	/**
	 * 获取上线规格信息 Title: selectOnlineSpecInfoByOnlineId Description:
	 * 
	 * @param record
	 * @return
	 * @date 2018年4月1日 下午4:29:31
	 */
	@GetMapping(value = "/onl/onlinespec/details")
	List<OnlOnlineSpecInfoRo> selectOnlineSpecInfo(@RequestParam("onlineId") Long onlineId, @RequestParam("onlineSpec") String onlineSpec);
	
	/**
	 * 删除购物车和修改上线数量
	 * Title: deleteCartAndUpdateOnlineCount
	 * Description: 
	 * @return
	 * @date 2018年4月11日 下午5:52:30
	 */
	@PostMapping(value = "/onl/onlinespec/deleteandupdate")
	DeleteCartAndModifyInventoryRo deleteCartAndUpdateOnlineCount(@RequestBody List<DeleteCartAndModifyInventoryTo> list);
}
  

