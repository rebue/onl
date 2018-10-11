package rebue.onl.ctrl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.github.pagehelper.PageInfo;
import java.io.IOException;
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
import rebue.onl.dic.ModifyOnlineSpecInfoDic;
import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.ro.DeleteCartAndModifyInventoryRo;
import rebue.onl.ro.ModifyOnlineSpecInfoRo;
import rebue.onl.ro.OnlOnlineSpecInfoRo;
import rebue.onl.svc.OnlOnlineSpecSvc;
import rebue.onl.to.DeleteCartAndModifyInventoryTo;
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
            String msg = "添加失败，出现运行时异常(" + sdf.format(new Date()) + ")";
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
        Ro ro = new Ro();
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
    PageInfo<OnlOnlineSpecMo> list(OnlOnlineSpecMo mo, @RequestParam(value = "pageNum", required = false) Integer pageNum, @RequestParam(value = "pageSize", required = false) Integer pageSize) {
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
    List<OnlOnlineSpecInfoRo> selectOnlineSpecInfo(OnlOnlineSpecMo mo) {
        _log.info("获取上线规格信息的参数为：{}", mo.toString());
        return svc.selectOnlineSpecInfo(mo);
    }

    /**
     * 修改上线规格信息 Title: updateSelective Description:
     */
    @PutMapping("/onl/onlinespec")
    Map<String, Object> modify(OnlOnlineSpecMo mo) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            int result = svc.updateSelective(mo);
            _log.info("修改上线规格信息的返回值为：{}", result);
            resultMap.put("result", result);
            resultMap.put("msg", "修改成功");
            return resultMap;
        } catch (RuntimeException e) {
            String msg = e.getMessage();
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
    ModifyOnlineSpecInfoRo modifyOnlineSpecInfo(@RequestBody List<Map<String, Object>> specList) {
        _log.info("查询和修改上线规格信息为：{}", String.valueOf(specList));
        try {
            return svc.modifyOnlineSpecInfo(specList);
        } catch (Exception e) {
            ModifyOnlineSpecInfoRo modifyOnlineSpecInfoRo = new ModifyOnlineSpecInfoRo();
            String msg = e.getMessage();
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

    /**
     * 删除购物车和修改上线数量 Title: deleteCartAndUpdateOnlineCount Description:
     *
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     * @date 2018年4月11日 下午5:52:30
     */
    @PostMapping(value = "/onl/onlinespec/deleteandupdate")
    DeleteCartAndModifyInventoryRo deleteCartAndUpdateOnlineCount(@RequestBody List<DeleteCartAndModifyInventoryTo> list) throws JsonParseException, JsonMappingException, IOException {
        _log.info("删除购物车和修改上线数量的参数为：", String.valueOf(list));
        try {
            return svc.deleteCartAndModifyInventory(list);
        } catch (RuntimeException e) {
        	DeleteCartAndModifyInventoryRo ro = new DeleteCartAndModifyInventoryRo();
            String msg = e.getMessage();
            ro.setMsg(msg);
            if (msg.contains("未上线")) {
                _log.error(msg);
                ro.setResult(-1);
            } else if (msg.contains("购物车中找不到")) {
                _log.error(msg);
                ro.setResult(-2);
            } else if (msg.contains("扣减上线数量失败")) {
                _log.error(msg);
                ro.setResult(-3);
            } else if (msg.equals("删除购物车失败")) {
                _log.error(msg);
                ro.setResult(-4);
            } else if (msg.contains("库存不足")) {
                _log.error(msg);
                ro.setResult(-5);
            } else {
                _log.error(msg);
                ro.setResult(-6);
            }
            return ro;
        }
    }
}
