package rebue.onl.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.so.OnlOnlineSpecSo;
import rebue.onl.svc.OnlOnlineSpecEsSvc;

/**
 * 上线规格
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@RestController
public class OnlOnlineSpecEsCtrl {

    private static final Logger _log = LoggerFactory.getLogger(OnlOnlineSpecEsCtrl.class);

    @Resource
    private OnlOnlineSpecEsSvc svc;

    /**
     * 获取单个上线规格
     */
    @GetMapping("/onl/online-spec-es/get-by-id")
    OnlOnlineSpecSo getById(@RequestParam final String id) {
        _log.info("PrdProductSpecEsCtrl.getById:{}", id);
        return svc.getById(id);
    }

    /**
     * 根据上线名称获取上线规格
     */
    @GetMapping("/onl/online-spec-es/select-by-name")
    List<OnlOnlineSpecMo> selectByName(@RequestParam("onlineSpec") final String onlineSpec) {
        _log.info("PrdProductSpecEsCtrl.getById:{}", onlineSpec);
        return svc.selectByName(onlineSpec);
    }
}
