package rebue.onl.svc.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rebue.onl.dic.ModifyOnlineSpecInfoDic;
import rebue.onl.mapper.OnlOnlineSpecMapper;
import rebue.onl.mo.OnlOnlineMo;
import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.ro.DeleteCartAndModifyInventoryRo;
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
    public int add(OnlOnlineSpecMo mo) {
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
    private OnlOnlineSvc onlOnlineSvc;

    /**
     */
    @Resource
    private OnlCartSvc onlCartSvc;

    @Resource
    private Mapper dozerMapper;

    /**
     *  根据商品规格编号查询商品规格信息 2018年3月29日14:28:59
     */
    @Override
    public OnlOnlineSpecMo selectByPrimaryKey(Long id) {
        return _mapper.selectByPrimaryKey(id);
    }

    /**
     *  查询上线规格信息 2018年4月1日16:31:06
     */
    @Override
    public List<OnlOnlineSpecInfoRo> selectOnlineSpecInfo(OnlOnlineSpecMo record) {
        return _mapper.selectOnlineSpecInfo(record);
    }

    /**
     *  修改上线规格信息 2018年4月10日14:21:30
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int updateSelective(OnlOnlineSpecMo mo) {
        int updateResult = _mapper.updateSelective(mo);
        if (updateResult < 1) {
            throw new RuntimeException("修改上线规格信息失败");
        }
        return updateResult;
    }

    /**
     *  删除购物车和修改库存 Title: deleteCartAndModifyInventory Description:
     *
     *  @param ro
     *  @return
     *  @throws IOException
     *  @throws JsonMappingException
     *  @throws JsonParseException
     *  @date 2018年4月11日 下午4:47:53
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Map<String, Object> deleteCartAndModifyInventory(String cartAndSpecInfo) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, DeleteCartAndModifyInventoryRo.class);
        List<DeleteCartAndModifyInventoryRo> list = (List<DeleteCartAndModifyInventoryRo>) mapper.readValue(cartAndSpecInfo, javaType);
        _log.info("删除购物车和修改库存的参数为：{}", String.valueOf(list));
        Map<String, Object> resultMap = new HashMap<String, Object>();
        for (int i = 0; i < list.size(); i++) {
            String onlineSpec = list.get(i).getOnlineSpec();
            long onlineId = list.get(i).getOnlineId();
            int buyCount = list.get(i).getBuyCount();
            long cartId = list.get(i).getCartId();
            OnlOnlineMo onlineMo = new OnlOnlineMo();
            onlineMo.setId(onlineId);
            onlineMo.setOnlineState((byte) 1);
            _log.info("查询商品是否已上线的参数为：{}", onlineMo);
            boolean existOnlineResult = onlOnlineSvc.existSelective(onlineMo);
            _log.info("查询商品是否已上线的返回值为：{}", existOnlineResult);
            if (!existOnlineResult) {
                _log.error("{}未上线，下订单失败", onlineSpec);
                throw new RuntimeException(onlineSpec + "未上线");
            }
            boolean existCart = onlCartSvc.existByPrimaryKey(cartId);
            if (!existCart) {
                _log.error("{}不存在购物车", cartId);
                throw new RuntimeException("购物车中找不到" + onlineSpec);
            }
            OnlOnlineSpecMo onlineSpecMo = new OnlOnlineSpecMo();
            onlineSpecMo.setOnlineId(onlineId);
            onlineSpecMo.setOnlineSpec(onlineSpec);
            _log.info("查询上线规格信息的参数为：{}", onlineSpecMo);
            List<OnlOnlineSpecMo> onlineSpecList = _mapper.selectSelective(onlineSpecMo);
            _log.info("查询上线规格信息的返回值为：{}", String.valueOf(onlineSpecList));
            if (onlineSpecList.size() == 0) {
                _log.error("规格编号为：{}，扣减上线数量失败", onlineSpec);
                throw new RuntimeException("扣减上线数量失败");
            }
            int onlineCount = onlineSpecList.get(0).getSaleCount();
            int updateCount = onlineSpecList.get(0).getOnlineTotal() - onlineCount + buyCount;
            if (updateCount < 0) {
                _log.error("规格编号为：{}，库存不足", onlineSpec);
                throw new RuntimeException(onlineSpec + "库存不足");
            }
            OnlOnlineSpecTo onlineSpecTo = dozerMapper.map(onlineSpecMo, OnlOnlineSpecTo.class);
            onlineSpecTo.setBuyCount(buyCount);
            _log.info("扣减上线数量的参数为：{}", onlineSpecTo);
            int updateCountResult = _mapper.updateSaleCount(onlineSpecTo);
            _log.info("扣减上线数量的返回值为{}", updateCountResult);
            if (updateCountResult != 1) {
                _log.error("规格编号为：{}，扣减上线数量失败", onlineSpec);
                throw new RuntimeException(onlineSpec + "扣减上线数量失败");
            }
            _log.info("删除购物车的参数为：{}", cartId);
            int deleteCartResult = onlCartSvc.del(cartId);
            _log.info("删除购物车的返回值为：{}", deleteCartResult);
            if (deleteCartResult != 1) {
                _log.error("购物车编号为：{}，删除购物车失败", cartId);
                throw new RuntimeException("删除购物车失败");
            }
        }
        resultMap.put("result", 1);
        resultMap.put("msg", "删除购物车和修改库存成功");
        return resultMap;
    }

    /**
     *  修改上线规格信息 Title: resultMap Description:
     *
     *  @param mo
     *  @return
     *  @date 2018年4月23日 下午5:46:50
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ModifyOnlineSpecInfoRo modifyOnlineSpecInfo(List<Map<String, Object>> specList) {
        _log.info("查询和修改上线规格信息的参数为：{}", String.valueOf(specList));
        ModifyOnlineSpecInfoRo modifyOnlineSpecInfoRo = new ModifyOnlineSpecInfoRo();
        if (specList.size() == 0) {
            _log.info("查询和修改上线规格信息的时候出现参数有误");
            modifyOnlineSpecInfoRo.setResult(ModifyOnlineSpecInfoDic.PARAMETER_IS_WRONG);
            modifyOnlineSpecInfoRo.setMsg("参数有误");
            return modifyOnlineSpecInfoRo;
        }
        for (int i = 0; i < specList.size(); i++) {
            OnlOnlineSpecMo onlineSpecMo = new OnlOnlineSpecMo();
            onlineSpecMo.setOnlineId(Long.parseLong(String.valueOf(specList.get(i).get("onlineId"))));
            onlineSpecMo.setOnlineSpec(String.valueOf(specList.get(i).get("specName")));
            _log.info("获取上线规格信息的参数为：{}", onlineSpecMo);
            List<OnlOnlineSpecInfoRo> onlineSpecInfoRoList = _mapper.selectOnlineSpecInfo(onlineSpecMo);
            _log.info("获取上线规格信息的返回值为：{}", String.valueOf(onlineSpecInfoRoList));
            if (onlineSpecInfoRoList.size() == 0) {
                _log.error("查询和修改上线规格信息时出现没有该规格信息");
                modifyOnlineSpecInfoRo.setResult(ModifyOnlineSpecInfoDic.ON_SPEC_INFO);
                modifyOnlineSpecInfoRo.setMsg(specList.get(i).get("specName") + "没有该规格信息");
                return modifyOnlineSpecInfoRo;
            }
            int updateStockCount = onlineSpecInfoRoList.get(0).getSaleCount() + Integer.parseInt(String.valueOf(specList.get(i).get("buyCount")));
            onlineSpecMo.setSaleCount(updateStockCount);
            _log.info("修改上线数量的参数为：{}", onlineSpecMo);
            int updateResult = _mapper.updateSelective(onlineSpecMo);
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
     *  修改上线规格信息
     *
     *  @param to
     *  @return
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int updateOnlineSpec(OnlOnlineSpecTo to) {
        _log.info("修改上线规格的参数为：{}", to);
        return _mapper.updateOnlineSpec(to);
    }

    /**
     *  根据规格id批量删除规格信息
     *
     *  @param ids
     *  @return
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int batchDeleteByIds(String ids, Long onlineId) {
        _log.info("根据规格id批量删除规格信息的参数为：{}, onlineId", ids);
        return _mapper.batchDeleteByIds(ids, onlineId);
    }
}
