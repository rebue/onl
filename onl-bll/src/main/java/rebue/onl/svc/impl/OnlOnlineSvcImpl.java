package rebue.onl.svc.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rebue.onl.dic.GoodsOnlineDic;
import rebue.onl.mapper.OnlOnlineMapper;
import rebue.onl.mo.OnlOnlineMo;
import rebue.onl.svc.OnlOnlineSvc;
import rebue.onl.to.OnlineGoodsListTo;
import rebue.robotech.svc.impl.MybatisBaseSvcImpl;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import rebue.onl.ro.GoodsOnlineRo;
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
	/**
	 */
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
	@SuppressWarnings({ "unchecked" })
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public GoodsOnlineRo goodsOnline(String onlineInfo) throws JsonParseException, JsonMappingException, IOException {
		JsonParser jsonParser = JsonParserFactory.getJsonParser();
		Map<String, Object> onlineMap = jsonParser.parseMap(onlineInfo);
		_log.info("商品上线信息为：{}", onlineMap);
		GoodsOnlineRo goodsOnlineRo = new GoodsOnlineRo();
		long onlineId = _idWorker.getId();
		Date date = new Date();
		OnlOnlineMo oom = new OnlOnlineMo();
		String onlineTitle = String.valueOf(onlineMap.get("onlineTitle"));
		String onlineDetail = String.valueOf(onlineMap.get("onlineDetail"));
		if (onlineTitle == null || onlineTitle.equals("null") || onlineTitle.equals("")) {
			_log.error("商品上线时出现上线标题为空");
			goodsOnlineRo.setResult(GoodsOnlineDic.ONLINE_TITLE_NOT_NULL);
			goodsOnlineRo.setMsg("上线标题不能为空");
			return goodsOnlineRo;
		}
		if (onlineDetail == null || onlineDetail.equals("") || onlineDetail.equals("null")) {
			_log.error("商品上线时出现上线详情为空");
			goodsOnlineRo.setResult(GoodsOnlineDic.ONLINE_DETAIL_NOT_NULL);
			goodsOnlineRo.setMsg("上线详情不能为空");
			return goodsOnlineRo;
		}
		oom.setId(onlineId);
		oom.setOnlineTitle(onlineTitle);
		oom.setOnlineDetail(onlineDetail);
		oom.setOnlineState((byte) 1);
		oom.setOnlineTime(date);
		oom.setOpId(Long.parseLong(String.valueOf(onlineMap.get("opId"))));
		long productId = Long.parseLong(String.valueOf(onlineMap.get("produceId")));
		productId = productId == 0 ? onlineId : productId;
		oom.setProduceId(productId);
		_log.info("判断产品是否已上线的参数为：{}", productId);
		boolean existOnlineResult = _mapper.existOnlineByProduceId(oom);
		_log.info("判断产品是否已上线的返回值为：{}", existOnlineResult);
		if (existOnlineResult) {
			_log.error("商品上线时出现商品已上线");
			goodsOnlineRo.setResult(GoodsOnlineDic.GOODS_ALREADY_ONLINE);
			goodsOnlineRo.setMsg("该商品已上线");
			return goodsOnlineRo;
		}
		_log.info("添加商品上线信息的参数为：{}", oom);
		int addOnlineGoodsResult = add(oom);
		_log.info("添加商品上线信息的返回值为：{}", addOnlineGoodsResult);
		if (addOnlineGoodsResult < 1) {
			_log.error("添加商品上线信息出错，返回值为：{}", addOnlineGoodsResult);
			goodsOnlineRo.setResult(GoodsOnlineDic.ADD_GOODS_ONLINE_ERROR);
			goodsOnlineRo.setMsg("添加商品上线信息出错");
			return goodsOnlineRo;
		}
		ObjectMapper mapper = new ObjectMapper();
		String str = mapper.writeValueAsString(onlineMap.get("specs"));
		_log.info("将商品规格信息转为json字符串：{}", str);
		JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, Map.class);
		List<Map<String, Object>> list = (List<Map<String, Object>>) mapper.readValue(str, javaType);
		_log.info("商品规格信息为：{}", list.toString());
		if (list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				OnlOnlineSpecMo oosm = new OnlOnlineSpecMo();
				String onlineSpec = String.valueOf(list.get(i).get("goodsSpec"));
				int saleCount = Integer.parseInt(String.valueOf(list.get(i).get("saleCount")));
				BigDecimal salePrice = new BigDecimal(String.valueOf(list.get(i).get("goodsPrice")));
				BigDecimal cashbackAmount = new BigDecimal(String.valueOf(list.get(i).get("cashbackAmount")));
				int seqNo = Integer.parseInt(String.valueOf(list.get(i).get("seqNo")));
				String saleUnit = String.valueOf(list.get(i).get("saleUnit"));
				long specId = _idWorker.getId();
				oosm.setId(specId);
				oosm.setOnlineId(onlineId);
				oosm.setOnlineSpec(onlineSpec);
				oosm.setSaleCount(saleCount);
				oosm.setSalePrice(salePrice);
				oosm.setSaleUnit(saleUnit);
				oosm.setSeqNo(seqNo);
				oosm.setCashbackAmount(cashbackAmount);
				_log.info("添加上线商品规格信息的参数为：{}", oosm);
				int addSpecResult = onlOnlineSpecSvc.add(oosm);
				_log.info("添加上线商品规格信息的返回值为：{}", addSpecResult);
				if (addSpecResult < 1) {
					_log.error("添加上线商品规格信息出错，返回值为：{}", addSpecResult);
					throw new RuntimeException("添加商品规格信息出错");
				}
			}
		} else {
			_log.error("没有找到商品规格信息，添加商品规格信息出错");
			throw new RuntimeException("商品规格不能为空");
		}
		OnlOnlinePicMo oopm = new OnlOnlinePicMo();
		oopm.setId(_idWorker.getId());
		oopm.setOnlineId(onlineId);
		oopm.setPicPath(String.valueOf(onlineMap.get("goodsQsmm")));
		oopm.setPicType((byte) 1);
		;
		_log.info("添加商品主图的参数为：{}", oopm);
		int addQsmmResult = onlOnlinePicSvc.add(oopm);
		_log.info("添加商品主图的返回值为：{}", addQsmmResult);
		if (addQsmmResult < 1) {
			_log.error("添加商品主图出错，返回值为：{}", addQsmmResult);
			throw new RuntimeException("添加商品主图出错");
		}
		String[] carouselPics = String.valueOf(onlineMap.get("faceImg")).split(",");
		for (int i = 0; i < carouselPics.length; i++) {
			oopm = new OnlOnlinePicMo();
			oopm.setId(_idWorker.getId());
			oopm.setOnlineId(onlineId);
			oopm.setPicPath(carouselPics[i]);
			oopm.setPicType((byte) 0);
			_log.info("添加商品轮播图的参数为：{}", oopm);
			int addCarouselPicResult = onlOnlinePicSvc.add(oopm);
			_log.info("添加商品轮播图的返回值为：{}", addCarouselPicResult);
			if (addCarouselPicResult < 1) {
				_log.error("添加商品轮播图出错，返回值为：", addCarouselPicResult);
				throw new RuntimeException("添加商品轮播图出错");
			}
		}
		goodsOnlineRo.setResult(GoodsOnlineDic.SUCCESS);
		goodsOnlineRo.setMsg("发布成功");
		return goodsOnlineRo;
	}

	/**
	 * 获取上线商品列表 2018年3月29日17:41:26
	 */
	@Override
	public List<OnlOnlineGoodsInfoRo> selectOnlineGoodsList(OnlineGoodsListTo to) {
		_log.info("==================================================================================================");
		_log.info("最新版本获取上线列表的参数为：", to);
		_log.info("==================================================================================================");
		return _mapper.selectOnlineGoodsList(to);
	}

	/**
	 * 重新上线 2018年4月3日11:35:18
	 */
	@Override
	public GoodsOnlineRo anewOnline(String onlineInfo) throws IOException {
		return onlOnlineSvc.goodsOnline(onlineInfo);
	}

}
