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
import com.github.pagehelper.PageInfo;

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
     * @mbg.generated
     */
    @PostMapping("/onl/cart")
    Map<String, Object> add(OnlCartMo vo) throws Exception {
        _log.info("add OnlCartMo:" + vo);
        svc.add(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("id", vo.getId());
        _log.info("add OnlCartMo success!");
        return result;
    }

    /**
     * 修改购物车
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
     * 查询购物车
     * @mbg.generated
     */
    @GetMapping("/onl/cart")
    PageInfo<OnlCartMo> list(OnlCartMo qo, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
    		_log.info("list OnlCartMo:" + qo+", pageNum = " + pageNum + ", pageSize = " + pageSize);

        if (pageSize > 50) {
            String msg = "pageSize不能大于50";
            _log.error(msg);
            throw new IllegalArgumentException(msg);
        }

        PageInfo<OnlCartMo> result = svc.list(qo, pageNum, pageSize);
        _log.info("result: " + result);
        return result;
    }

    /**
     * 获取单个购物车
     * @mbg.generated
     */
    @GetMapping("/onl/cart/{id}")
    OnlCartMo get(@PathVariable("id") java.lang.Long id) {
        _log.info("get OnlCartMo by id: " + id);
        OnlCartMo result = svc.getById(id);
        _log.info("get: " + result);
        return result;
    }

}
