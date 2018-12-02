package rebue.onl.svc.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rebue.onl.dic.PromotionTypeDic;
import rebue.onl.mapper.OnlOnlinePromotionMapper;
import rebue.onl.mo.OnlOnlinePromotionMo;
import rebue.onl.svc.OnlOnlinePromotionSvc;
import rebue.robotech.svc.impl.MybatisBaseSvcImpl;

/**
 * 上线推广
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
public class OnlOnlinePromotionSvcImpl extends MybatisBaseSvcImpl<OnlOnlinePromotionMo, java.lang.Long, OnlOnlinePromotionMapper> implements OnlOnlinePromotionSvc {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final Logger _log = LoggerFactory.getLogger(OnlOnlinePromotionSvcImpl.class);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(OnlOnlinePromotionMo mo) {
        _log.info("添加上线推广");
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId() == 0) {
            mo.setId(_idWorker.getId());
        }
        OnlOnlinePromotionMo promotionMo = new OnlOnlinePromotionMo();
        promotionMo.setPromotionType(mo.getPromotionType());
        _log.info("添加上线推广根据类型查询已上线数量的参数为:{}", promotionMo);
        int countSelective = _mapper.countSelective(promotionMo);
        _log.info("添加上线推广根据类型查询已上线数量的返回值为:{}", countSelective);
        if(countSelective > 12) {
        	_log.error("添加上线推广时发现该推广类型的商品已超过限制的数量, 推广类型为:{}", mo.getPromotionType());
        	return -1;
        }
        return super.add(mo);
    }

    /**
     * 获取上线的推广活动列表
     *
     * @param promotionType
     *            {@link PromotionTypeDic}
     *            推广类型（1-每日热门）
     */
    @Override
    public List<Map<String, Object>> listOnlinePromotion(PromotionTypeDic promotionType) {
        _log.info("查询推广上线商品列表: promotionType={}", promotionType);
        List<Map<String, Object>>  result=_mapper.listOnlinePromotion((byte) promotionType.getCode());
        _log.info("查询推广上线商品列表结果为 {}:", result);
        return result;
        
    }
}
