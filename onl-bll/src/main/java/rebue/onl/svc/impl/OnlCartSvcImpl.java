package rebue.onl.svc.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rebue.onl.dic.AddCartDic;
import rebue.onl.mapper.OnlCartMapper;
import rebue.onl.mo.OnlCartMo;
import rebue.onl.ro.AddCartRo;
import rebue.onl.ro.OnlCartRo;
import rebue.onl.svc.OnlCartSvc;
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
public class OnlCartSvcImpl extends MybatisBaseSvcImpl<OnlCartMo, java.lang.Long, OnlCartMapper> implements OnlCartSvc {

    /**
     * @mbg.generated
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(OnlCartMo mo) {
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId() == 0) {
            mo.setId(_idWorker.getId());
        }
        return super.add(mo);
    }

    /**
     */
    private static final Logger _log = LoggerFactory.getLogger(OnlCartSvcImpl.class);

    /**
     *  根据用户编号和购物车编号删除购物车 2018年3月29日15:04:28
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int deleteByUserIdAndCartId(OnlCartMo record) {
        return _mapper.deleteByUserIdAndCartId(record);
    }

    /**
     *  加入购物车 2018年3月30日10:03:51
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public AddCartRo addCart(OnlCartMo mo) {
        List<OnlCartMo> list = _mapper.selectSelective(mo);
        _log.info("查询购物车的返回值为：{}", String.valueOf(list));
        AddCartRo addCartRo = new AddCartRo();
        Date joinTime = new Date();
        mo.setJoinTime(joinTime);
        int result = 0;
        if (list.size() == 0) {
            mo.setId(_idWorker.getId());
            _log.info("加入购物车的参数为：{}", mo);
            result = _mapper.insertSelective(mo);
            _log.info("加入购物车的返回值为：{}", result);
            if (result < 1) {
                _log.error("用户编号为：{}，加入购物车失败", mo.getUserId());
                addCartRo.setResult(AddCartDic.ERROR);
                addCartRo.setMsg("加入购物车失败");
            } else {
                _log.info("用户编号为：{}，加入购物车成功", mo.getUserId());
                addCartRo.setResult(AddCartDic.SUCCESS);
                addCartRo.setMsg("加入购物车成功");
            }
        } else {
            mo.setId(list.get(0).getId());
            mo.setCartCount(mo.getCartCount() + list.get(0).getCartCount());
            _log.info("修改购物车数量的参数为：{}", mo);
            result = _mapper.updateByCondition(mo);
            _log.info("用户修改购物数量的返回值为：{}", result);
            if (result < 1) {
                _log.error("用户编号为：{}，加入购物车失败", mo.getUserId());
                addCartRo.setResult(AddCartDic.ERROR);
                addCartRo.setMsg("加入购物车失败");
            } else {
                _log.info("用户编号为：{}，加入购物车成功", mo.getUserId());
                addCartRo.setResult(AddCartDic.SUCCESS);
                addCartRo.setMsg("加入购物车成功");
            }
        }
        int cartCount = _mapper.selectCartCountByUserId(mo);
        addCartRo.setCartCount(cartCount);
        return addCartRo;
    }

    /**
     *  根据用户编号查询购物车数量 2018年3月30日10:50:26
     */
    @Override
    public int selectCartCount(OnlCartMo mo) {
        _log.info("根据用户编号查询购物车数量的参数为：{}", mo.toString());
        return _mapper.selectCartCountByUserId(mo);
    }

    /**
     *  获取购物车列表 Title: selectCartList Description:
     *
     *  @param mo
     *  @return
     *  @date 2018年3月30日 下午1:54:09
     */
    @Override
    public List<OnlCartRo> selectCartList(OnlCartMo mo) {
        _log.info("获取购物车列表的参数为：{}", mo);
        return _mapper.selectCartList(mo);
    }

    /**
     *  批量删除购物车 2018年4月3日15:27:40
     */
    @Override
    public int deleteByUserIdAndCartIds(Map<String, Object> map) {
        _log.info("批量删除购物车的参数为：{}", String.valueOf(map));
        return _mapper.deleteByUserIdAndCartIds(map);
    }
}
