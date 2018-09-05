package rebue.onl.ctrl;

import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rebue.onl.dic.AddOnlineDic;
import rebue.onl.mo.OnlOnlineMo;
import rebue.onl.mo.OnlOnlinePicMo;
import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.ro.AddOnlineRo;
import rebue.onl.ro.GetOnlinesRo;
import rebue.onl.ro.OnlOnlineGoodsInfoRo;
import rebue.onl.ro.OnlOnlineRo;
import rebue.onl.ro.OnlinesRo;
import rebue.onl.svc.OnlOnlinePicSvc;
import rebue.onl.svc.OnlOnlineSpecSvc;
import rebue.onl.svc.OnlOnlineSvc;
import rebue.onl.to.AddOnlineTo;
import rebue.onl.to.OnlineGoodsListTo;

@RestController
public class OnlOnlineCtrl {

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

    /**
     */
    private static final Logger _log = LoggerFactory.getLogger(OnlOnlineCtrl.class);

    /**
     */
    @Resource
    private OnlOnlineSvc svc;

    @Resource
    private OnlOnlineSpecSvc onlineSpecSvc;

    @Resource
    private OnlOnlinePicSvc onlinePicSvc;

    @Resource
    private Mapper dozerMapper;

    /**
     *  添加上线信息
     *
     *  @mbg.overrideByMethodName
     */
    @PostMapping("/onl/online")
    AddOnlineRo add(@RequestBody AddOnlineTo to, HttpServletRequest request) throws Exception {
        // 获取当前登录用户id
        // Long loginId = JwtUtils.getJwtUserIdInCookie(request);
        to.setOpId(Long.parseLong("121231212"));
        _log.info("添加上线信息的参数为：{}", to);
        try {
            return svc.addOnline(to);
        } catch (RuntimeException e) {
            String msg = e.getMessage();
            AddOnlineRo ro = new AddOnlineRo();
            ro.setMsg(msg);
            ro.setResult(AddOnlineDic.ERROR);
            return ro;
        }
    }

    /**
     *  根据条件分页查询商品上线信息 Title: list Description:
     *
     *  @param qo
     *  @param pageNum
     *  @param pageSize
     *  @return
     *  @date 2018年3月28日 下午3:06:09
     */
    @GetMapping("/onl/online")
    PageInfo<OnlOnlineMo> list(OnlOnlineMo qo, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        _log.info("list OnlOnlineSpecMo:" + qo + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
        if (pageSize > 50) {
            String msg = "pageSize不能大于50";
            _log.error(msg);
            throw new IllegalArgumentException(msg);
        }
        PageInfo<OnlOnlineMo> result = svc.list(qo, pageNum, pageSize, "ONLINE_TIME DESC");
        _log.info("result: " + result);
        return result;
    }

    /**
     *  商品下线 Title: modify Description:
     *
     *  @param vo
     *  @return
     *  @throws Exception
     *  @date 2018年3月28日 下午3:14:23
     */
    @PutMapping("/onl/online")
    OnlOnlineRo modify(OnlOnlineMo vo) throws Exception {
        _log.info("开始商品下线，商品下线的参数为：" + vo);
        int result = svc.modify(vo);
        OnlOnlineRo ro = new OnlOnlineRo();
        if (result < 1) {
            ro.setResult((byte) -1);
            ro.setMsg("下线失败");
            _log.error("上线编号：{}，下线失败", vo.getId());
        } else {
            ro.setResult((byte) 1);
            ro.setMsg("下线成功");
            _log.info("上线编号：{}，下线成功!", vo.getId());
        }
        return ro;
    }

    /**
     *  获取上线商品列表 Title: selectOnlineGoodsList Description:
     *
     *  @return
     *  @date 2018年3月29日 下午5:42:46
     */
    @SuppressWarnings("finally")
    @GetMapping("/onl/online/list")
    List<OnlOnlineGoodsInfoRo> selectOnlineGoodsList(OnlineGoodsListTo to) {
        _log.info("获取上线商品列表的参数为：{}", to);
        List<OnlOnlineGoodsInfoRo> list = new ArrayList<>();
        try {
            list = svc.selectOnlineGoodsList(to);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return list;
        }
    }

    /**
     *  查询是否已上线 Title: existSelective Description:
     *
     *  @param qo
     *  @return
     *  @date 2018年4月10日 下午4:06:26
     */
    @GetMapping(value = "/onl/online/exist")
    @ResponseBody
    Boolean existSelective(@RequestParam("id") Long id, @RequestParam("onlineState") Byte onlineState) {
        OnlOnlineMo qo = new OnlOnlineMo();
        qo.setId(id);
        qo.setOnlineState(onlineState);
        _log.info("查询是否已上线的参数为：{}", qo);
        boolean result = svc.existSelective(qo);
        _log.info("查询是否已上线的返回值为：{}", result);
        return result;
    }

    /**
     *  根据id获取上线信息、规格信息、图片信息
     *
     *  @param id
     *  @return
     */
    @GetMapping("/onl/online/getonlines")
    GetOnlinesRo getOnlines(@RequestParam("id") Long id) {
        _log.info("根据上线id获取上线信息的参数为：{}", id);
        GetOnlinesRo onlinesRo = new GetOnlinesRo();
        // 获取上线信息
        OnlinesRo onlOnlineRo = dozerMapper.map(svc.listByPrimaryKey(id), OnlinesRo.class);
        // 获取规格信息
        OnlOnlineSpecMo onlineSpecMo = new OnlOnlineSpecMo();
        onlineSpecMo.setOnlineId(id);
        onlOnlineRo.setOnlineSpecList(onlineSpecSvc.list(onlineSpecMo));
        // 获取图片信息
        OnlOnlinePicMo onlinePicMo = new OnlOnlinePicMo();
        onlinePicMo.setOnlineId(id);
        onlOnlineRo.setOnlinePicList(onlinePicSvc.list(onlinePicMo));
        onlinesRo.setRecord(onlOnlineRo);
        onlinesRo.setResult((byte) 1);
        return onlinesRo;
    }
}
