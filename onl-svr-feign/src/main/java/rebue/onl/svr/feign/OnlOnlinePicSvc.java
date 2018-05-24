package rebue.onl.svr.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rebue.onl.mo.OnlOnlinePicMo;
import rebue.sbs.feign.FeignConfig;

/**  
* 创建时间：2018年4月19日 上午11:36:40  
* 项目名称：onl-svr-feign  
* @author daniel  
* @version 1.0   
* @since JDK 1.8  
* 文件名称：OnlOnlinePicSvc.java  
* 类说明：  商品图片对内接口
*/
@FeignClient(name = "onl-svr", configuration = FeignConfig.class)
public interface OnlOnlinePicSvc {

	/**
	 * 查询上线商品轮播图 Title: list Description:
	 * 
	 * @param qo
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @date 2018年4月1日 下午2:48:16
	 */
	@GetMapping(value = "/onl/onlinepic", produces = "application/json;charset=UTF-8")
	List<OnlOnlinePicMo> list(@RequestParam("onlineId") Long onlineId, @RequestParam("picType") Byte picType);
}
  

