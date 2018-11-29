package rebue.onl.svc.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.dozermapper.core.Mapper;

import rebue.onl.dic.ModifyOnlineSpecInfoDic;
import rebue.onl.mapper.OnlOnlineSpecMapper;
import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.ro.ModifyOnlineSpecInfoRo;
import rebue.onl.ro.OnlOnlineSpecInfoRo;
import rebue.onl.svc.OnlCartSvc;
import rebue.onl.svc.OnlOnlineSpecSvc;
import rebue.onl.svc.OnlOnlineSvc;
import rebue.onl.to.OnlOnlineSpecTo;
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
public class OnlOnlineSpecSvcImpl extends MybatisBaseSvcImpl<OnlOnlineSpecMo, java.lang.Long, OnlOnlineSpecMapper> implements OnlOnlineSpecSvc {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(final OnlOnlineSpecMo mo) {
        _log.info("添加上线规格");
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId() == 0) {
            mo.setId(_idWorker.getId());
        }
        return super.add(mo);
    }

    /**
     */
    private static final Logger _log = LoggerFactory.getLogger(OnlOnlineSpecSvcImpl.class);

    /**
     */
    @Resource
    private OnlOnlineSvc        onlOnlineSvc;

    /**
     */
    @Resource
    private OnlCartSvc          onlCartSvc;

    @Resource
    private Mapper              dozerMapper;

    @Resource
    private OnlOnlineSpecSvc    onlOnlineSpecSvc;

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
     * 修改上线规格信息 Title: resultMap Description:
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ModifyOnlineSpecInfoRo modifyOnlineSpecInfo(final List<Map<String, Object>> specList) {
        _log.info("查询和修改上线规格信息的参数为：{}", String.valueOf(specList));
        final ModifyOnlineSpecInfoRo modifyOnlineSpecInfoRo = new ModifyOnlineSpecInfoRo();
        if (specList.size() == 0) {
            _log.info("查询和修改上线规格信息的时候出现参数有误");
            modifyOnlineSpecInfoRo.setResult(ModifyOnlineSpecInfoDic.PARAMETER_IS_WRONG);
            modifyOnlineSpecInfoRo.setMsg("参数有误");
            return modifyOnlineSpecInfoRo;
        }
        for (int i = 0; i < specList.size(); i++) {
            final OnlOnlineSpecMo onlineSpecMo = new OnlOnlineSpecMo();
            onlineSpecMo.setOnlineId(Long.parseLong(String.valueOf(specList.get(i).get("onlineId"))));
            onlineSpecMo.setOnlineSpec(String.valueOf(specList.get(i).get("specName")));
            _log.info("获取上线规格信息的参数为：{}", onlineSpecMo);
            final OnlOnlineSpecMo onlOnlineSpecMo = onlOnlineSpecSvc.getOne(onlineSpecMo);
            _log.info("获取上线规格信息的返回值为：{}", onlOnlineSpecMo);
            if (onlOnlineSpecMo == null) {
                _log.error("查询和修改上线规格信息时出现没有该规格信息");
                modifyOnlineSpecInfoRo.setResult(ModifyOnlineSpecInfoDic.ON_SPEC_INFO);
                modifyOnlineSpecInfoRo.setMsg(specList.get(i).get("specName") + "没有该规格信息");
                return modifyOnlineSpecInfoRo;
            }
            // 新销售数量 = 原销售数量 - 购买数量
            final int updateStockCount = onlOnlineSpecMo.getSaleCount() - Integer.parseInt(String.valueOf(specList.get(i).get("buyCount")));
            onlineSpecMo.setSaleCount(updateStockCount);
            _log.info("修改上线数量的参数为：{}", onlineSpecMo);
            final int updateResult = _mapper.cancelUpdateCount(Long.parseLong(String.valueOf(specList.get(i).get("onlineId"))), String.valueOf(specList.get(i).get("specName")),
                    onlOnlineSpecMo.getSaleCount(), Integer.parseInt(String.valueOf(specList.get(i).get("buyCount"))));
            _log.info("修改上线数量的返回值为：{}", updateResult);
            if (updateResult < 0) {
                _log.error("修改上线数量出错，返回值为：{}", updateResult);
                throw new RuntimeException("修改上线数量出错");
            }
        }
        modifyOnlineSpecInfoRo.setResult(ModifyOnlineSpecInfoDic.SUCCESS);
        modifyOnlineSpecInfoRo.setMsg("修改成功");
        return modifyOnlineSpecInfoRo;
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
        return onlOnlineSpecSvc.existSelective(specMo);
    }

    /**
     * 更新销售数量(购买后)
     * 新销售数量 = 原销售数量 + 购买数量
     * 
     * @param buyCount
     *            购买数量
     * @param onlineSpecId
     *            上线规格ID
     * @param saleCount
     *            原销售数量
     * @return 更新影响的行数，为0表示出现并发问题
     */
    @Override
    public int updateSaleCount(final Integer buyCount, final Long onlineSpecId, final Integer saleCount) {
        return _mapper.updateSaleCount(buyCount, onlineSpecId, saleCount);
    }
}
