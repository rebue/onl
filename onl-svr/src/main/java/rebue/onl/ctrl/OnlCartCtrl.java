package rebue.onl.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import rebue.onl.mo.OnlCartMo;
import rebue.onl.ro.OnlCartRo;
import rebue.onl.svc.OnlCartSvc;

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
     * 添加购物车
     * Title: add
     * Description: 
     * @param vo
     * @return
     * @throws Exception
     * @date 2018年3月29日 下午2:27:03
     */
    @PostMapping("/onl/cart")
    Map<String, Object> add(OnlCartMo vo) throws Exception {
        _log.info("加入购物车的参数为：" + vo.toString());
        return svc.addEx(vo);
    }

    /**
     * 删除购物车
     * Title: del
     * Description: 
     * @param id
     * @return
     * @date 2018年3月29日 下午2:54:51
     */
    @DeleteMapping("/onl/cart")
    Map<String, Object> del(OnlCartMo vo) {
        _log.info("删除购物车的参数为：" + vo.toString());
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
     * 查询购物车数量
     * Title: Cartcount
     * Description: 
     * @param qo
     * @return
     * @date 2018年3月30日 上午10:52:33
     */
    @GetMapping("/onl/cart/count")
    int Cartcount(OnlCartMo qo) {
    	_log.info("查询购物车的参数为：{}", qo.toString());
    	return svc.selectCartCount(qo);
    }

    /**
     * 获取购物车列表
     * Title: selectCartList
     * Description: 
     * @param qo
     * @return
     * @date 2018年3月30日 下午1:56:38
     */
    @GetMapping("/onl/cart")
    List<OnlCartRo> selectCartList(OnlCartMo qo) {
    	return svc.selectCartList(qo);
    }
}
