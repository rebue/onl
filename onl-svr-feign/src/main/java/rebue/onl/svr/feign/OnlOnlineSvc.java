package rebue.onl.svr.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import rebue.onl.mo.OnlOnlineMo;
import rebue.sbs.feign.FeignConfig;

/**  
* 创建时间：2018年4月10日 下午4:07:31  
* 项目名称：onl-svr-feign  
* @author daniel  
* @version 1.0   
* @since JDK 1.8  
* 文件名称：OnlOnlineSvc.java  
* 类说明：  
*/
@FeignClient(name = "onl-svr", configuration = FeignConfig.class)
public interface OnlOnlineSvc {

	/**
	 * 查询是否已上线
	 * Title: existSelective
	 * Description: 
	 * @param qo
	 * @return
	 * @date 2018年4月10日 下午4:06:26
	 */
	@GetMapping("/onl/online/exist")
	boolean existSelective(OnlOnlineMo qo);
}
  

