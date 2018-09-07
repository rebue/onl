package rebue.onl.ctrl;

import com.github.pagehelper.PageInfo;
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
import rebue.onl.mo.OnlOnlineSpecOpLogMo;
import rebue.onl.svc.OnlOnlineSpecOpLogSvc;

@RestController
public class OnlOnlineSpecOpLogCtrl {

    /**
     * @mbg.generated
     */
    private static final Logger _log = LoggerFactory.getLogger(OnlOnlineSpecOpLogCtrl.class);

    /**
     * @mbg.generated
     */
    @Resource
    private OnlOnlineSpecOpLogSvc svc;

    /**
     * 添加上线规格操作日志信息
     * @mbg.generated
     */
    @PostMapping("/onl/onlinespecoplog")
    Map<String, Object> add(OnlOnlineSpecOpLogMo vo) throws Exception {
        _log.info("add OnlOnlineSpecOpLogMo:" + vo);
        svc.add(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("id", vo.getId());
        _log.info("add OnlOnlineSpecOpLogMo success!");
        return result;
    }

    /**
     * 修改上线规格操作日志信息
     * @mbg.generated
     */
    @PutMapping("/onl/onlinespecoplog")
    Map<String, Object> modify(OnlOnlineSpecOpLogMo vo) throws Exception {
        _log.info("modify OnlOnlineSpecOpLogMo:" + vo);
        svc.modify(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        _log.info("modify OnlOnlineSpecOpLogMo success!");
        return result;
    }

    /**
     * 删除上线规格操作日志信息
     * @mbg.generated
     */
    @DeleteMapping("/onl/onlinespecoplog/{id}")
    Map<String, Object> del(@PathVariable("id") java.lang.Long id) {
        _log.info("save OnlOnlineSpecOpLogMo:" + id);
        svc.del(id);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        _log.info("delete OnlOnlineSpecOpLogMo success!");
        return result;
    }

    /**
     * 查询上线规格操作日志信息
     * @mbg.generated
     */
    @GetMapping("/onl/onlinespecoplog")
    PageInfo<OnlOnlineSpecOpLogMo> list(OnlOnlineSpecOpLogMo qo, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        _log.info("list OnlOnlineSpecOpLogMo:" + qo + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
        if (pageSize > 50) {
            String msg = "pageSize不能大于50";
            _log.error(msg);
            throw new IllegalArgumentException(msg);
        }
        PageInfo<OnlOnlineSpecOpLogMo> result = svc.list(qo, pageNum, pageSize);
        _log.info("result: " + result);
        return result;
    }

    /**
     * 获取单个上线规格操作日志信息
     * @mbg.generated
     */
    @GetMapping("/onl/onlinespecoplog/{id}")
    OnlOnlineSpecOpLogMo get(@PathVariable("id") java.lang.Long id) {
        _log.info("get OnlOnlineSpecOpLogMo by id: " + id);
        OnlOnlineSpecOpLogMo result = svc.getById(id);
        _log.info("get: " + result);
        return result;
    }
}
