package rebue.onl.ctrl;

import java.io.IOException;
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

import rebue.onl.mo.OnlOnlineMo;
import rebue.onl.svc.OnlOnlineSvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageInfo;
import java.util.List;
import rebue.onl.ro.OnlOnlineGoodsInfoRo;

@RestController
public class OnlOnlineCtrl {
	/**
	 */
	private final static Logger _log = LoggerFactory
			.getLogger(OnlOnlineCtrl.class);

	/**
	 */
	@Resource
	private OnlOnlineSvc svc;

	/**
	 * 删除上线信息
	 * 
	 * @mbg.generated
	 */
	@DeleteMapping("/onl/online/{id}")
	Map<String, Object> del(@PathVariable("id") java.lang.Long id) {
		_log.info("save OnlOnlineMo:" + id);
		svc.del(id);
		Map<String, Object> result = new HashMap<>();
		result.put("success", true);
		_log.info("delete OnlOnlineMo success!");
		return result;
	}

	/**
	 * 获取单个上线信息
	 * 
	 * @mbg.generated
	 */
	@GetMapping("/onl/online/{id}")
	OnlOnlineMo get(@PathVariable("id") java.lang.Long id) {
		_log.info("get OnlOnlineMo by id: " + id);
		OnlOnlineMo result = svc.getById(id);
		_log.info("get: " + result);
		return result;
	}

	/**
	 * 添加上线信息
	 */
	@PostMapping("/onl/online")
	Map<String, Object> add(String onlineInfo) throws Exception {
		_log.info("开始发布商品，发布商品的参数为：" + onlineInfo);
		return svc.addEx(onlineInfo);
	}

	/**
	 * 根据条件分页查询商品上线信息 Title: list Description:
	 * 
	 * @param qo
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @date 2018年3月28日 下午3:06:09
	 */
	@GetMapping("/onl/online")
	PageInfo<OnlOnlineMo> list(OnlOnlineMo qo,
			@RequestParam("pageNum") int pageNum,
			@RequestParam("pageSize") int pageSize) {
		_log.info("list OnlOnlineSpecMo:" + qo + ", pageNum = " + pageNum
				+ ", pageSize = " + pageSize);
		if (pageSize > 50) {
			String msg = "pageSize不能大于50";
			_log.error(msg);
			throw new IllegalArgumentException(msg);
		}
		PageInfo<OnlOnlineMo> result = svc.list(qo, pageNum, pageSize);
		_log.info("result: " + result);
		return result;
	}

	/**
	 * 商品下线 Title: modify Description:
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 * @date 2018年3月28日 下午3:14:23
	 */
	@PutMapping("/onl/online")
	Map<String, Object> modify(OnlOnlineMo vo) throws Exception {
		_log.info("开始商品下线，商品下线的参数为：" + vo.toString());
		int result = svc.modify(vo);
		Map<String, Object> resultMap = new HashMap<>();
		if (result < 1) {
			resultMap.put("msg", "下线失败");
			resultMap.put("result", result);
			_log.error("上线编号：{}，下线失败", vo.getId());
		} else {
			resultMap.put("msg", "下线成功");
			resultMap.put("result", result);
			_log.info("上线编号：{}，下线成功!", vo.getId());
		}
		return resultMap;
	}

	/**
	 * 获取上线商品列表 Title: selectOnlineGoodsList Description:
	 * 
	 * @return
	 * @date 2018年3月29日 下午5:42:46
	 */
	@GetMapping("/onl/online/list")
	List<OnlOnlineGoodsInfoRo> selectOnlineGoodsList(
			@RequestParam Map<String, Object> map) {
		_log.info("获取上线商品列表的参数为：{}", String.valueOf(map));
		return svc.selectOnlineGoodsList(map);
	}

	/**
	 * 重新上线
	 * Title: anewOnline
	 * Description: 
	 * @param onlineInfo
	 * @return
	 * @throws JsonProcessingException
	 * @throws IOException
	 * @date 2018年4月3日 上午11:37:45
	 */
	@PostMapping("/onl/online/anewonline")
	Map<String, Object> anewOnline(String onlineInfo) throws JsonProcessingException, IOException{
		return svc.anewOnline(onlineInfo);
	}
}
