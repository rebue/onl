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

import rebue.onl.mo.OnlCartMo;
import rebue.onl.svc.OnlCartSvc;
import java.util.List;

import rebue.onl.ro.AddCartRo;
import rebue.onl.ro.OnlCartRo;

@RestController
public class OnlCartCtrl {
	/**
	 * @mbg.generated
	 */
	private final static Logger _log = LoggerFactory.getLogger(OnlCartCtrl.class);

	/**
	 * @mbg.generated
	 */
	@Resource
	private OnlCartSvc svc;

	/**
	 * 修改购物车
	 * 
	 * @mbg.generated
	 */
	@PutMapping("/onl/cart")
	Map<String, Object> modify(OnlCartMo vo) throws Exception {
		_log.info("modify OnlCartMo:" + vo);
		svc.modify(vo);
		Map<String, Object> result = new HashMap<>();
		result.put("success", true);
		_log.info("modify OnlCartMo success!");
		return result;
	}

	/**
	 * 删除购物车
	 * 
	 * @mbg.generated
	 */
	@DeleteMapping("/onl/cart/{id}")
	Map<String, Object> del(@PathVariable("id") java.lang.Long id) {
		_log.info("save OnlCartMo:" + id);
		svc.del(id);
		Map<String, Object> result = new HashMap<>();
		result.put("success", true);
		_log.info("delete OnlCartMo success!");
		return result;
	}

	/**
	 * 获取单个购物车
	 * 
	 * @mbg.generated
	 */
	@GetMapping("/onl/cart/{id}")
	OnlCartMo get(@PathVariable("id") java.lang.Long id) {
		_log.info("get OnlCartMo by id: " + id);
		OnlCartMo result = svc.getById(id);
		_log.info("get: " + result);
		return result;
	}

	/**
	 * 添加购物车 Title: add Description:
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 * @date 2018年3月29日 下午2:27:03
	 */
	@PostMapping("/onl/cart")
	AddCartRo addCart(OnlCartMo vo) throws Exception {
		_log.info("加入购物车的参数为：" + vo);
		return svc.addCart(vo);
	}

	/**
	 * 删除购物车 Title: del Description:
	 * 
	 * @param id
	 * @return
	 * @date 2018年3月29日 下午2:54:51
	 */
	@DeleteMapping(value = "/onl/cart")
	Map<String, Object> del(OnlCartMo vo) {
		_log.info("删除购物车的参数为：" + vo);
		int result = svc.deleteByUserIdAndCartId(vo);
		_log.info("删除购物车的返回值为：{}", result);
		Map<String, Object> resultMap = new HashMap<>();
		if (result < 1) {
			_log.error("用户编号为：{}，删除购物车失败", vo.getUserId());
			resultMap.put("msg", "删除购物车失败");
			resultMap.put("result", result);
		} else {
			_log.info("用户编号为：{}，删除购物车成功", vo.getUserId());
			resultMap.put("msg", "删除购物车成功");
			resultMap.put("result", 1);
		}
		return resultMap;
	}

	/**
	 * 查询购物车数量 Title: Cartcount Description:
	 * 
	 * @param qo
	 * @return
	 * @date 2018年3月30日 上午10:52:33
	 */
	@GetMapping("/onl/cart/count")
	int Cartcount(OnlCartMo qo) {
		_log.info("查询购物车的参数为：{}", qo);
		return svc.selectCartCount(qo);
	}

	/**
	 * 获取购物车列表 Title: selectCartList Description:
	 * 
	 * @param qo
	 * @return
	 * @date 2018年3月30日 下午1:56:38
	 */
	@GetMapping("/onl/cart")
	List<OnlCartRo> selectCartList(OnlCartMo qo) {
		return svc.selectCartList(qo);
	}

	/**
	 * 批量删除购物车 Title: deleteByUserIdAndCartIds Description:
	 * 
	 * @param map
	 * @return
	 * @date 2018年4月3日 下午3:30:20
	 */
	@DeleteMapping("/onl/cart/deletes")
	int deleteByUserIdAndCartIds(@RequestParam Map<String, Object> map) {
		return svc.deleteByUserIdAndCartIds(map);
	}

}
