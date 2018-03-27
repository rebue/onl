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



}
