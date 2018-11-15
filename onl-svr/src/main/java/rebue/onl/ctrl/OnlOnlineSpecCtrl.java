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

import rebue.onl.dic.ModifyOnlineSpecInfoDic;
import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.ro.ModifyOnlineSpecInfoRo;
import rebue.onl.ro.OnlOnlineSpecInfoRo;
import rebue.onl.svc.OnlOnlineSpecSvc;
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
    private static final Logger _log             = LoggerFactory.getLogger(OnlOnlineSpecCtrl.class);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Resource
    private OnlOnlineSpecSvc    svc;

    /**
     * 有唯一约束的字段名称
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private final String        _uniqueFilesName = "某字段内容";

    /**
     * 添加上线规格
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @PostMapping("/onl/onlinespec")
    Ro add(@RequestBody final OnlOnlineSpecMo mo) throws Exception {
        _log.info("add OnlOnlineSpecMo: {}", mo);
        final Ro ro = new Ro();
        try {
            final int result = svc.add(mo);
            if (result == 1) {
                final String msg = "添加成功";
                _log.info("{}: mo-{}", msg, mo);
                ro.setMsg(msg);
                ro.setResult(ResultDic.SUCCESS);
                return ro;
            } else {
                final String msg = "添加失败";
                _log.error("{}: mo-{}", msg, mo);
                ro.setMsg(msg);
                ro.setResult(ResultDic.FAIL);
                return ro;
            }
        } catch (final DuplicateKeyException e) {
            final String msg = "添加失败，" + _uniqueFilesName + "已存在，不允许出现重复";
            _log.error("{}: mo-{}", msg, mo);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        } catch (final RuntimeException e) {
            final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            final String msg = "添加失败，出现运行时异常(" + sdf.format(new Date()) + ")";
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
    Ro del(@RequestParam("id") final java.lang.Long id) {
        _log.info("del OnlOnlineSpecMo by id: {}", id);
        final int result = svc.del(id);
        final Ro ro = new Ro();
        if (result == 1) {
            final String msg = "删除成功";
            _log.info("{}: id-{}", msg, id);
            ro.setMsg(msg);
            ro.setResult(ResultDic.SUCCESS);
            return ro;
        } else {
            final String msg = "删除失败，找不到该记录";
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
    PageInfo<OnlOnlineSpecMo> list(final OnlOnlineSpecMo mo, @RequestParam(value = "pageNum", required = false) Integer pageNum,
            @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 5;
        }
        _log.info("list OnlOnlineSpecMo:" + mo + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
        if (pageSize > 50) {
            final String msg = "pageSize不能大于50";
            _log.error(msg);
            throw new IllegalArgumentException(msg);
        }
        final PageInfo<OnlOnlineSpecMo> result = svc.list(mo, pageNum, pageSize);
        _log.info("result: " + result);
        return result;
    }

    /**
     * 获取单个上线规格
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @GetMapping("/onl/onlinespec/getbyid")
    OnlOnlineSpecMo getById(@RequestParam("id") final java.lang.Long id) {
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
     * 查询并修改规格信息 Title: updateSpenInfo Description:
     *
     * @param specList
     * @return
     * @date 2018年4月23日 下午6:17:55
     */
    @PostMapping(value = "/onl/onlinespec/selectandupdate")
    ModifyOnlineSpecInfoRo modifyOnlineSpecInfo(@RequestBody final List<Map<String, Object>> specList) {
        _log.info("查询和修改上线规格信息为：{}", String.valueOf(specList));
        try {
            return svc.modifyOnlineSpecInfo(specList);
        } catch (final Exception e) {
            final ModifyOnlineSpecInfoRo modifyOnlineSpecInfoRo = new ModifyOnlineSpecInfoRo();
            final String msg = e.getMessage();
            if (msg.equals("修改上线数量出错")) {
                modifyOnlineSpecInfoRo.setResult(ModifyOnlineSpecInfoDic.MODIFY_ONLINE_COUNT_ERROR);
                modifyOnlineSpecInfoRo.setMsg(msg);
            } else {
                modifyOnlineSpecInfoRo.setResult(ModifyOnlineSpecInfoDic.ERROR);
                modifyOnlineSpecInfoRo.setMsg("修改失败");
            }
            return modifyOnlineSpecInfoRo;
        }
    }

}
