package rebue.onl.svc.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.dozermapper.core.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import rebue.onl.mapper.OnlSearchCategoryMapper;
import rebue.onl.mo.OnlSearchCategoryMo;
import rebue.onl.mo.OnlSearchCategoryOnlineMo;
import rebue.onl.ro.OnlOnlineTreeRo;
import rebue.onl.ro.OnlSearchCategoryRo;
import rebue.onl.ro.OnlSearchCategoryTreeRo;
import rebue.onl.svc.OnlOnlineSvc;
import rebue.onl.svc.OnlSearchCategoryOnlineSvc;
import rebue.onl.svc.OnlSearchCategorySvc;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.Ro;
import rebue.robotech.svc.impl.MybatisBaseSvcImpl;
import rebue.slr.mo.SlrShopMo;
import rebue.slr.svr.feign.SlrShopSvc;
import rebue.suc.ro.SucOrgRo;
import rebue.suc.svr.feign.SucOrgSvc;
import rebue.wheel.StrUtils;

/**
 * 搜索分类
 *
 * 在单独使用不带任何参数的 @Transactional 注释时， propagation(传播模式)=REQUIRED，readOnly=false，
 * isolation(事务隔离级别)=READ_COMMITTED， 而且事务不会针对受控异常（checked exception）回滚。
 *
 * 注意： 一般是查询的数据库操作，默认设置readOnly=true, propagation=Propagation.SUPPORTS
 * 而涉及到增删改的数据库操作的方法，要设置 readOnly=false, propagation=Propagation.REQUIRED
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
@Service
public class OnlSearchCategorySvcImpl
        extends MybatisBaseSvcImpl<OnlSearchCategoryMo, java.lang.Long, OnlSearchCategoryMapper>
        implements OnlSearchCategorySvc {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final Logger _log = LoggerFactory.getLogger(OnlSearchCategorySvcImpl.class);

    @Resource
    private OnlSearchCategorySvc thisSvc;

    @Resource
    private Mapper dozerMapper;

    @Resource
    private SucOrgSvc sucOrgSvc;

    @Resource
    private SlrShopSvc slrShopSvc;

    @Resource
    private OnlSearchCategoryOnlineSvc onlSearchCategoryOnlineSvc;

    @Resource
    private OnlOnlineSvc onlOnlineSvc;

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(OnlSearchCategoryMo mo) {
        _log.info("添加搜索分类");
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId() == 0) {
            mo.setId(_idWorker.getId());
        }
        return super.add(mo);
    }

    /**
     * 添加店铺搜索分类 流程： 1、判断参数 2、判断code是否为null，如果为null说明为顶级分类，否则为子类
     * 3、如果为顶级分类时，根据卖家和店铺查询分类的数量，如果数量小于10（不包含10）， 则前面补0
     * 4、如果为子类时，根据传过来的code查询该子类下面的分类，如果数量小于10（不包含10）， 则前面补0 5、添加店铺搜索分类
     * 注意：顶级分类为两位数，子类则在父类下面补两位
     * 
     * @param mo
     * @return
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Ro addEx(OnlSearchCategoryMo mo) {
        _log.info("添加店铺搜索分类的参数为：{}", mo);
        Ro ro = new Ro();
        if (mo.getSellerId() == null || mo.getShopId() == null || mo.getName() == null) {
            _log.error("添加店铺搜索分类时出现参数错误，请求的参数为：{}", mo);
            ro.setResult(ResultDic.PARAM_ERROR);
            ro.setMsg("参数错误");
            return ro;
        }

        _log.info("添加店铺搜索分类根据卖家、店铺、分类编码查询分类数量的参数为：sellerId-{}, shopId-{}, code-{}", mo.getSellerId(), mo.getShopId(),
                mo.getCode());
        int count = _mapper.countBySellerAndShopAndCode(mo.getSellerId(), mo.getShopId(), mo.getCode());
        _log.info("添加店铺搜索分类根据卖家、店铺、分类编码查询分类数量的返回值为：{}", count);
        // 分类编码
        String code = StrUtils.padLeft(String.valueOf(count), 2, '0');
        // 如果添加的分类为子类，则先计算子类的code在与父类的code拼接
        if (mo.getCode() != null && !"".equals(mo.getCode())) {
            code = mo.getCode() + code;
        }
        mo.setCode(code);

        _log.info("添加店铺搜索分类的参数为：{}", mo);
        int addResult = thisSvc.add(mo);
        _log.info("添加店铺搜索分类的返回值为：{}", addResult);
        if (addResult != 1) {
            _log.error("添加店铺搜索分类时出现错误，请求的参数为：{}", mo);
            throw new RuntimeException("添加出错");
        }

        _log.info("添加店铺搜索分类成功，请求的参数为：{}", mo);
        ro.setResult(ResultDic.SUCCESS);
        ro.setMsg("添加成功");
        return ro;
    }

    /**
     * 重写查询店铺分类信息
     * 
     * @param ro
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public PageInfo<OnlSearchCategoryRo> listEx(OnlSearchCategoryRo ro, Integer pageNum, Integer pageSize) {
        _log.info("查询店铺分类信息的参数为：SlrSearchCategoryRo-{}, pageNum-{}, pageSize-{}", ro, pageNum, pageSize);
        OnlSearchCategoryMo searchCategoryMo = dozerMapper.map(ro, OnlSearchCategoryMo.class);
        _log.info("查询店铺分类的参数为：{}", searchCategoryMo);
        PageInfo<OnlSearchCategoryMo> doSelectPageInfo = PageHelper.startPage(pageNum, pageSize)
                .doSelectPageInfo(() -> _mapper.selectSelective(searchCategoryMo));
        _log.info("查询店铺分类的返回值为：{}", doSelectPageInfo);
        PageInfo<OnlSearchCategoryRo>  pageInfo  = new PageInfo<>();
        ArrayList<OnlSearchCategoryRo> arrayList = new ArrayList<>();
        for (OnlSearchCategoryMo snlSearchCategoryMo : doSelectPageInfo.getList()) {
            OnlSearchCategoryRo categoryRo = dozerMapper.map(snlSearchCategoryMo, OnlSearchCategoryRo.class);
            _log.info("查询店铺分类查询组织信息的参数为：{}", snlSearchCategoryMo.getSellerId());
            SucOrgRo sucOrgRo = sucOrgSvc.getById(snlSearchCategoryMo.getSellerId());
            _log.info("查询店铺分类查询组织信息的返回值为：{}", sucOrgRo);
            if (sucOrgRo.getResult() == 1) {
                categoryRo.setSellerName(sucOrgRo.getRecord().getName());
            }
            _log.info("查询店铺分类查询店铺信息的参数为：{}", snlSearchCategoryMo.getShopId());
            SlrShopMo slrShopMo = slrShopSvc.getById(snlSearchCategoryMo.getShopId());
            _log.info("查询店铺分类查询店铺信息的返回值为：{}", slrShopMo);
            if (slrShopMo != null) {
                categoryRo.setShopName(slrShopMo.getShopName());
            }
            arrayList.add(categoryRo);
        }
        pageInfo = dozerMapper.map(doSelectPageInfo, PageInfo.class);
        pageInfo.setList(arrayList);
        _log.info("查询店铺分类的返回值为：{}", pageInfo);
        return pageInfo;
    }

    /**
     * 禁用/启用店铺搜索分类 注：该方法会禁用/启用该分类和该分类下的所有子分类
     * 
     * @param sellerId
     *                 卖家id
     * @param shopId
     *                 店铺id
     * @param code
     *                 分类编码
     * @return
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Ro enable(OnlSearchCategoryMo mo) {
        _log.info("禁用/启用店铺搜索分类的参数为：{}", mo);
        Ro ro = new Ro();
        if (mo.getSellerId() == null || mo.getShopId() == null || mo.getCode() == null || mo.getIsEnabled() == null) {
            _log.error("禁用/启用店铺搜索分类时出现参数错误，请求的参数为：sellerId-{}, shopId-{}, code-{}", mo);
            ro.setResult(ResultDic.PARAM_ERROR);
            ro.setMsg("参数错误");
            return ro;
        }

        int enableResult = _mapper.enable(mo.getSellerId(), mo.getShopId(), mo.getCode(), mo.getIsEnabled());
        _log.info("禁用/启用店铺搜索分类的返回值为：{}", enableResult);
        if (enableResult < 0) {
            _log.error("禁用/启用店铺搜索分类时出现错误，请求的参数为：{}", mo);
            ro.setResult(ResultDic.FAIL);
            ro.setMsg("设置失败");
            return ro;
        }

        _log.info("禁用/启用店铺搜索分类成功，请求的参数为：{}", mo);
        ro.setResult(ResultDic.SUCCESS);
        ro.setMsg("设置成功");
        return ro;
    }

    /**
     * 根据店铺id获取搜索分类树
     * 
     * @param shopId
     * @return
     */
    @Override
    public List<OnlSearchCategoryTreeRo> searchCategoryTreeList(Long shopId) {
        _log.info("获取店铺搜索分类树的参数为：{}", shopId);

        List<OnlSearchCategoryTreeRo> searchCategoryTreeList = new ArrayList<OnlSearchCategoryTreeRo>();
        if (shopId == null) {
            _log.error("获取搜索店铺分类树的参数为null, 请求的参数为：{}", shopId);
            return searchCategoryTreeList;
        }

        _log.info("获取店铺搜索分类树获取店铺顶级分类的参数为：{}", shopId);
        List<OnlSearchCategoryMo> shopTopSearchCategoryList = _mapper.selectShopTopSearchCategory(shopId);
        _log.info("获取店铺搜索分类树获取店铺顶级分类的返回值为：{}", String.valueOf(shopTopSearchCategoryList));
        for (OnlSearchCategoryMo onlSearchCategoryMo : shopTopSearchCategoryList) {

            if (onlSearchCategoryMo.getIsEnabled() == true) {
                _log.info("查询并设置子分类与活动列表开始--------------------------------------");

                // 获取子级分类
                OnlSearchCategoryTreeRo categoryTreeRo = new OnlSearchCategoryTreeRo();
                categoryTreeRo.setId(onlSearchCategoryMo.getId());
                categoryTreeRo.setName(onlSearchCategoryMo.getName());

                _log.info("搜索子分类参数是：ShopId()-{} Code()-{}", onlSearchCategoryMo.getShopId(),
                        onlSearchCategoryMo.getCode());
                List<OnlSearchCategoryTreeRo> categoryList = onlCategoryList(onlSearchCategoryMo.getShopId(),
                        onlSearchCategoryMo.getCode());
                _log.info("搜索子分类结果是：{}", categoryList);
                categoryTreeRo.setCategoryList(categoryList);

                searchCategoryTreeList.add(categoryTreeRo);
                _log.info("查询并设置子分类与活动列表结束+++++++++++++++++++++++++++++++++");
            }

        }
        return searchCategoryTreeList;
    }

    /**
     * 根据店铺id和编码获取店铺搜索分类
     * 
     * @param list
     * @param code
     * @return
     */
    public List<OnlSearchCategoryTreeRo> onlCategoryList(Long shopId, String code) {
        _log.info("根据店铺id和编码查询店铺分类的参数为：shopId-{}, code-{}", shopId, code);
        List<OnlSearchCategoryTreeRo> categoryList              = new ArrayList<OnlSearchCategoryTreeRo>();
        List<OnlSearchCategoryMo>     shopSonSearchCategoryList = _mapper.selectShopSonSearchCategory(shopId, code);
        _log.info("根据店铺id和编码查询店铺分类的返回值为：{}", String.valueOf(shopSonSearchCategoryList));
        for (OnlSearchCategoryMo onlSearchCategoryMo : shopSonSearchCategoryList) {
            _log.info("循环查询和设置活动列表开始-------------------------------------------");
            OnlSearchCategoryTreeRo categoryTreeRo = new OnlSearchCategoryTreeRo();
            categoryTreeRo.setId(onlSearchCategoryMo.getId());
            categoryTreeRo.setName(onlSearchCategoryMo.getName());

            // 判断是否还有下一级，有的话就递归调用。
            _log.info("循环查询是否还有下一级的参数为：shpoId-{} code-{}", onlSearchCategoryMo.getShopId(),
                    onlSearchCategoryMo.getCode());
            List<OnlSearchCategoryTreeRo> nextCategoryList = onlCategoryList(onlSearchCategoryMo.getShopId(),
                    onlSearchCategoryMo.getCode());
            _log.info("循环查询是否还有下一级的结果为：nextCategoryList-{}", nextCategoryList);

            // 如果下一级返回的list不是空，那么这里不需要查询活动列表,因为只有最低层才有活动列表和商品列表。
            if (nextCategoryList.size() != 0) {
                categoryTreeRo.setCategoryList(nextCategoryList);
            } else {
                _log.info("根据搜索分类id查询上线商品树信息的参数为：{}", onlSearchCategoryMo.getId());

                List<OnlOnlineTreeRo> activityList = onlSearchCategoryOnlineSvc
                        .onlineTreeList(onlSearchCategoryMo.getId());
                _log.info("根据搜索分类id查询上线商品树信息的返回值为：{}", activityList);

                if (activityList.size() != 0) {
                    categoryTreeRo.setActivityList(activityList);
                }
            }

            categoryList.add(categoryTreeRo);
            _log.info("循环查询和设置活动列表结束+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        _log.info("根据店铺id和编码查询店铺搜索分类的返回值为：{}", categoryList);
        return categoryList;
    }

    /**
     * 根据店铺id集合获取所有搜索分类。
     */
    @Override
    public List<OnlSearchCategoryMo> searchCategoryByshopIds(String shopIds) {
        _log.info("根据店铺id集合所有搜索分参数是：{}", shopIds);
        return _mapper.searchCategoryByshopIds(shopIds);
    }

    /**
     * 根据店铺id和上线id判断该分类是否存在
     */
    @Override
    public int countSelectiveByShopId(Long shopId, Long onlineId) {
        _log.info("根据店铺id和上线id判断该分类是否存在参数是：shopId-{},onlineId-{}", shopId, onlineId);
        return _mapper.countSelectiveByShopId(shopId, onlineId);
    }

    /**
     * 根据店铺id获取搜索分类树(不获取产品列表)
     */
    @Override
    public List<OnlSearchCategoryTreeRo> selectCategoryTreeListByshopId(Long shopId) {
        _log.info("获取店铺搜索分类树的参数为(不获取产品列表)：{}", shopId);

        List<OnlSearchCategoryTreeRo> searchCategoryTreeList = new ArrayList<OnlSearchCategoryTreeRo>();
        if (shopId == null) {
            _log.error("获取搜索店铺分类树的参数为null, 请求的参数为：{}", shopId);
            return searchCategoryTreeList;
        }

        _log.info("获取店铺搜索分类树获取店铺顶级分类的参数为：{}", shopId);
        List<OnlSearchCategoryMo> shopTopSearchCategoryList = _mapper.selectShopTopSearchCategory(shopId);
        _log.info("获取店铺搜索分类树获取店铺顶级分类的返回值为：{}", String.valueOf(shopTopSearchCategoryList));
        for (OnlSearchCategoryMo onlSearchCategoryMo : shopTopSearchCategoryList) {

            if (onlSearchCategoryMo.getIsEnabled() == true) {
                _log.info("查询子分类开始--------------------------------------");

                // 获取子级分类
                OnlSearchCategoryTreeRo categoryTreeRo = new OnlSearchCategoryTreeRo();
                categoryTreeRo.setId(onlSearchCategoryMo.getId());
                categoryTreeRo.setName(onlSearchCategoryMo.getName());

                _log.info("搜索子分类参数是：ShopId()-{} Code()-{}", onlSearchCategoryMo.getShopId(),
                        onlSearchCategoryMo.getCode());
                List<OnlSearchCategoryTreeRo> categoryList = seachOnlCategoryList(onlSearchCategoryMo.getShopId(),
                        onlSearchCategoryMo.getCode());
                _log.info("搜索子分类结果是：{}", categoryList);
                categoryTreeRo.setCategoryList(categoryList);

                searchCategoryTreeList.add(categoryTreeRo);
                _log.info("查询子分类结束+++++++++++++++++++++++++++++++++");
            }

        }
        return searchCategoryTreeList;
    }

    /**
     * 根据店铺id和编码获取店铺搜索分类(不获取产品列表)
     * 
     * @param list
     * @param code
     * @return
     */
    public List<OnlSearchCategoryTreeRo> seachOnlCategoryList(Long shopId, String code) {
        _log.info("根据店铺id和编码查询店铺分类的参数为：shopId-{}, code-{}", shopId, code);
        List<OnlSearchCategoryTreeRo> categoryList              = new ArrayList<OnlSearchCategoryTreeRo>();
        List<OnlSearchCategoryMo>     shopSonSearchCategoryList = _mapper.selectShopSonSearchCategory(shopId, code);
        _log.info("根据店铺id和编码查询店铺分类的返回值为：{}", String.valueOf(shopSonSearchCategoryList));
        for (OnlSearchCategoryMo onlSearchCategoryMo : shopSonSearchCategoryList) {
            _log.info("循环查询子分类开始-------------------------------------------");
            OnlSearchCategoryTreeRo categoryTreeRo = new OnlSearchCategoryTreeRo();
            categoryTreeRo.setId(onlSearchCategoryMo.getId());
            categoryTreeRo.setName(onlSearchCategoryMo.getName());

            // 判断是否还有下一级，有的话就递归调用。
            _log.info("循环查询是否还有下一级的参数为：shpoId-{} code-{}", onlSearchCategoryMo.getShopId(),
                    onlSearchCategoryMo.getCode());
            List<OnlSearchCategoryTreeRo> nextCategoryList = onlCategoryList(onlSearchCategoryMo.getShopId(),
                    onlSearchCategoryMo.getCode());
            _log.info("循环查询是否还有下一级的结果为：nextCategoryList-{}", nextCategoryList);

            if (nextCategoryList.size() != 0) {
                categoryTreeRo.setCategoryList(nextCategoryList);
            } else {
                categoryTreeRo.setActivityList(null);
            }

            categoryList.add(categoryTreeRo);
            _log.info("循环查询子分类结束+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }
        _log.info("根据店铺id和编码查询店铺搜索分类的返回值为：{}", categoryList);
        return categoryList;
    }

    /**
     * 根据上线id获取搜索分类
     */
    @Override
    public List<OnlSearchCategoryTreeRo> getCategoryByOnlineId(Long onlineId, Long shopId) {
        _log.info("根据上线id获取搜索分类的参数为：onlineId-{},shopId-{}", onlineId, shopId);
        List<OnlSearchCategoryTreeRo> searchCategoryTreeList = new ArrayList<OnlSearchCategoryTreeRo>();
        OnlSearchCategoryOnlineMo     searchCategory         = new OnlSearchCategoryOnlineMo();
        searchCategory.setOnlineId(onlineId);
        List<OnlSearchCategoryOnlineMo> categoryList = onlSearchCategoryOnlineSvc.list(searchCategory);
        _log.info("根据上线id获取搜索分类上线的返回值为-{}", categoryList);
        for (OnlSearchCategoryOnlineMo category : categoryList) {
            _log.info("获取搜索分类的参数为：searchCategoryId-{}", category.getSearchCategoryId());
            OnlSearchCategoryMo searchCategoryMo = thisSvc.getById(category.getSearchCategoryId());
            _log.info("获取搜索分类code的返回值为：code-{}", searchCategoryMo.getCode());
            Integer parent = searchCategoryMo.getCode().length() % 2 == 1 ? 3 : 2;

            searchCategoryTreeList.add(getSearchCategoryByCode(searchCategoryMo.getCode(), parent, onlineId, shopId));
        }
        return searchCategoryTreeList;
    }

    private OnlSearchCategoryTreeRo getSearchCategoryByCode(String code, Integer digit, Long onlineId, Long shopId) {
        _log.info("获取搜索分类的code为：code-{},digit-{}", code, digit);
        OnlSearchCategoryTreeRo ro         = new OnlSearchCategoryTreeRo();
        String                  parentCode = code.substring(0, digit);
        _log.info("父搜索分类的code为：code-{}", parentCode);
        OnlSearchCategoryMo searchCategoryCode = new OnlSearchCategoryMo();
        searchCategoryCode.setCode(parentCode);
        searchCategoryCode.setShopId(shopId);
        _log.info("根据父搜索分类查询搜索分类的参数-{}", searchCategoryCode);
        List<OnlSearchCategoryMo> list = thisSvc.list(searchCategoryCode);
        _log.info("根据父搜索分类的code查询搜索分类的返回值：list-{}", list);
        ro = dozerMapper.map(list.get(0), OnlSearchCategoryTreeRo.class);
        if (code.length() == digit) {
            _log.info("查询搜索子分类上线商品的参数：onlineId-{}", onlineId);
            OnlOnlineTreeRo treeRo = onlOnlineSvc.onlineTree(onlineId);
            _log.info("查询搜索子分类上线商品的返回值：onlineId-{}", treeRo);
            List<OnlOnlineTreeRo> activityList = new ArrayList<OnlOnlineTreeRo>();
            activityList.add(treeRo);
            ro.setActivityList(activityList);
        } else {
            List<OnlSearchCategoryTreeRo> categoryList = new ArrayList<OnlSearchCategoryTreeRo>();
            Integer                       newDigit     = digit + 2;
            categoryList.add(getSearchCategoryByCode(code, newDigit, onlineId, shopId));
            ro.setCategoryList(categoryList);
        }

        return ro;
    }
}
