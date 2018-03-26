package rebue.onl.svc.impl;


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rebue.onl.mapper.OnlOnlineMapper;
import rebue.onl.mo.OnlOnlineLogMo;
import rebue.onl.mo.OnlOnlineMo;
import rebue.onl.mo.OnlOnlinePicMo;
import rebue.onl.mo.OnlOnlineSpecLogMo;
import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.svc.OnlOnlineLogSvc;
import rebue.onl.svc.OnlOnlinePicSvc;
import rebue.onl.svc.OnlOnlineSpecLogSvc;
import rebue.onl.svc.OnlOnlineSpecSvc;
import rebue.onl.svc.OnlOnlineSvc;
import rebue.onl.to.OnlineGoodsBaseTo;
import rebue.onl.to.OnlineGoodsSpecBaseTo;
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
public class OnlOnlineSvcImpl extends MybatisBaseSvcImpl<OnlOnlineMo, java.lang.Long, OnlOnlineMapper> implements OnlOnlineSvc {
	
	private final static Logger _log = LoggerFactory.getLogger(OnlOnlineSvcImpl.class);
	 
	@Resource
	private OnlOnlineSpecSvc onlOnlineSpecSvc;
	 
	@Resource
	private OnlOnlineLogSvc onlOnlineLogSvc;
	 
	@Resource
	private OnlOnlineSpecLogSvc onlOnlineSpecLogSvc;
	
	@Resource
	private OnlOnlinePicSvc onlOnlinePicSvc;

