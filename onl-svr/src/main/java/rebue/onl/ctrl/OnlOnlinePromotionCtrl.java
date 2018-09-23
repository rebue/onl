package rebue.onl.ctrl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import rebue.onl.dic.PromotionTypeDic;
import rebue.onl.mo.OnlOnlinePromotionMo;
import rebue.onl.ro.OnlOnlinePromotionRo;
import rebue.onl.svc.OnlOnlinePromotionSvc;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.Ro;

/**
 * 上线推广
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@RestController
public class OnlOnlinePromotionCtrl {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final Logger   _log             = LoggerFactory.getLogger(OnlOnlinePromotionCtrl.class);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Resource
    private OnlOnlinePromotionSvc svc;

    /**
     * 有唯一约束的字段名称
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String                _uniqueFilesName = "某字段内容";

    /**
     * 修改上线推广
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @PutMapping("/onl/onlinepromotion")
    Ro modify(@RequestBody OnlOnlinePromotionMo mo) throws Exception {
        _log.info("modify OnlOnlinePromotionMo:" + mo);
        Ro ro = new Ro();
        try {
            if (svc.modify(mo) == 1) {
                String msg = "修改成功";
                _log.info("{}: mo-{}", msg, mo);
                ro.setMsg(msg);
                ro.setResult(ResultDic.SUCCESS);
                return ro;
            } else {
                String msg = "修改失败";
                _log.error("{}: mo-{}", msg, mo);
                ro.setMsg(msg);
                ro.setResult(ResultDic.FAIL);
                return ro;
            }
        } catch (DuplicateKeyException e) {
            String msg = "修改失败，" + _uniqueFilesName + "已存在，不允许出现重复";
            _log.error("{}: mo-{}", msg, mo);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        } catch (RuntimeException e) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String msg = "修改失败，出现运行时异常(" + sdf.format(new Date()) + ")";
            _log.error("{}: mo-{}", msg, mo);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        }
    }

    /**
     * 查询上线推广
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @GetMapping("/onl/onlinepromotion")
    PageInfo<OnlOnlinePromotionMo> list(OnlOnlinePromotionMo mo, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        _log.info("list OnlOnlinePromotionMo:" + mo + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
        if (pageSize > 50) {
            String msg = "pageSize不能大于50";
            _log.error(msg);
            throw new IllegalArgumentException(msg);
        }
        PageInfo<OnlOnlinePromotionMo> result = svc.list(mo, pageNum, pageSize);
        _log.info("result: " + result);
        return result;
    }

    /**
     * 获取单个上线推广
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @GetMapping("/onl/onlinepromotion/getbyid")
    OnlOnlinePromotionMo getById(@RequestParam("id") java.lang.Long id) {
        _log.info("get OnlOnlinePromotionMo by id: " + id);
        return svc.getById(id);
    }

    /**
     * 添加上线推广 Title: add Description:
     *
     * @param vo
     * @return
     * @throws Exception
     * @date 2018年3月28日 下午4:30:00
     */
    @PostMapping("/onl/onlinepromotion")
    OnlOnlinePromotionRo add(@RequestBody OnlOnlinePromotionMo vo) throws Exception {
        _log.info("开始上线商品推广，添加上线商品推广的参数为：" + vo.toString());
        boolean flag = svc.existSelective(vo);
        _log.info("判断改商品是否已推广：{}", flag);
        OnlOnlinePromotionRo ro = new OnlOnlinePromotionRo();
        if (flag) {
            _log.error("上线编号为：{}，上线商品推广失败", vo.getId());
            ro.setResult((byte) -14);
            ro.setMsg("该商品已推广");
        } else {
            int result = svc.add(vo);
            if (result < 1) {
                _log.error("上线编号为：{}，上线商品推广失败", vo.getId());
                ro.setResult((byte) -1);
                ro.setMsg("推广失败");
            } else {
                _log.info("上线编号为：{}，上线商品推广成功", vo.getId());
                ro.setResult((byte) 1);
                ro.setMsg("推广成功");
            }
        }
        return ro;
    }

    /**
     * 删除上线推广 Title: del Description:
     *
     * @param id
     * @return
     * @date 2018年3月28日 下午4:29:55
     */
    @DeleteMapping("/onl/onlinepromotion")
    OnlOnlinePromotionRo del(@RequestParam("onlineId") java.lang.Long onlineId) {
        _log.info("开始删除上线商品推广，删除上线商品推广的参数为：" + onlineId);
        OnlOnlinePromotionRo ro = new OnlOnlinePromotionRo();
        if (onlineId != 0) {
            int result = svc.del(onlineId);
            if (result < 1) {
                _log.error("推广上线商品编号为：{}，删除上线商品推广失败", onlineId);
                ro.setResult((byte) -1);
                ro.setMsg("取消失败");
            } else {
                _log.info("推广上线商品编号为：{}，删除上线商品推广成功", onlineId);
                ro.setResult((byte) 1);
                ro.setMsg("取消成功");
            }
        } else {
            _log.error("推广上线商品不存在，删除上线商品推广失败", onlineId);
            ro.setResult((byte) -12);
            ro.setMsg("上线推广商品不存在");
        }
        return ro;
    }

    /**
     * 查询上线推广是否存在 Title: existSelective Description:
     *
     * @param vo
     * @return
     * @date 2018年3月28日 下午5:37:01
     */
    @GetMapping("/onl/onlinepromotion/exist")
    boolean existSelective(OnlOnlinePromotionMo vo) {
        return svc.existSelective(vo);
    }

    /**
     * 获取上线的推广活动列表
     * 
     * @param promotionType
     *            {@link PromotionTypeDic}
     *            推广类型（1-每日热门）
     */
    @GetMapping("/onl/onlinepromotion/list")
    List<Map<String, Object>> listOnlinePromotion(@RequestParam("promotionType") PromotionTypeDic promotionType) {
        _log.info("listOnlinePromotion: promotionType={}", promotionType);
        return svc.listOnlinePromotion(promotionType);
    }
}
