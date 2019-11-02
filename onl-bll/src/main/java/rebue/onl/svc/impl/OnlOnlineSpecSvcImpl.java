package rebue.onl.svc.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.dozermapper.core.Mapper;

import rebue.onl.mapper.OnlOnlineSpecMapper;
import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.ro.OnlOnlineSpecInfoRo;
import rebue.onl.so.OnlOnlineSpecSo;
import rebue.onl.svc.OnlCartSvc;
import rebue.onl.svc.OnlOnlineSpecEsSvc;
import rebue.onl.svc.OnlOnlineSpecSvc;
import rebue.onl.svc.OnlOnlineSvc;
import rebue.onl.to.ModifySaleCountByIdTo;
import rebue.onl.to.OnlOnlineSpecTo;
import rebue.prd.mo.PrdProductSpecCodeMo;
import rebue.prd.svr.feign.PrdProductSpecCodeSvc;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.Ro;
import rebue.robotech.svc.impl.MybatisBaseSvcImpl;

/**
 * 上线规格
 *
 * 在单独使用不带任何参数的 @Transactional 注释时，
 * propagation(传播模式)=REQUIRED，readOnly=false，
 * isolation(事务隔离级别)=READ_COMMITTED，
 * 而且事务不会针对受控异常（checked exception）回滚。
 *
 * 注意：
 * 一般是查询的数据库操作，默认设置readOnly=true, propagation=Propagation.SUPPORTS
 * 而涉及到增删改的数据库操作的方法，要设置 readOnly=false, propagation=Propagation.REQUIRED
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
@Service
public class OnlOnlineSpecSvcImpl extends MybatisBaseSvcImpl<OnlOnlineSpecMo, java.lang.Long, OnlOnlineSpecMapper>
        implements OnlOnlineSpecSvc {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(OnlOnlineSpecMo mo) {
        _log.info("添加上线规格");
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId() == 0) {
            mo.setId(_idWorker.getId());
        }
        return super.add(mo);
    }

    private static final Logger _log = LoggerFactory.getLogger(OnlOnlineSpecSvcImpl.class);

    @Resource
    private OnlOnlineSvc onlOnlineSvc;

    @Resource
    private OnlCartSvc onlCartSvc;

    @Resource
    private Mapper dozerMapper;

    @Resource
    private OnlOnlineSpecSvc thisSvc;

    @Resource
    private OnlOnlineSpecEsSvc onlOnlineSpecEsSvc;

    @Resource
    private PrdProductSpecCodeSvc prdProductSpecCodeSvc;

    /**
     * 根据商品规格编号查询商品规格信息 2018年3月29日14:28:59
     */
    @Override
    public OnlOnlineSpecMo selectByPrimaryKey(final Long id) {
        return _mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询上线规格信息 2018年4月1日16:31:06
     */
    @Override
    public List<OnlOnlineSpecInfoRo> selectOnlineSpecInfo(final OnlOnlineSpecMo record) {
        return _mapper.selectOnlineSpecInfo(record);
    }

    /**
     * 修改上线规格信息
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int updateSelective(final OnlOnlineSpecMo mo) {
        final int updateResult = _mapper.updateSelective(mo);
        if (updateResult < 1) {
            throw new RuntimeException("修改上线规格信息失败");
        }
        return updateResult;
    }

    /**
     * 根据上线规格id修改销售数量(减)
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Ro modifySaleCountById(ModifySaleCountByIdTo to) {
        _log.info("根据上线规格id修改销售数量的参数为：{}", to);
        Ro ro = new Ro();
        if (to.getId() == null || to.getBuyCount() == null) {
            _log.error("根据上线规格id修改销售数量出现参数错误，请求的参数为：{}", to);
            ro.setResult(ResultDic.PARAM_ERROR);
            ro.setMsg("参数错误");
            return ro;
        }
        _log.info("根据上线规格id修改销售数量查询规格信息的参数为：{}", to.getId());
        OnlOnlineSpecMo onlineSpecMo = thisSvc.getById(to.getId());
        _log.info("根据上线规格id修改销售数量查询规格信息的返回值为：{}", onlineSpecMo);
        if (onlineSpecMo == null) {
            _log.error("根据上线规格id修改销售数量时发现没有该规格信息，上线规格id为：{}", to.getId());
            ro.setResult(ResultDic.FAIL);
            ro.setMsg("该上线规格不存在");
            return ro;
        }
        _log.info("根据上线规格id修改销售数量的参数为：{}", to);
        int updateSaleCountBySubtractResult = _mapper.updateSaleCountBySubtract(to.getId(), to.getBuyCount());
        _log.info("根据上线规格id修改销售数量的返回值为：{}", updateSaleCountBySubtractResult);
        if (updateSaleCountBySubtractResult != 1) {
            ro.setResult(ResultDic.FAIL);
            ro.setMsg("修改失败");
            return ro;
        }
        ro.setResult(ResultDic.SUCCESS);
        ro.setMsg("修改成功");
        return ro;
    }

    /**
     * 修改上线规格信息
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int updateOnlineSpec(final OnlOnlineSpecTo to) {
        _log.info("修改上线规格的参数为：{}", to);
        return _mapper.updateOnlineSpec(to);
    }

    /**
     * 根据规格id批量删除规格信息
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int batchDeleteByIds(final String ids, final Long onlineId) {
        _log.info("根据规格id批量删除规格信息的参数为：{}, onlineId", ids);
        return _mapper.batchDeleteByIds(ids, onlineId);
    }

    /**
     * 判断商品规格是否存在
     */
    @Override
    public Boolean existOnlineSpec(final String onlineSpec, final Long onlineId) {
        final OnlOnlineSpecMo specMo = new OnlOnlineSpecMo();
        specMo.setOnlineSpec(onlineSpec);
        specMo.setOnlineId(onlineId);
        return thisSvc.existSelective(specMo);
    }

    /**
     * 更新销售数量(购买后)
     * 新销售数量 = 原销售数量 + 购买数量
     *
     * @param buyCount
     *                     购买数量
     * @param onlineSpecId
     *                     上线规格ID
     * @param saleCount
     *                     原销售数量
     * @return 更新影响的行数，为0表示出现并发问题
     */
    @Override
    public int updateSaleCount(final BigDecimal buyCount, final Long onlineSpecId, final BigDecimal saleCount) {
        return _mapper.updateSaleCount(buyCount, onlineSpecId, saleCount);
    }

    /**
     * 根据上线规格id修改是否已有首单
     * 
     * @param id
     * @param isHaveFirstOrder
     * @return
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Ro modifyIsHaveFirstOrderById(Long id, Boolean isHaveFirstOrder) {
        _log.info("根据上线规格id修改是否已有首单的参数为：id-{}, isHaveFirstOrder-{}", id, isHaveFirstOrder);
        Ro ro = new Ro();
        if (id == null || isHaveFirstOrder == null) {
            _log.error("根据上线规格id修改是否已有首单时出现参数为空，请求的参数为：id-{}, isHaveFirstOrder-{}", id, isHaveFirstOrder);
            ro.setResult(ResultDic.PARAM_ERROR);
            ro.setMsg("参数不正确");
            return ro;
        }
        _log.info("根据上线规格id修改是否已有首单查询上线规格信息的参数为：{}", id);
        OnlOnlineSpecMo onlineSpecMo = thisSvc.getById(id);
        _log.info("根据上线规格id修改是否已有首单查询上线规格信息的返回值为：{}", onlineSpecMo);
        if (onlineSpecMo == null) {
            _log.error("根据上线规格id修改是否已有首单查询上线规格信息时发现没有该规格信息，请求的id为：{}", id);
            ro.setResult(ResultDic.FAIL);
            ro.setMsg("没有发现该规格信息");
            return ro;
        }
        if (onlineSpecMo.getIsHaveFirstOrder() == isHaveFirstOrder) {
            _log.info("根据上线规格id修改是否已有首单时发现需要设置的值与数据库一致，无需修改，请求的参数为：id-{}, isHaveFirstOrder-{}", id, isHaveFirstOrder);
            ro.setResult(ResultDic.SUCCESS);
            ro.setMsg("无需改动，立即返回");
            return ro;
        }
        int result = _mapper.updateIsHaveFirstOrderById(id, isHaveFirstOrder);
        _log.info("根据上线规格id修改是否已有首单的返回值为：{}", result);
        if (result != 1) {
            _log.error("根据上线规格id修改是否已有首单出现错误，请求的参数为：id-{}, isHaveFirstOrder-{}", id, isHaveFirstOrder);
            ro.setResult(ResultDic.FAIL);
            ro.setMsg("修改出现错误");
            return ro;
        }
        _log.info("根据上线规格id修改是否已有首单成功，请求的参数为：id-{}, isHaveFirstOrder-{}", id, isHaveFirstOrder);
        ro.setResult(ResultDic.SUCCESS);
        ro.setMsg("修改成功");
        return ro;
    }

    /**
     * 根据上线id删除ElasticSearch中的上线规格
     */
    @Override
    public void deleteEsByOnlineId(Long onlineId) {
        _log.info("根据上线id删除ElasticSearch中的上线规格的参数为：onlineId-{}", onlineId);
        OnlOnlineSpecMo mo = new OnlOnlineSpecMo();
        mo.setOnlineId(onlineId);
        List<OnlOnlineSpecMo> list = _mapper.selectSelective(mo);
        _log.info("根据上线id查询上线规格的返回值为：list-{}", list);
        for (OnlOnlineSpecMo deleteMo : list) {
            OnlOnlineSpecSo so = onlOnlineSpecEsSvc.getById(deleteMo.getId().toString());
            if (so == null) {
                _log.info("ElasticSearch中没有相应的记录：deleteId-{}", deleteMo.getId());
            } else {
                // 删除elasticSearch中的参数
                onlOnlineSpecEsSvc.del(deleteMo.getId().toString());
            }
        }
    }

    /**
     * 根据条码获取上线规格信息
     */
    @Override
    public List<OnlOnlineSpecMo> selectByCode(String code) {
        List<OnlOnlineSpecMo> list = new ArrayList<OnlOnlineSpecMo>();
        _log.info("根据条码获取产品规格信息的参数为：code-{}", code);
        List<PrdProductSpecCodeMo> codeList = prdProductSpecCodeSvc.selectByCode(code);
        _log.info("根据条码获取产品规格信息的返回值为：codeList-{}", codeList);
        for (PrdProductSpecCodeMo specCode : codeList) {
            OnlOnlineSpecMo mo = new OnlOnlineSpecMo();
            mo.setProductSpecId(specCode.getProductSpecId());
            _log.info("根据产品规格获取上线规格的参数为：mo-{}", mo);
            List<OnlOnlineSpecMo> onlSpec = _mapper.selectSelective(mo);
            _log.info("根据产品规格获取上线规格的返回值为：mo-{}", onlSpec);
            if (onlSpec != null && onlSpec.size() != 0) {
                list.addAll(onlSpec);
            }
        }
        _log.info("根据条码获取上线规格信息：list-{}", list);
        return list;
    }
}
