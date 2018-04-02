package rebue.onl.ctrl;

import java.util.HashMap;
import java.util.List;
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

import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.ro.OnlOnlineSpecInfoRo;
import rebue.onl.svc.OnlOnlineSpecSvc;
import com.github.pagehelper.PageInfo;

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
     * 添加上线规格
     * @mbg.generated
     */
    @PostMapping("/onl/onlinespec")
    Map<String, Object> add(OnlOnlineSpecMo vo) throws Exception {
        _log.info("add OnlOnlineSpecMo:" + vo);
        svc.add(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("id", vo.getId());
        _log.info("add OnlOnlineSpecMo success!");
        return result;
    }

    /**
     * 修改上线规格
     * @mbg.generated
     */
    @PutMapping("/onl/onlinespec")
    Map<String, Object> modify(OnlOnlineSpecMo vo) throws Exception {
        _log.info("modify OnlOnlineSpecMo:" + vo);
        svc.modify(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        _log.info("modify OnlOnlineSpecMo success!");
        return result;
    }

    /**
     * 删除上线规格
     * @mbg.generated
     */
    @DeleteMapping("/onl/onlinespec/{id}")
    Map<String, Object> del(@PathVariable("id") java.lang.Long id) {
        _log.info("save OnlOnlineSpecMo:" + id);
        svc.del(id);		
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        _log.info("delete OnlOnlineSpecMo success!");
        return result;
    }

    /**
     * 查询上线规格
     * @mbg.generated
     */
    @GetMapping("/onl/onlinespec")
    PageInfo<OnlOnlineSpecMo> list(OnlOnlineSpecMo qo, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
    		_log.info("list OnlOnlineSpecMo:" + qo+", pageNum = " + pageNum + ", pageSize = " + pageSize);

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
     * 获取单个上线规格
     * @mbg.generated
     */
    @GetMapping("/onl/onlinespec/{id}")
    OnlOnlineSpecMo get(@PathVariable("id") java.lang.Long id) {
        _log.info("get OnlOnlineSpecMo by id: " + id);
        OnlOnlineSpecMo result = svc.getById(id);
        _log.info("get: " + result);
        return result;
    }
    
    /**
     * 获取上线规格信息
     * Title: selectOnlineSpecInfoByOnlineId
     * Description: 
     * @param record
     * @return
     * @date 2018年4月1日 下午4:29:31
     */
    @GetMapping("/onl/onlinespec/details")
    List<OnlOnlineSpecInfoRo> selectOnlineSpecInfo(OnlOnlineSpecMo mo){
    	_log.info("根据上线编号获取上线规格信息的参数为：{}", mo.toString());
    	return svc.selectOnlineSpecInfo(mo);
    }

}
