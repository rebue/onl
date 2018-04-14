package rebue.onl.ctrl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.svc.OnlOnlineSpecSvc;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.github.pagehelper.PageInfo;

import java.io.IOException;
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
	@GetMapping(value = "/onl/onlinespec/details", produces="application/json")
	List<OnlOnlineSpecInfoRo> selectOnlineSpecInfo(OnlOnlineSpecMo mo) {
		_log.info("获取上线规格信息的参数为：{}", mo.toString());
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
	@PutMapping(value = "/onl/onlinespec", produces="application/json")
	Map<String, Object> updateSelective(OnlOnlineSpecMo mo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			int result = svc.updateSelective(mo);
			_log.info("修改上线规格信息的返回值为：{}", result);
			resultMap.put("result", result);
			resultMap.put("msg", "修改成功");
			return resultMap;
		} catch (RuntimeException e) {
			String msg = e.getMessage();
			if (msg.equals("修改上线规格信息失败")) {
				resultMap.put("result", -1);
				resultMap.put("msg", "修改失败");
			}
			e.printStackTrace();
			return resultMap;
		}
	}
	
	/**
	 * 删除购物车和修改上线数量
	 * Title: deleteCartAndUpdateOnlineCount
	 * Description: 
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * @date 2018年4月11日 下午5:52:30
	 */
	@PostMapping(value = "/onl/onlinespec/deleteandupdate", produces="application/json")
	Map<String, Object> deleteCartAndUpdateOnlineCount(String cartAndSpecInfo) throws JsonParseException, JsonMappingException, IOException {
		_log.info("删除购物车和修改上线数量的参数为：", cartAndSpecInfo);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			resultMap = svc.deleteCartAndModifyInventory(cartAndSpecInfo);
		} catch (RuntimeException e) {
			String msg = e.getMessage();
			if (msg.contains("未上线")) {
				_log.error( msg);
				resultMap.put("result", -1);
				resultMap.put("msg", msg);
			} else if (msg.contains("购物车中找不到")) {
				_log.error( msg);
				resultMap.put("result", -2);
				resultMap.put("msg", msg);
			} else if (msg.contains("扣减上线数量失败")) {
				_log.error( msg);
				resultMap.put("result", -3);
				resultMap.put("msg", msg);
			} else if (msg.equals("删除购物车失败")) {
				_log.error( msg);
				resultMap.put("result", -4);
				resultMap.put("msg", msg);
			} else if (msg.contains("库存不足")) {
				_log.error( msg);
				resultMap.put("result", -5);
				resultMap.put("msg", msg);
			} else {
				_log.error( msg);
				resultMap.put("result", -6);
				resultMap.put("msg", msg);
			}
		}
		_log.info("删除购物车和修改上线数量的返回值为：{}", String.valueOf(resultMap));
		return resultMap;
	}
}
