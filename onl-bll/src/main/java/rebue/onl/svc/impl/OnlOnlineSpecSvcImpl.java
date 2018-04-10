package rebue.onl.svc.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rebue.onl.mapper.OnlOnlineSpecMapper;
import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.svc.OnlOnlineSpecSvc;

import rebue.robotech.svc.impl.MybatisBaseSvcImpl;
import java.util.List;
import rebue.onl.ro.OnlOnlineSpecInfoRo;

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
public class OnlOnlineSpecSvcImpl extends MybatisBaseSvcImpl<OnlOnlineSpecMo, java.lang.Long, OnlOnlineSpecMapper> implements OnlOnlineSpecSvc {

	/**
	 * @mbg.generated
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public int add(OnlOnlineSpecMo mo) {
		// 如果id为空那么自动生成分布式id
		if (mo.getId() == null || mo.getId() == 0) {
			mo.setId(_idWorker.getId());
		}
		return super.add(mo);
	}

	/**
	 * 根据商品规格编号查询商品规格信息 2018年3月29日14:28:59
	 */
	@Override
	public OnlOnlineSpecMo selectByPrimaryKey(Long id) {
		return _mapper.selectByPrimaryKey(id);
	}

	/**
	 * 查询上线规格信息 2018年4月1日16:31:06
	 */
	@Override
	public List<OnlOnlineSpecInfoRo> selectOnlineSpecInfo(OnlOnlineSpecMo record) {
		return _mapper.selectOnlineSpecInfo(record);
	}

	/**
	 * 修改上线规格信息
	 * 2018年4月10日14:21:30
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
}
