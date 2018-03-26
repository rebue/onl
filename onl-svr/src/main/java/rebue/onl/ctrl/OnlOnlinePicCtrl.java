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

import rebue.onl.mo.OnlOnlinePicMo;
import rebue.onl.svc.OnlOnlinePicSvc;
import com.github.pagehelper.PageInfo;

@RestController
public class OnlOnlinePicCtrl {
    /**
     * @mbg.generated
     */
    private final static Logger _log = LoggerFactory.getLogger(OnlOnlinePicCtrl.class);

    /**
     * @mbg.generated
     */
	@Resource
    private OnlOnlinePicSvc svc;

    /**
     * 添加上线图片
     * @mbg.generated
     */
    @PostMapping("/onl/onlinepic")
    Map<String, Object> add(OnlOnlinePicMo vo) throws Exception {
        _log.info("add OnlOnlinePicMo:" + vo);
        svc.add(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("id", vo.getId());
        _log.info("add OnlOnlinePicMo success!");
        return result;
    }

    /**
     * 修改上线图片
     * @mbg.generated
     */
    @PutMapping("/onl/onlinepic")
    Map<String, Object> modify(OnlOnlinePicMo vo) throws Exception {
        _log.info("modify OnlOnlinePicMo:" + vo);
        svc.modify(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        _log.info("modify OnlOnlinePicMo success!");
        return result;
    }

    /**
     * 删除上线图片
     * @mbg.generated
     */
    @DeleteMapping("/onl/onlinepic/{id}")
    Map<String, Object> del(@PathVariable("id") java.lang.Long id) {
        _log.info("save OnlOnlinePicMo:" + id);
        svc.del(id);		
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        _log.info("delete OnlOnlinePicMo success!");
        return result;
    }

    /**
     * 查询上线图片
     * @mbg.generated
     */
    @GetMapping("/onl/onlinepic")
    PageInfo<OnlOnlinePicMo> list(OnlOnlinePicMo qo, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
    		_log.info("list OnlOnlinePicMo:" + qo+", pageNum = " + pageNum + ", pageSize = " + pageSize);

        if (pageSize > 50) {
            String msg = "pageSize不能大于50";
            _log.error(msg);
            throw new IllegalArgumentException(msg);
        }

        PageInfo<OnlOnlinePicMo> result = svc.list(qo, pageNum, pageSize);
        _log.info("result: " + result);
        return result;
    }

    /**
     * 获取单个上线图片
     * @mbg.generated
     */
    @GetMapping("/onl/onlinepic/{id}")
    OnlOnlinePicMo get(@PathVariable("id") java.lang.Long id) {
        _log.info("get OnlOnlinePicMo by id: " + id);
        OnlOnlinePicMo result = svc.getById(id);
        _log.info("get: " + result);
        return result;
    }

}
