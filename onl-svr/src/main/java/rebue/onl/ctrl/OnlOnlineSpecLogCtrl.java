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

import rebue.onl.mo.OnlOnlineSpecLogMo;
import rebue.onl.svc.OnlOnlineSpecLogSvc;
import com.github.pagehelper.PageInfo;

@RestController
public class OnlOnlineSpecLogCtrl {
    /**
     * @mbg.generated
     */
    private final static Logger _log = LoggerFactory.getLogger(OnlOnlineSpecLogCtrl.class);

    /**
     * @mbg.generated
     */
	@Resource
    private OnlOnlineSpecLogSvc svc;

    /**
     * 添加上线规格日志
     * @mbg.generated
     */
    @PostMapping("/onl/onlinespeclog")
    Map<String, Object> add(OnlOnlineSpecLogMo vo) throws Exception {
        _log.info("add OnlOnlineSpecLogMo:" + vo);
        svc.add(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("id", vo.getId());
        _log.info("add OnlOnlineSpecLogMo success!");
        return result;
    }

    /**
     * 修改上线规格日志
     * @mbg.generated
     */
    @PutMapping("/onl/onlinespeclog")
    Map<String, Object> modify(OnlOnlineSpecLogMo vo) throws Exception {
        _log.info("modify OnlOnlineSpecLogMo:" + vo);
        svc.modify(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        _log.info("modify OnlOnlineSpecLogMo success!");
        return result;
    }

    /**
     * 删除上线规格日志
     * @mbg.generated
     */
    @DeleteMapping("/onl/onlinespeclog/{id}")
    Map<String, Object> del(@PathVariable("id") java.lang.Long id) {
        _log.info("save OnlOnlineSpecLogMo:" + id);
        svc.del(id);		
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        _log.info("delete OnlOnlineSpecLogMo success!");
        return result;
    }

    /**
     * 查询上线规格日志
     * @mbg.generated
     */
    @GetMapping("/onl/onlinespeclog")
    PageInfo<OnlOnlineSpecLogMo> list(OnlOnlineSpecLogMo qo, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
    		_log.info("list OnlOnlineSpecLogMo:" + qo+", pageNum = " + pageNum + ", pageSize = " + pageSize);

        if (pageSize > 50) {
            String msg = "pageSize不能大于50";
            _log.error(msg);
            throw new IllegalArgumentException(msg);
        }

        PageInfo<OnlOnlineSpecLogMo> result = svc.list(qo, pageNum, pageSize);
        _log.info("result: " + result);
        return result;
    }

    /**
     * 获取单个上线规格日志
     * @mbg.generated
     */
    @GetMapping("/onl/onlinespeclog/{id}")
    OnlOnlineSpecLogMo get(@PathVariable("id") java.lang.Long id) {
        _log.info("get OnlOnlineSpecLogMo by id: " + id);
        OnlOnlineSpecLogMo result = svc.getById(id);
        _log.info("get: " + result);
        return result;
    }

}
