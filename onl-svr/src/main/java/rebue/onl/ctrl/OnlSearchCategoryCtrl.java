package rebue.onl.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import rebue.onl.mo.OnlSearchCategoryMo;
import rebue.onl.ro.OnlSearchCategoryRo;
import rebue.onl.ro.OnlSearchCategoryTreeRo;
import rebue.onl.svc.OnlSearchCategorySvc;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.Ro;

/**
 * 搜索分类
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@RestController
public class OnlSearchCategoryCtrl {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final Logger _log = LoggerFactory.getLogger(OnlSearchCategoryCtrl.class);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Resource
    private OnlSearchCategorySvc svc;

    /**
     * 是否为测试模式（测试模式下不用从cookie中获取用户信息）
     */
    @Value("${debug:false}")
    private Boolean isDebug;

    /**
     * 有唯一约束的字段名称
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String _uniqueFilesName = "某字段内容";

    /**
     * 添加店铺搜索分类
     *
     * @mbg.overrideByMethodName
     */
    @PostMapping("/onl/searchcategory")
    Ro add(@RequestBody OnlSearchCategoryMo mo) throws Exception {
        _log.info("add OnlSearchCategoryMo: {}", mo);
        Ro ro = new Ro();
        try {
            return svc.addEx(mo);
        } catch (DuplicateKeyException e) {
            String msg = "添加失败，" + _uniqueFilesName + "已存在，不允许出现重复";
            _log.error(msg + ": mo-" + mo, e);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        } catch (RuntimeException e) {
            String msg = "添加失败，出现运行时异常";
            _log.error(msg + ": mo-" + mo, e);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        }
    }

    /**
     * 修改店铺搜索分类
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @PutMapping("/onl/searchcategory")
    Ro modify(@RequestBody OnlSearchCategoryMo mo) throws Exception {
        _log.info("modify OnlSearchCategoryMo: {}", mo);
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
            _log.error(msg + ": mo=" + mo, e);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        } catch (RuntimeException e) {
            String msg = "修改失败，出现运行时异常";
            _log.error(msg + ": mo-" + mo, e);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        }
    }

    /**
     * 删除店铺搜索分类
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @DeleteMapping("/onl/searchcategory")
    Ro del(@RequestParam("id") java.lang.Long id) {
        _log.info("del OnlSearchCategoryMo by id: {}", id);
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
     * 获取单个店铺搜索分类
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @GetMapping("/onl/searchcategory/getbyid")
    OnlSearchCategoryMo getById(@RequestParam("id") java.lang.Long id) {
        _log.info("get OnlSearchCategoryMo by id: {}", id);
        return svc.getById(id);
    }

    /**
     * 查询店铺搜索分类
     */
    @GetMapping("/onl/searchcategory")
    PageInfo<OnlSearchCategoryRo> list(OnlSearchCategoryRo ro,
            @RequestParam(value = "pageNum", required = false) Integer pageNum,
            @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        if (pageNum == null)
            pageNum = 1;
        if (pageSize == null)
            pageSize = 5;
        _log.info("list SlrSearchCategoryRo:" + ro + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
        if (pageSize > 50) {
            String msg = "pageSize不能大于50";
            _log.error(msg);
            throw new IllegalArgumentException(msg);
        }
        PageInfo<OnlSearchCategoryRo> result = svc.listEx(ro, pageNum, pageSize);
        _log.info("result: " + result);
        return result;
    }

    /**
     * 禁用/启用店铺搜索分类 注：该方法会禁用/启用该分类和该分类下的所有子分类
     * 
     * @param sellerId 卖家id
     * @param shopId   店铺id
     * @param code     分类编码
     * @return
     */
    @PutMapping("/onl/searchcategory/enable")
    Ro enable(@RequestBody OnlSearchCategoryMo mo) {
        _log.info("禁用/启用店铺搜索分类的请求参数为：{}", mo);
        return svc.enable(mo);
    }

    /**
     * 根据店铺id获取搜索分类树
     * 
     * @param shopId
     * @return
     */
    @GetMapping("/onl/searchcategory/tree")
    List<OnlSearchCategoryTreeRo> searchCategoryTreeList(@RequestParam("shopId") Long shopId) {
        _log.info("根据店铺id获取搜索分类树的参数为：{}", shopId);
        return svc.searchCategoryTreeList(shopId);
    }

    /**
     * 添加搜索分类
     *
     */
    @PostMapping("/onl/addSearchCategory")
    int addSearchCategory(@RequestBody OnlSearchCategoryMo mo) throws Exception {
        _log.info("添加搜索分类 OnlSearchCategoryMo: {}", mo);
        return svc.add(mo);
    }

    /**
     * 根据店铺id和上线id判断该分类是否存在
     * 
     * @param shopId
     * @param onlineId
     * @return
     */
    @GetMapping("/onl/searchcategory/count-by-shopId")
    int countSelectiveByShopId(Long shopId, Long onlineId) {
        _log.info("根据店铺id和上线id判断该分类是否存在:shopId-{},onlineId-{}", shopId, onlineId);
        return svc.countSelectiveByShopId(shopId, onlineId);
    }

    @GetMapping("/onl/searchcategory/get-one-by-name")
    OnlSearchCategoryMo getOneByName(@RequestBody OnlSearchCategoryMo mo) {
        _log.info("getOneByName OnlSearchCategoryMo: {}", mo);
        return svc.getOne(mo);
    }

    /**
     * 根据店铺id获取搜索分类树(不获取产品列表)
     * 
     * @param shopId
     * @return
     */
    @GetMapping("/onl/searchcategory/select-category-tree")
    List<OnlSearchCategoryTreeRo> selectCategoryTreeListByshopId(@RequestParam("shopId") Long shopId) {
        _log.info("根据店铺id获取搜索分类树的参数为(不获取产品列表)：{}", shopId);
        return svc.selectCategoryTreeListByshopId(shopId);
    }

}
