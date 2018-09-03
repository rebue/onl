package rebue.onl.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rebue.onl.mo.OnlOnlinePromotionMo;
import rebue.onl.svc.OnlOnlinePromotionSvc;
import com.github.pagehelper.PageInfo;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class OnlOnlinePromotionCtrl {
	/**
	 * @mbg.generated
	 */
	private final static Logger _log = LoggerFactory
			.getLogger(OnlOnlinePromotionCtrl.class);

	/**
	 * @mbg.generated
	 */
	@Resource
	private OnlOnlinePromotionSvc svc;

	/**
	 * 修改上线推广
	 * 
	 * @mbg.generated
	 */
	@PutMapping("/onl/onlinepromotion")
	Map<String, Object> modify(OnlOnlinePromotionMo vo) throws Exception {
		_log.info("modify OnlOnlinePromotionMo:" + vo);
		svc.modify(vo);
		Map<String, Object> result = new HashMap<>();
		result.put("success", true);
		_log.info("modify OnlOnlinePromotionMo success!");
		return result;
	}

	/**
	 * 查询上线推广
	 * 
	 * @mbg.generated
	 */
	@GetMapping("/onl/onlinepromotion")
	PageInfo<OnlOnlinePromotionMo> list(OnlOnlinePromotionMo qo,
			@RequestParam("pageNum") int pageNum,
			@RequestParam("pageSize") int pageSize) {
		_log.info("list OnlOnlinePromotionMo:" + qo + ", pageNum = " + pageNum
				+ ", pageSize = " + pageSize);

		if (pageSize > 50) {
			String msg = "pageSize不能大于50";
			_log.error(msg);
			throw new IllegalArgumentException(msg);
		}

		PageInfo<OnlOnlinePromotionMo> result = svc.list(qo, pageNum, pageSize);
		_log.info("result: " + result);
		return result;
	}

	/**
	 * 获取单个上线推广
	 * 
	 * @mbg.generated
	 */
	@GetMapping("/onl/onlinepromotion/{id}")
	OnlOnlinePromotionMo get(@PathVariable("id") java.lang.Long id) {
		_log.info("get OnlOnlinePromotionMo by id: " + id);
		OnlOnlinePromotionMo result = svc.getById(id);
		_log.info("get: " + result);
		return result;
	}

	/**
	 * 添加上线推广 Title: add Description:
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 * @date 2018年3月28日 下午4:30:00
	 */
	@PostMapping("/onl/onlinepromotion")
	Map<String, Object> add(OnlOnlinePromotionMo vo) throws Exception {
		_log.info("开始上线商品推广，添加上线商品推广的参数为：" + vo.toString());
		boolean flag = svc.existSelective(vo);
		_log.info("判断改商品是否已推广：{}", flag);
		Map<String, Object> resultMap = new HashMap<>();
		if (flag) {
			_log.error("上线编号为：{}，上线商品推广失败", vo.getId());
			resultMap.put("msg", "该商品已推广");
			resultMap.put("result", -14);
		} else {
			int result = svc.add(vo);
			if (result < 1) {
				_log.error("上线编号为：{}，上线商品推广失败", vo.getId());
				resultMap.put("msg", "推广失败");
				resultMap.put("result", result);
			} else {
				_log.info("上线编号为：{}，上线商品推广成功", vo.getId());
				resultMap.put("msg", "推广成功");
				resultMap.put("result", result);
			}
		}
		return resultMap;
	}

	/**
	 * 删除上线推广 Title: del Description:
	 * 
	 * @param id
	 * @return
	 * @date 2018年3月28日 下午4:29:55
	 */
	@DeleteMapping("/onl/onlinepromotion/{onlineId}")
	Map<String, Object> del(@PathVariable("onlineId") java.lang.Long onlineId) {
		_log.info("开始删除上线商品推广，删除上线商品推广的参数为：" + onlineId);
		Map<String, Object> resultMap = new HashMap<>();
		if (onlineId != 0) {
			int result = svc.del(onlineId);
			if (result < 1) {
				_log.error("推广上线商品编号为：{}，删除上线商品推广失败", onlineId);
				resultMap.put("msg", "删除失败");
				resultMap.put("result", result);
			} else {
				_log.info("推广上线商品编号为：{}，删除上线商品推广成功", onlineId);
				resultMap.put("msg", "删除成功");
				resultMap.put("result", result);
			}
		} else {
			_log.error("推广上线商品不存在，删除上线商品推广失败", onlineId);
			resultMap.put("msg", "上线推广商品不存在");
			resultMap.put("result", -12);
		}
		return resultMap;
	}

	/**
	 * 查询上线推广是否存在 Title: existSelective Description:
	 * 
	 * @param vo
	 * @return
	 * @date 2018年3月28日 下午5:37:01
	 */
	@GetMapping("/onl/onlinepromotion/exist")
	boolean existSelective(OnlOnlinePromotionMo vo) {
		return svc.existSelective(vo);
	}

	/**
	 * 查询推广上线商品列表 Title: list Description:
	 * 
	 * @return
	 * @throws JsonProcessingException
	 * @date 2018年3月29日 上午11:44:12
	 */
	@GetMapping("/onl/onlinepromotion/list")
	List<Map<String, Object>> list() throws JsonProcessingException {
		return svc.promotionOnlineGoodsList();
	}

}
