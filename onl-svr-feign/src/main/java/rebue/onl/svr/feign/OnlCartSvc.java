package rebue.onl.svr.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;

import rebue.onl.mo.OnlCartMo;
import rebue.sbs.feign.FeignConfig;

/**  
* 创建时间：2018年4月10日 下午6:09:41  
* 项目名称：onl-svr-feign  
* @author daniel  
* @version 1.0   
* @since JDK 1.8  
* 文件名称：OnlOnlineCartSvc.java  
* 类说明：  购物车对内接口
*/
@FeignClient(name = "onl-svr", configuration = FeignConfig.class)
public interface OnlCartSvc {

	/**
	 * 删除购物车 
	 * Title: del 
	 * Description:
	 * 
	 * @param id
	 * @return
	 * @date 2018年3月29日 下午2:54:51
	 */
	@DeleteMapping("/onl/cart")
	Map<String, Object> del(OnlCartMo vo);
}
  

