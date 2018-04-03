package rebue.onl.svc.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rebue.onl.mapper.OnlOnlineMapper;
import rebue.onl.mo.OnlOnlineMo;
import rebue.onl.svc.OnlOnlineSvc;

import rebue.robotech.svc.impl.MybatisBaseSvcImpl;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import rebue.onl.mo.OnlOnlinePicMo;
import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.ro.OnlOnlineGoodsInfoRo;
import rebue.onl.svc.OnlOnlinePicSvc;
import rebue.onl.svc.OnlOnlineSpecSvc;

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
public class OnlOnlineSvcImpl extends MybatisBaseSvcImpl<OnlOnlineMo, java.lang.Long, OnlOnlineMapper>
		implements OnlOnlineSvc {

	/**
	 */
	private final static Logger _log = LoggerFactory.getLogger(OnlOnlineSvcImpl.class);
	/**
	 */
	@Resource
	private OnlOnlineSpecSvc onlOnlineSpecSvc;
	/**
	 */
	@Resource
	private OnlOnlinePicSvc onlOnlinePicSvc;

	@Resource
	private OnlOnlineSvc onlOnlineSvc;

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
	 * 商品上线 2018年3月27日10:21:26
	 * 
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@SuppressWarnings({ "unchecked", "null" })
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Map<String, Object> addEx(String onlineInfo) throws JsonParseException, JsonMappingException, IOException {
		JsonParser jsonParser = JsonParserFactory.getJsonParser();
		// 将json字符串转为map类型
		Map<String, Object> onlineMap = jsonParser.parseMap(onlineInfo);
		_log.info("商品上线信息为：{}", onlineMap);
		Map<String, Object> map = new HashMap<String, Object>();
		// 上线ID
		long onlineId = _idWorker.getId();
		// 上线时间
		Date date = new Date();
		/***************************************
		 * 添加上线商品表开始
		 ********************************************/
		OnlOnlineMo oom = new OnlOnlineMo();
		oom.setId(onlineId);
		oom.setOnlineTitle(String.valueOf(onlineMap.get("onlineTitle")));
		oom.setOnlineDetail(String.valueOf(onlineMap.get("onlineDetail")));
		oom.setOnlineState((byte) 1);
		oom.setOnlineTime(date);
		oom.setOpId(Long.parseLong(String.valueOf(onlineMap.get("opId"))));
		long productId = Long.parseLong(String.valueOf(onlineMap.get("produceId")));
		// TODO 扩展有产品表时可去掉此行
		productId = productId == 0 ? onlineId : productId;
		oom.setProduceId(productId);
		_log.info("添加商品上线信息的参数为：{}", oom.toString());
		// 添加上线表
		int addOnlineGoodsResult = add(oom);
		_log.info("添加商品上线信息的返回值为：{}", addOnlineGoodsResult);
		if (addOnlineGoodsResult < 1) {
			_log.warn("添加商品上线信息出错，返回值为：{}", addOnlineGoodsResult);
			map.put("msg", "添加商品上线信息出错");
			map.put("result", -1);
			return map;
		}
		/***************************************
		 * 添加上线商品表结束
		 ********************************************/
		ObjectMapper mapper = new ObjectMapper();
		// 将商品规格信息转为JSON字符串
		String str = mapper.writeValueAsString(onlineMap.get("specs"));
		_log.info("将商品规格信息转为json字符串：{}", str);
		JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, Map.class);
		// 将商品规格JSON字符串转为List<Map>类型
		List<Map<String, Object>> list = (List<Map<String, Object>>) mapper.readValue(str, javaType);
		_log.info("商品规格信息为：{}", list.toString());
		if (list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				/***************************************
				 * 添加上线商品规格表开始
				 ********************************************/
				OnlOnlineSpecMo oosm = new OnlOnlineSpecMo();
				// 规格名称
				String onlineSpec = String.valueOf(list.get(i).get("goodsSpec"));
				// 规格数量
				int saleCount = Integer.parseInt(String.valueOf(list.get(i).get("saleCount")));
				// 规格金额
				BigDecimal salePrice = new BigDecimal(String.valueOf(list.get(i).get("goodsPrice")));
				// 规格返现金
				BigDecimal cashbackAmount = new BigDecimal(String.valueOf(list.get(i).get("cashbackAmount")));
				int seqNo = Integer.parseInt(String.valueOf(list.get(i).get("seqNo")));
				// 规格单位
				String saleUnit = String.valueOf(list.get(i).get("saleUnit"));
				// 规格ID
				long specId = _idWorker.getId();
				oosm.setId(specId);
				oosm.setOnlineId(onlineId);
				oosm.setOnlineSpec(onlineSpec);
				oosm.setSaleCount(saleCount);
				oosm.setSalePrice(salePrice);
				oosm.setSaleUnit(saleUnit);
				oosm.setSeqNo(seqNo);
				oosm.setCashbackAmount(cashbackAmount);
				_log.info("添加上线商品规格信息的参数为：{}", oosm.toString());
				// 添加上线规格表
				int addSpecResult = onlOnlineSpecSvc.add(oosm);
				_log.info("添加上线商品规格信息的返回值为：{}", addSpecResult);
				if (addSpecResult < 1) {
					_log.error("添加上线商品规格信息出错，返回值为：{}", addSpecResult);
					map.put("msg", "添加商品规格信息出错");
					map.put("result", -4);
					return map;
				}
				/***************************************
				 * 添加上线商品规格表结束
				 ********************************************/
			}
		} else {
			_log.error("没有找到商品规格信息，添加商品规格信息出错");
			map.put("msg", "商品规格不能为空");
			map.put("result", -3);
			return map;
		}
		/***************************************
		 * 添加上线商品主图开始
		 ********************************************/
		OnlOnlinePicMo oopm = new OnlOnlinePicMo();
		oopm.setId(_idWorker.getId());
		oopm.setOnlineId(onlineId);
		oopm.setPicPath(String.valueOf(onlineMap.get("goodsQsmm")));
		oopm.setPicType((byte) 1);
		;
		_log.info("添加商品主图的参数为：{}", oopm.toString());
		// 添加上线商品主图片
		int addQsmmResult = onlOnlinePicSvc.add(oopm);
		_log.info("添加商品主图的返回值为：{}", addQsmmResult);
		if (addQsmmResult < 1) {
			_log.error("添加商品主图出错，返回值为：{}", addQsmmResult);
			map.put("msg", "添加商品主图出错");
			map.put("result", -6);
			return map;
		}
		/***************************************
		 * 添加上线商品主图结束
		 ********************************************/

		// 商品轮播图根据逗号切割转为数组
		String[] carouselPics = String.valueOf(onlineMap.get("faceImg")).split(",");
		for (int i = 0; i < carouselPics.length; i++) {
			/***************************************
			 * 添加上线商品轮播图开始
			 ********************************************/
			oopm = new OnlOnlinePicMo();
			oopm.setId(_idWorker.getId());
			oopm.setOnlineId(onlineId);
			oopm.setPicPath(carouselPics[i]);
			oopm.setPicType((byte) 0);
			_log.info("添加商品轮播图的参数为：{}", oopm.toString());
			// 添加上线商品轮播图
			int addCarouselPicResult = onlOnlinePicSvc.add(oopm);
			_log.info("添加商品轮播图的返回值为：{}", addCarouselPicResult);
			if (addCarouselPicResult < 1) {
				_log.error("添加商品轮播图出错，返回值为：", addCarouselPicResult);
				map.put("msg", "添加商品轮播图出错");
				map.put("result", -7);
				return map;
			}
			/***************************************
			 * 添加上线商品轮播图结束
			 ********************************************/
		}
		map.put("msg", "发布成功");
		map.put("result", 1);
		return map;
	}

	/**
	 * 获取上线商品列表 2018年3月29日17:41:26
	 */
	@Override
	public List<OnlOnlineGoodsInfoRo> selectOnlineGoodsList(Map<String, Object> map) {
		return _mapper.selectOnlineGoodsList(map);
	}

	/**
	 * 重新上线
	 * 2018年4月3日11:35:18
	 */
	@Override
	public Map<String, Object> anewOnline(String onlineInfo) throws IOException {
		return onlOnlineSvc.addEx(onlineInfo);
	}

}
