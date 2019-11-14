package rebue.onl.ctrl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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

import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.ro.OnlOnlineSpecInfoRo;
import rebue.onl.svc.OnlOnlineSpecEsSvc;
import rebue.onl.svc.OnlOnlineSpecSvc;
import rebue.onl.to.ModifySaleCountByIdTo;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.Ro;

/**
 * 上线规格
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@RestController
public class OnlOnlineSpecCtrl {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final Logger _log = LoggerFactory.getLogger(OnlOnlineSpecCtrl.class);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Resource
    private OnlOnlineSpecSvc svc;

    @Resource
    private OnlOnlineSpecEsSvc esSvc;

    /**
     * 有唯一约束的字段名称
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String _uniqueFilesName = "某字段内容";

    /**
     * 添加上线规格
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @PostMapping("/onl/onlinespec")
    Ro add(@RequestBody OnlOnlineSpecMo mo) throws Exception {
        _log.info("add OnlOnlineSpecMo: {}", mo);
        Ro ro = new Ro();
        try {
            int result = svc.add(mo);
            if (result == 1) {
                String msg = "添加成功";
                _log.info("{}: mo-{}", msg, mo);
                ro.setMsg(msg);
                ro.setResult(ResultDic.SUCCESS);
                return ro;
            } else {
                String msg = "添加失败";
                _log.error("{}: mo-{}", msg, mo);
                ro.setMsg(msg);
                ro.setResult(ResultDic.FAIL);
                return ro;
            }
        } catch (DuplicateKeyException e) {
            String msg = "添加失败，" + _uniqueFilesName + "已存在，不允许出现重复";
            _log.error("{}: mo-{}", msg, mo);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        } catch (RuntimeException e) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String           msg = "添加失败，出现运行时异常(" + sdf.format(new Date()) + ")";
            _log.error(msg + ": mo=" + mo, e);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        }
    }

    /**
     * 删除上线规格
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @DeleteMapping("/onl/onlinespec")
    Ro del(@RequestParam("id") java.lang.Long id) {
        _log.info("del OnlOnlineSpecMo by id: {}", id);
        int result = svc.del(id);
        Ro  ro     = new Ro();
        if (result == 1) {
            String msg = "删除成功";
            _log.info("{}: id-{}", msg, id);
            ro.setMsg(msg);
            ro.setResult(ResultDic.SUCCESS);
            return ro;
        } else {
            String msg = "删除失败，找不到该记录";
            _log.error("{}: id-{}", msg, id);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        }
    }

    /**
     * 查询上线规格
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @GetMapping("/onl/onlinespec")
    PageInfo<OnlOnlineSpecMo> list(OnlOnlineSpecMo mo,
            @RequestParam(value = "pageNum", required = false) Integer pageNum,
            @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        if (pageNum == null)
            pageNum = 1;
        if (pageSize == null)
            pageSize = 5;
        _log.info("list OnlOnlineSpecMo:" + mo + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
        if (pageSize > 50) {
            String msg = "pageSize不能大于50";
            _log.error(msg);
            throw new IllegalArgumentException(msg);
        }
        PageInfo<OnlOnlineSpecMo> result = svc.list(mo, pageNum, pageSize);
        _log.info("result: " + result);
        return result;
    }

    /**
     * 获取单个上线规格
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @GetMapping("/onl/onlinespec/getbyid")
    OnlOnlineSpecMo getById(@RequestParam("id") java.lang.Long id) {
        _log.info("get OnlOnlineSpecMo by id: " + id);
        return svc.getById(id);
    }

    /**
     * 获取上线规格信息 Title: selectOnlineSpecInfoByOnlineId Description:
     *
     * @param record
     * @return
     * @date 2018年4月1日 下午4:29:31
     */
    @GetMapping(value = "/onl/onlinespec/details")
    List<OnlOnlineSpecInfoRo> selectOnlineSpecInfo(final OnlOnlineSpecMo mo) {
        _log.info("获取上线规格信息的参数为：{}", mo.toString());
        return svc.selectOnlineSpecInfo(mo);
    }

    /**
     * 修改上线规格信息 Title: updateSelective Description:
     */
    @PutMapping("/onl/onlinespec")
    Map<String, Object> modify(final OnlOnlineSpecMo mo) {
        final Map<String, Object> resultMap = new HashMap<>();
        try {
            final int result = svc.updateSelective(mo);
            _log.info("修改上线规格信息的返回值为：{}", result);
            resultMap.put("result", result);
            resultMap.put("msg", "修改成功");
            return resultMap;
        } catch (final RuntimeException e) {
            final String msg = e.getMessage();
            if (msg.equals("修改上线规格信息失败")) {
                resultMap.put("result", -1);
                resultMap.put("msg", "修改失败");
            }
            e.printStackTrace();
            return resultMap;
        }
    }

    /**
     * 根据上线规格id修改销售数量(减)
     */
    @PutMapping(value = "/onl/onlinespec/modifysalecountbyid")
    Ro modifySaleCountById(ModifySaleCountByIdTo to) {
        _log.info("根据上线规格id修改销售数量（减）的参数为：{}", to);
        try {
            return svc.modifySaleCountById(to);
        } catch (final Exception e) {
            _log.error("根据上线规格id修改销售数量（减）出现异常，{}", e);
            Ro ro = new Ro();
            ro.setResult(ResultDic.FAIL);
            ro.setMsg("修改失败");
            return ro;
        }
    }

    /**
     * 根据上线规格id修改是否已有首单
     *
     * @param id
     * @param isHaveFirstOrder
     * @return
     */
    @PutMapping(value = "/onl/onlinespec/modifyishavefirstorder")
    Ro modifyIsHaveFirstOrderById(@RequestParam("id") Long id,
            @RequestParam("isHaveFirstOrder") Boolean isHaveFirstOrder) {
        _log.info("根据上线规格id修改是否已有首单的参数为：id-{}, isHaveFirstOrder-{}", id, isHaveFirstOrder);
        try {
            return svc.modifyIsHaveFirstOrderById(id, isHaveFirstOrder);
        } catch (Exception e) {
            _log.error("根据上线规格id修改是否已有首单出现异常：{}", e);
            Ro ro = new Ro();
            ro.setResult(ResultDic.FAIL);
            ro.setMsg("出现异常");
            return ro;
        }
    }

    /**
     * 根据条码获取上线规格信息
     * 
     * @param code
     * @return
     */
    @GetMapping(value = "/onl/onlinespec/select-by-code")
    public List<OnlOnlineSpecMo> selectByCode(String code) {
        _log.info("根据条码获取上线规格信息的参数: code-{}", code);
        return svc.selectByCode(code);
    }

    /**
     * 判断搜索类型
     */
    @GetMapping(value = "/onl/online-spec/search")
    public List<OnlOnlineSpecMo> selectBySearch(@RequestParam("onlineSpec") final String onlineSpec) {
        _log.info("搜索的参数: code-{}", onlineSpec);
        String reg = "^\\d{6}$";
        if (onlineSpec.matches(reg)) {
            _log.info("商品名称为6位纯数字,搜索条码");
            return svc.selectByCode(onlineSpec);
        } else {
            _log.info("商品名称不为6位纯数字,搜索商品名称");
            return esSvc.selectByName(onlineSpec);
        }
    }
    
    
    /**
     * 判断搜索类型
     */
    @GetMapping(value = "/onl/online-spec/list")
    public List<OnlOnlineSpecMo> selectOnlineSpec(final OnlOnlineSpecMo mo) {
        _log.info("扫码的参数: code-{}", mo);
       return svc.list(mo);
    }
    
}
