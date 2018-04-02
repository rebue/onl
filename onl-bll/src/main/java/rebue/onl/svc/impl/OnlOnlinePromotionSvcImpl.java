package rebue.onl.svc.impl;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rebue.onl.mapper.OnlOnlinePromotionMapper;
import rebue.onl.mo.OnlOnlinePromotionMo;
import rebue.onl.svc.OnlOnlinePromotionSvc;

import rebue.robotech.svc.impl.MybatisBaseSvcImpl;

@Service
/**
 * <pre>
 * 在单独使用不带任何参数 的 @Transactional 注释时，
 * propagation(传播模式)=REQUIRED，readOnly=false，
 * isolation(事务隔离级别)=READ_COMMITTED，
 * 而且事务不会针对受控异常（checked exception）回滚。
 * 注意：
 * 一般是查询的数据库操作，默认设置readOnly=true, propagation=Propagation.SUPPORTS
 * 而涉及到增删改的数据库操作的方法，要设置 readOnly=false, propagation=Propagation.REQUIRED
 * </pre>
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class OnlOnlinePromotionSvcImpl extends MybatisBaseSvcImpl<OnlOnlinePromotionMo, java.lang.Long, OnlOnlinePromotionMapper> implements OnlOnlinePromotionSvc {

    /**
     * @mbg.generated
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(OnlOnlinePromotionMo mo) {
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId() == 0) {
            mo.setId(_idWorker.getId());
        }
        return super.add(mo);
    }

    /**
     * 获取推广上线商品列表
     * 2018年3月29日11:41:30
     */
    @Override
	public List<Map<String, Object>> promotionOnlineGoodsList() {
		return _mapper.promotionOnlineGoodsList();
	}
}
