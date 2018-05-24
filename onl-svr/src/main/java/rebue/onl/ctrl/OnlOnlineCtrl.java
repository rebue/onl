package rebue.onl.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rebue.onl.dic.GoodsOnlineDic;
import rebue.onl.mo.OnlOnlineMo;
import rebue.onl.svc.OnlOnlineSvc;
import rebue.onl.to.OnlineGoodsListTo;

import com.github.pagehelper.PageInfo;
import java.io.IOException;
import java.util.List;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.core.JsonProcessingException;

import rebue.onl.ro.GoodsOnlineRo;
import rebue.onl.ro.OnlOnlineGoodsInfoRo;

@RestController
public class OnlOnlineCtrl {
	/**
	 */
	private final static Logger _log = LoggerFactory.getLogger(OnlOnlineCtrl.class);

	/**
	 */
	@Resource
	private OnlOnlineSvc svc;

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
	@SuppressWarnings("finally")
	@PostMapping("/onl/online")
	GoodsOnlineRo goodsOnline(@RequestParam("onlineInfo") String onlineInfo) {
		_log.info("开始发布商品，发布商品的参数为：" + onlineInfo);
		GoodsOnlineRo goodsOnlineRo = new GoodsOnlineRo();
		try {
			goodsOnlineRo = svc.goodsOnline(onlineInfo);
		} catch (RuntimeException e) {
			String msg = e.getMessage();
			_log.error("===============添加上线商品出现异常了============={}", msg);
			if (msg.equals("添加商品规格信息出错")) {
				goodsOnlineRo.setResult(GoodsOnlineDic.ADD_GOODS_SPEC_ERROR);
				goodsOnlineRo.setMsg(msg);
			} else if (msg.equals("商品规格不能为空")) {
				goodsOnlineRo.setResult(GoodsOnlineDic.GOODS_SPEC_NOT_NULL);
				goodsOnlineRo.setMsg(msg);
			} else if (msg.equals("添加商品主图出错")) {
				goodsOnlineRo.setResult(GoodsOnlineDic.ADD_GOODS_QSMM_ERROR);
				goodsOnlineRo.setMsg(msg);
			} else if (msg.equals("添加商品轮播图出错")) {
				goodsOnlineRo.setResult(GoodsOnlineDic.ADD_GOODS_CAROUSEL_ERROR);
				goodsOnlineRo.setMsg(msg);
			} else {
				goodsOnlineRo.setResult(GoodsOnlineDic.ERROR);
				goodsOnlineRo.setMsg("发布商品失败");
			}
		} finally {
			return goodsOnlineRo;
		}
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
	PageInfo<OnlOnlineMo> list(OnlOnlineMo qo, @RequestParam("pageNum") int pageNum,
			@RequestParam("pageSize") int pageSize) {
		_log.info("list OnlOnlineSpecMo:" + qo + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
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
		_log.info("开始商品下线，商品下线的参数为：" + vo);
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
	@SuppressWarnings("finally")
	@GetMapping("/onl/online/list")
	List<OnlOnlineGoodsInfoRo> selectOnlineGoodsList(OnlineGoodsListTo to) {
		_log.info("获取上线商品列表的参数为：{}", to);
		List<OnlOnlineGoodsInfoRo> list = new ArrayList<>();
		try {
			list = svc.selectOnlineGoodsList(to);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return list;
		}

	}

	/**
	 * 重新上线 Title: anewOnline Description:
	 * 
	 * @param onlineInfo
	 * @return
	 * @throws JsonProcessingException
	 * @throws IOException
	 * @date 2018年4月3日 上午11:37:45
	 */
	@SuppressWarnings("finally")
	@PostMapping("/onl/online/anewonline")
	GoodsOnlineRo anewOnline(@RequestParam("onlineInfo") String onlineInfo)
			throws JsonProcessingException, IOException {
		GoodsOnlineRo goodsOnlineRo = new GoodsOnlineRo();
		try {
			goodsOnlineRo = svc.anewOnline(onlineInfo);
		} catch (RuntimeException e) {
			String msg = e.getMessage();
			_log.error("===============c重新上线商品出现异常了============={}", msg);
			if (msg.equals("添加商品规格信息出错")) {
				goodsOnlineRo.setResult(GoodsOnlineDic.ADD_GOODS_SPEC_ERROR);
				goodsOnlineRo.setMsg(msg);
			} else if (msg.equals("商品规格不能为空")) {
				goodsOnlineRo.setResult(GoodsOnlineDic.GOODS_SPEC_NOT_NULL);
				goodsOnlineRo.setMsg(msg);
			} else if (msg.equals("添加商品主图出错")) {
				goodsOnlineRo.setResult(GoodsOnlineDic.ADD_GOODS_QSMM_ERROR);
				goodsOnlineRo.setMsg(msg);
			} else if (msg.equals("添加商品轮播图出错")) {
				goodsOnlineRo.setResult(GoodsOnlineDic.ADD_GOODS_CAROUSEL_ERROR);
				goodsOnlineRo.setMsg(msg);
			} else {
				goodsOnlineRo.setResult(GoodsOnlineDic.ERROR);
				goodsOnlineRo.setMsg("重新上线失败");
			}
		} finally {
			return goodsOnlineRo;
		}
	}

	/**
	 * 查询是否已上线 Title: existSelective Description:
	 * 
	 * @param qo
	 * @return
	 * @date 2018年4月10日 下午4:06:26
	 */
	@GetMapping(value = "/onl/online/exist")
	@ResponseBody
	Boolean existSelective(@RequestParam("id") Long id, @RequestParam("onlineState") Byte onlineState) {
		OnlOnlineMo qo = new OnlOnlineMo();
		qo.setId(id);
		qo.setOnlineState(onlineState);
		_log.info("查询是否已上线的参数为：{}", qo);
		boolean result = svc.existSelective(qo);
		_log.info("查询是否已上线的返回值为：{}", result);
		return result;
	}

}
