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

import rebue.onl.mo.OnlOnlineLogMo;
import rebue.onl.svc.OnlOnlineLogSvc;
import com.github.pagehelper.PageInfo;

@RestController
public class OnlOnlineLogCtrl {
    /**
     * @mbg.generated
     */
    private final static Logger _log = LoggerFactory.getLogger(OnlOnlineLogCtrl.class);

    /**
     * @mbg.generated
     */
	@Resource
    private OnlOnlineLogSvc svc;

    /**
     * 添加上线日志
     * @mbg.generated
     */
    @PostMapping("/onl/onlinelog")
    Map<String, Object> add(OnlOnlineLogMo vo) throws Exception {
        _log.info("add OnlOnlineLogMo:" + vo);
        svc.add(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("id", vo.getId());
        _log.info("add OnlOnlineLogMo success!");
        return result;
    }

    /**
     * 修改上线日志
     * @mbg.generated
     */
    @PutMapping("/onl/onlinelog")
    Map<String, Object> modify(OnlOnlineLogMo vo) throws Exception {
        _log.info("modify OnlOnlineLogMo:" + vo);
        svc.modify(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        _log.info("modify OnlOnlineLogMo success!");
        return result;
    }

    /**
     * 删除上线日志
     * @mbg.generated
     */
    @DeleteMapping("/onl/onlinelog/{id}")
    Map<String, Object> del(@PathVariable("id") java.lang.Long id) {
        _log.info("save OnlOnlineLogMo:" + id);
        svc.del(id);		
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        _log.info("delete OnlOnlineLogMo success!");
        return result;
    }

    /**
     * 查询上线日志
     * @mbg.generated
     */
    @GetMapping("/onl/onlinelog")
    PageInfo<OnlOnlineLogMo> list(OnlOnlineLogMo qo, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
    		_log.info("list OnlOnlineLogMo:" + qo+", pageNum = " + pageNum + ", pageSize = " + pageSize);

        if (pageSize > 50) {
            String msg = "pageSize不能大于50";
            _log.error(msg);
            throw new IllegalArgumentException(msg);
        }

        PageInfo<OnlOnlineLogMo> result = svc.list(qo, pageNum, pageSize);
        _log.info("result: " + result);
        return result;
    }

    /**
     * 获取单个上线日志
     * @mbg.generated
     */
    @GetMapping("/onl/onlinelog/{id}")
    OnlOnlineLogMo get(@PathVariable("id") java.lang.Long id) {
        _log.info("get OnlOnlineLogMo by id: " + id);
        OnlOnlineLogMo result = svc.getById(id);
        _log.info("get: " + result);
        return result;
    }

}
