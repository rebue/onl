package rebue.onl.ctrl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.svc.OnlOnlineSpecSvc;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rebue.onl.ro.OnlOnlineSpecInfoRo;

@RestController
public class OnlOnlineSpecCtrl {
	/**
	 * @mbg.generated
	 */
	private final static Logger _log = LoggerFactory.getLogger(OnlOnlineSpecCtrl.class);

	/**
	 * @mbg.generated
	 */
	@Resource
	private OnlOnlineSpecSvc svc;

	/**
	 * 查询上线规格
	 * 
	 * @mbg.generated
	 */
	@GetMapping("/onl/onlinespec")
	PageInfo<OnlOnlineSpecMo> list(OnlOnlineSpecMo qo, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
		_log.info("list OnlOnlineSpecMo:" + qo + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
		if (pageSize > 50) {
			String msg = "pageSize不能大于50";
			_log.error(msg);
			throw new IllegalArgumentException(msg);
		}
		PageInfo<OnlOnlineSpecMo> result = svc.list(qo, pageNum, pageSize);
		_log.info("result: " + result);
		return result;
	}

	/**
	 * 获取上线规格信息 Title: selectOnlineSpecInfoByOnlineId Description:
	 * 
	 * @param record
	 * @return
	 * @date 2018年4月1日 下午4:29:31
	 */
	@GetMapping("/onl/onlinespec/details")
	List<OnlOnlineSpecInfoRo> selectOnlineSpecInfo(OnlOnlineSpecMo mo) {
		_log.info("根据上线编号获取上线规格信息的参数为：{}", mo.toString());
		return svc.selectOnlineSpecInfo(mo);
	}

	/**
	 * 修改上线规格信息
	 * Title: updateSelective
	 * Description: 
	 * @param mo
	 * @return
	 * @date 2018年4月10日 下午2:28:28
	 */
	@PutMapping("/onl/onlinespec")
	Map<String, Object> updateSelective(OnlOnlineSpecMo mo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			int result = svc.updateSelective(mo);
			resultMap.put("result", result);
			resultMap.put("msg", "修改成功");
			return resultMap;
		} catch (RuntimeException e) {
			String msg = e.getMessage();
			if (msg.equals("修改上线规格信息失败")) {
				resultMap.put("result", -1);
				resultMap.put("msg", "修改失败");
			}
			return resultMap;
		}
	}
}
