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

@RestController
public class OnlOnlinePromotionCtrl {
    /**
     * @mbg.generated
     */
    private final static Logger _log = LoggerFactory.getLogger(OnlOnlinePromotionCtrl.class);

    /**
     * @mbg.generated
     */
	@Resource
    private OnlOnlinePromotionSvc svc;

    /**
     * 添加上线推广
     * @mbg.generated
     */
    @PostMapping("/onl/onlinepromotion")
    Map<String, Object> add(OnlOnlinePromotionMo vo) throws Exception {
        _log.info("add OnlOnlinePromotionMo:" + vo);
        svc.add(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("id", vo.getId());
        _log.info("add OnlOnlinePromotionMo success!");
        return result;
    }

    /**
     * 修改上线推广
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
     * 删除上线推广
     * @mbg.generated
     */
    @DeleteMapping("/onl/onlinepromotion/{id}")
    Map<String, Object> del(@PathVariable("id") java.lang.Long id) {
        _log.info("save OnlOnlinePromotionMo:" + id);
        svc.del(id);		
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        _log.info("delete OnlOnlinePromotionMo success!");
        return result;
    }

    /**
     * 查询上线推广
     * @mbg.generated
     */
    @GetMapping("/onl/onlinepromotion")
    PageInfo<OnlOnlinePromotionMo> list(OnlOnlinePromotionMo qo, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
    		_log.info("list OnlOnlinePromotionMo:" + qo+", pageNum = " + pageNum + ", pageSize = " + pageSize);

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
     * @mbg.generated
     */
    @GetMapping("/onl/onlinepromotion/{id}")
    OnlOnlinePromotionMo get(@PathVariable("id") java.lang.Long id) {
        _log.info("get OnlOnlinePromotionMo by id: " + id);
        OnlOnlinePromotionMo result = svc.getById(id);
        _log.info("get: " + result);
        return result;
    }

}
