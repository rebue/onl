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

import rebue.onl.mo.OnlOnlineMo;
import rebue.onl.svc.OnlOnlineSvc;
import rebue.onl.to.OnlineGoodsBaseTo;

import com.github.pagehelper.PageInfo;

@RestController
public class OnlOnlineCtrl {
    /**
     * @mbg.generated
     */
    private final static Logger _log = LoggerFactory.getLogger(OnlOnlineCtrl.class);

    /**
     * @mbg.generated
     */
	@Resource
    private OnlOnlineSvc svc;

    /**
     * 添加上线信息
     */
    @PostMapping("/onl/online")
    Map<String, Object> add(OnlineGoodsBaseTo to) throws Exception {
    	_log.info("开始发布商品，发布商品的参数为：" + to.toString());
    	return svc.addEx(to);
	}

    /**
     * 修改上线信息
     * @mbg.generated
     */
    @PutMapping("/onl/online")
    Map<String, Object> modify(OnlOnlineMo vo) throws Exception {
        _log.info("modify OnlOnlineMo:" + vo);
        svc.modify(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        _log.info("modify OnlOnlineMo success!");
        return result;
    }

    /**
     * 删除上线信息
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
     * 查询上线信息
     * @mbg.generated
     */
    @GetMapping("/onl/online")
    PageInfo<OnlOnlineMo> list(OnlOnlineMo qo, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
    		_log.info("list OnlOnlineMo:" + qo+", pageNum = " + pageNum + ", pageSize = " + pageSize);

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
     * 获取单个上线信息
     * @mbg.generated
     */
    @GetMapping("/onl/online/{id}")
    OnlOnlineMo get(@PathVariable("id") java.lang.Long id) {
        _log.info("get OnlOnlineMo by id: " + id);
        OnlOnlineMo result = svc.getById(id);
        _log.info("get: " + result);
        return result;
    }
    
}
