package rebue.onl.svc.impl;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rebue.onl.mapper.OnlCartMapper;
import rebue.onl.mo.OnlCartMo;
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

	private final static Logger _log = LoggerFactory.getLogger(OnlCartSvcImpl.class);
	
    /**
     * 根据用户编号和购物车编号删除购物车
     * 2018年3月29日15:04:28
     */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public int deleteByUserIdAndCartId(OnlCartMo record) {
		return _mapper.deleteByUserIdAndCartId(record);
	}

	/**
	 * 加入购物车
	 * 2018年3月30日10:03:51
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Map<String, Object> addEx(OnlCartMo mo){
		// 判断购物车是否已存在
		List<OnlCartMo> list = _mapper.selectSelective(mo);
		_log.info("查询购物车的返回值为：{}", String.valueOf(list));
		Map<String, Object> resultMap = new HashMap<>();
		Date joinTime = new Date();
		mo.setJoinTime(joinTime);
		
		int result = 0;
		if (list.size() == 0) {
            mo.setId(_idWorker.getId());
            _log.info("加入购物车的参数为：{}", mo.toString());
	        result = _mapper.insertSelective(mo);
	        _log.info("加入购物车的返回值为：{}", result);
	        if (result < 1) {
	        	_log.error("用户编号为：{}，加入购物车失败", mo.getUserId());
				resultMap.put("msg", "加入购物车失败");
				resultMap.put("result", result);
			} else {
				_log.info("用户编号为：{}，加入购物车成功", mo.getUserId());
				resultMap.put("msg", "加入购物车成功");
				resultMap.put("result", 1);
			}
		} else {
			mo.setId(list.get(0).getId());
			mo.setCartCount(mo.getCartCount() + list.get(0).getCartCount());
			_log.info("修改购物车数量的参数为：{}", mo.toString());
			result = _mapper.updateByCondition(mo);
			_log.info("用户修改购物数量的返回值为：{}", result);
			if (result < 1) {
				_log.error("用户编号为：{}，加入购物车失败", mo.getUserId());
				resultMap.put("msg", "加入购物车失败");
				resultMap.put("result", result);
			} else {
				_log.info("用户编号为：{}，加入购物车成功", mo.getUserId());
				resultMap.put("msg", "加入购物车成功");
				resultMap.put("result", 1);
			}
		}
		// 获取购物车数量
		int cartCount = _mapper.selectCartCountByUserId(mo);
		resultMap.put("cartCount", cartCount);
		return resultMap;
	}
	
	/**
	 * 根据用户编号查询购物车数量
	 * 2018年3月30日10:50:26
	 */
	@Override
	public int selectCartCount(OnlCartMo mo) {
		return _mapper.selectCartCountByUserId(mo);
	}
	
	/**
	 * 获取购物车列表
	 * Title: selectCartList
	 * Description: 
	 * @param mo
	 * @return
	 * @date 2018年3月30日 下午1:54:09
	 */
	@Override
	public List<OnlCartRo> selectCartList(OnlCartMo mo){
		return _mapper.selectCartList(mo);
	}
}
