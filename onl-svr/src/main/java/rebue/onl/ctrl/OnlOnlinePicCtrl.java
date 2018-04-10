package rebue.onl.ctrl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import rebue.onl.mo.OnlOnlinePicMo;
import rebue.onl.svc.OnlOnlinePicSvc;
import java.util.List;

@RestController
public class OnlOnlinePicCtrl {
	/**
	 * @mbg.generated
	 */
	private final static Logger _log = LoggerFactory.getLogger(OnlOnlinePicCtrl.class);

	/**
	 * @mbg.generated
	 */
	@Resource
	private OnlOnlinePicSvc svc;

	/**
	 * 查询上线商品轮播图 Title: list Description:
	 * 
	 * @param qo
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @date 2018年4月1日 下午2:48:16
	 */
	@GetMapping("/onl/onlinepic")
	List<OnlOnlinePicMo> list(OnlOnlinePicMo qo) {
		_log.info("获取上线商品轮播图的上线编号为：{}", qo.getOnlineId());
		return svc.list(qo);
	}

}