    /**
     * @mbg.generated
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(OnlOnlineMo mo) {
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId() == 0) {
            mo.setId(_idWorker.getId());
        }
        return super.add(mo);
    }
    
    /**
     * 商品上线
     * 2018年3月27日10:21:26
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Map<String, Object> addEx(OnlineGoodsBaseTo ogb) {
    	Map<String, Object> map = new HashMap<String, Object>();
    	// 上线编号
    	long onlineId = _idWorker.getId();
    	// 当前时间
    	Date date = new Date();
    	
    	// =================添加商品上线开始==================
    	OnlOnlineMo oom = new OnlOnlineMo();
    	oom.setId(onlineId);
    	oom.setOnlineTitle(ogb.getOnlineTitle());
    	oom.setOnlineDetail(ogb.getOnlineDetail());
    	oom.setOnlineState((byte) 1);
    	oom.setOnlineTime(date);
    	_log.info("添加商品上线信息的参数为：{}", oom.toString());
    	// 添加商品上线信息
    	int addOnlineGoodsResult = add(oom);
    	_log.info("添加商品上线信息的返回值为：{}", addOnlineGoodsResult);
    	if (addOnlineGoodsResult < 1) {
    		_log.warn("添加商品上线信息出错，返回值为：{}", addOnlineGoodsResult);
    		map.put("msg", "添加商品上线信息出错");
    		map.put("result", -1);
			return map;
		}
    	// =================添加商品上线结束==================
    	
    	// =================添加商品上线日志开始==================
    	long onlineLogId = _idWorker.getId();
    	OnlOnlineLogMo oolm = new OnlOnlineLogMo();
    	oolm.setId(onlineLogId);
    	oolm.setOnlineId(onlineId);
    	oolm.setOnlineTitle(ogb.getOnlineTitle());
    	oolm.setOpId(ogb.getOpId());
    	oolm.setOpTime(date);
    	_log.info("添加商品上线日志信息的参数为：{}", oolm.toString());
    	int addOnlineLogResult = onlOnlineLogSvc.add(oolm);
    	_log.info("添加商品上线日志信息的返回值为：{}", addOnlineLogResult);
    	if (addOnlineLogResult < 1) {
			_log.warn("添加商品上线日志信息出错，返回值为：{}", addOnlineLogResult);
			map.put("msg", "添加商品上线日志信息出错");
    		map.put("result", -2);
			return map;
		}
    	// =================添加商品上线日志结束==================
    	
    	OnlOnlineSpecMo oosm = new OnlOnlineSpecMo();
    	List<OnlineGoodsSpecBaseTo> list = ogb.getList();
    	if (list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				// 上线规格
				String onlineSpec = list.get(i).getOnlineSpec();
				// 上线数量
				int saleCount = list.get(i).getSaleCount();
				// 上线金额
				BigDecimal salePrice = list.get(i).getSalePrice();
				// 上线返现金额
				BigDecimal cashbackAmount = list.get(i).getCashbackAmount();
				// 规格排序号
				int seqNo = list.get(i).getSeqNo();
				
				// =================添加上线商品规格开始==================
				oosm.setOnlineId(onlineId);
				oosm.setOnlineSpec(onlineSpec);
				oosm.setSaleCount(saleCount);
				oosm.setSalePrice(salePrice);
				oosm.setSaleUnit(list.get(i).getSaleUnit());
				oosm.setSeqNo(seqNo);
				oosm.setCashbackAmount(cashbackAmount);
				_log.info("添加上线商品规格信息的参数为：{}", oosm.toString());
				int addSpecResult = onlOnlineSpecSvc.add(oosm);
				_log.info("添加上线商品规格信息的返回值为：{}", addSpecResult);
				if (addSpecResult < 1) {
					_log.warn("添加上线商品规格信息出错，返回值为：{}", addSpecResult);
					map.put("msg", "添加商品规格信息出错");
		    		map.put("result", -4);
					return map;
				}
				// =================添加上线商品规格结束==================
				
				// =================添加上线商品规格日志开始==================
				OnlOnlineSpecLogMo ooslm = new OnlOnlineSpecLogMo();
				ooslm.setId(_idWorker.getId());
				ooslm.setOnlineLogId(onlineLogId);
				ooslm.setOnlineSpec(onlineSpec);
				ooslm.setSaleCount(saleCount);
				ooslm.setSalePrice(salePrice);
				ooslm.setCashbackAmount(cashbackAmount);
				ooslm.setSeqNo(seqNo);
				_log.info("添加上线商品规格日志的参数为：{}", ooslm.toString());
				int addOnlineSpecLogResult = onlOnlineSpecLogSvc.add(ooslm);
				_log.info("添加上线商品规格日志信息的返回值为：{}", addOnlineSpecLogResult);
				if (addOnlineSpecLogResult < 1) {
					_log.warn("添加上线商品规格日志信息出错，返回值为：{}", addOnlineSpecLogResult);
					map.put("msg", "添加商品规格日志信息出错");
		    		map.put("result", -5);
					return map;
				}
				// =================添加上线商品规格日志结束==================
			}
		} else {
			_log.warn("没有找到商品规格信息，添加商品规格信息出错");
			map.put("msg", "商品规格不能为空");
    		map.put("result", -3);
			return map;
		}
    	
    	// =================添加上线商品主图开始==================
    	OnlOnlinePicMo oopm = new OnlOnlinePicMo();
    	oopm.setId(_idWorker.getId());
    	oopm.setOnlineId(onlineId);
    	oopm.setPicPath(ogb.getGoodsQsmm());
    	oopm.setPicType((byte) 1);;
    	_log.info("添加商品主图的参数为：{}", oopm.toString());
    	int addQsmmResult = onlOnlinePicSvc.add(oopm);
    	_log.info("添加商品主图的返回值为：{}", addQsmmResult);
    	if (addQsmmResult < 1) {
			_log.warn("添加商品主图出错，返回值为：{}", addQsmmResult);
			map.put("msg", "添加商品主图出错");
    		map.put("result", -6);
			return map;
		}
    	// =================添加上线商品主图结束==================
    	
    	// =================添加上线商品轮播图开始==================
    	// 商品轮播图
    	String[] carouselPics = ogb.getFaceImg().split(",");
    	for (int i = 0; i < carouselPics.length; i++) {
			oopm = new OnlOnlinePicMo();
			oopm.setId(_idWorker.getId());
			oopm.setOnlineId(onlineId);
			oopm.setPicPath(carouselPics[i]);
			oopm.setPicType((byte) 0);
			_log.info("添加商品轮播图的参数为：{}", oopm.toString());
			int addCarouselPicResult = onlOnlinePicSvc.add(oopm);
			_log.info("添加商品轮播图的返回值为：{}", addCarouselPicResult);
			if (addCarouselPicResult < 1) {
				_log.warn("添加商品轮播图出错，返回值为：", addCarouselPicResult);
				map.put("msg", "添加商品轮播图出错");
	    		map.put("result", -7);
				return map;
			}
		}
    	// =================添加上线商品轮播图结束==================
    	map.put("msg", "发布成功");
		map.put("result", 1);
    	return map;
    }

}
