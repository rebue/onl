package rebue.onl.svc.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rebue.onl.mapper.OnlSearchCategoryOnlineMapper;
import rebue.onl.mo.OnlSearchCategoryOnlineMo;
import rebue.onl.ro.OnlOnlineTreeRo;
import rebue.onl.svc.OnlOnlineSvc;
import rebue.onl.svc.OnlSearchCategoryOnlineSvc;
import rebue.robotech.svc.impl.MybatisBaseSvcImpl;

/**
 * 搜索分类上线
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
public class OnlSearchCategoryOnlineSvcImpl extends MybatisBaseSvcImpl<OnlSearchCategoryOnlineMo, java.lang.Long, OnlSearchCategoryOnlineMapper> implements OnlSearchCategoryOnlineSvc {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final Logger _log = LoggerFactory.getLogger(OnlSearchCategoryOnlineSvcImpl.class);
    
    @Resource
    private OnlSearchCategoryOnlineSvc thisSvc;
    
    @Resource
    private OnlOnlineSvc onlOnlineSvc;

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(OnlSearchCategoryOnlineMo mo) {
        _log.info("添加搜索分类上线");
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId() == 0) {
            mo.setId(_idWorker.getId());
        }
        return super.add(mo);
    }
    
    /**
     * 根据搜索分类id获取上线商品树
     * @param searchCategoryId
     * @return
     */
    @Override
    public List<OnlOnlineTreeRo> onlineTreeList(Long searchCategoryId) {
    	_log.info("根据搜索分类id获取上线商品树的参数为：{}", searchCategoryId);
    	List<OnlOnlineTreeRo> list = new ArrayList<OnlOnlineTreeRo>();
    	if (searchCategoryId == null) {
			_log.error("根据搜索分类id获取上线商品树时发现搜索分类id为null");
			return list;
		}
    	
    	OnlSearchCategoryOnlineMo searchCategoryOnlineMo = new OnlSearchCategoryOnlineMo();
    	searchCategoryOnlineMo.setSearchCategoryId(searchCategoryId);
    	_log.info("根据搜索分类id获取上线商品树根据id获取搜索分类上线信息的参数为：{}", searchCategoryOnlineMo);
    	List<OnlSearchCategoryOnlineMo> searchCategoryOnlineList = thisSvc.list(searchCategoryOnlineMo);
    	_log.info("根据搜索分类id获取上线商品树根据id获取搜索分类上线信息的参数为：{}", searchCategoryOnlineList);
    	for (OnlSearchCategoryOnlineMo onlSearchCategoryOnlineMo : searchCategoryOnlineList) {
    		_log.info("根据上线id获取上线商品树的参数为：{}", onlSearchCategoryOnlineMo.getOnlineId());
			OnlOnlineTreeRo onlineTreeRo = onlOnlineSvc.onlineTree(onlSearchCategoryOnlineMo.getOnlineId());
			_log.info("根据上线id获取上线商品树的返回值为：{}", onlineTreeRo);
			if (onlineTreeRo != null && onlineTreeRo.getId() !=null ) {
				list.add(onlineTreeRo);
			}
		}
    	
    	_log.info("根据搜索分类id获取上线商品树的返回值为：{}", list);
    	return list;
    }

	@Override
	public int deleteByOnlineId(OnlSearchCategoryOnlineMo searchCategoryOnlineMo) {
		_log.info("开始根据上线id和搜索分类id删除记录");
		int updateByOnlineIdResult =_mapper.deleteByOnlineId(searchCategoryOnlineMo);
		return updateByOnlineIdResult;
	}
	
	/**
	 * 根据搜索分类id集合查询符合条件搜索上线信息
	 */
	@Override
	public List<OnlSearchCategoryOnlineMo> selectBysearchCategoryIds(String searchCategoryIds) {
		_log.info("根据搜索分类id集合查询所有上线id的参数为-{}",searchCategoryIds);
		return _mapper.selectBysearchCategoryIds(searchCategoryIds);
	}
}
