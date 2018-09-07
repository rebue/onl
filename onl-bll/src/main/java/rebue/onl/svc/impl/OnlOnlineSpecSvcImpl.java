package rebue.onl.svc.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rebue.onl.dic.ModifyOnlineSpecInfoDic;
import rebue.onl.mapper.OnlOnlineSpecMapper;
import rebue.onl.mo.OnlOnlineMo;
import rebue.onl.mo.OnlOnlineSpecMo;
import rebue.onl.mo.OnlOnlineSpecOpLogMo;
import rebue.onl.ro.DeleteCartAndModifyInventoryRo;
import rebue.onl.ro.ModifyOnlineSpecInfoRo;
import rebue.onl.ro.OnlOnlineSpecInfoRo;
import rebue.onl.svc.OnlCartSvc;
import rebue.onl.svc.OnlOnlineSpecOpLogSvc;
import rebue.onl.svc.OnlOnlineSpecSvc;
import rebue.onl.svc.OnlOnlineSvc;
import rebue.onl.to.AppendOnlineSpecCountTo;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.Ro;
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
public class OnlOnlineSpecSvcImpl extends MybatisBaseSvcImpl<OnlOnlineSpecMo, java.lang.Long, OnlOnlineSpecMapper>
		implements OnlOnlineSpecSvc {

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
	private OnlOnlineSpecOpLogSvc onlOnlineSpecOpLogSvc;

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
	 * 修改上线规格信息 2018年4月10日14:21:30
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
	 * 删除购物车和修改库存 Title: deleteCartAndModifyInventory Description:
	 *
	 * @param ro
	 * @return
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 * @date 2018年4月11日 下午4:47:53
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Map<String, Object> deleteCartAndModifyInventory(String cartAndSpecInfo)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class,
				DeleteCartAndModifyInventoryRo.class);
		List<DeleteCartAndModifyInventoryRo> list = (List<DeleteCartAndModifyInventoryRo>) mapper
				.readValue(cartAndSpecInfo, javaType);
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
			int updateCount = onlineCount - buyCount;
			if (updateCount < 0) {
				_log.error("规格编号为：{}，库存不足", onlineSpec);
				throw new RuntimeException(onlineSpec + "库存不足");
			}
			onlineSpecMo.setSaleCount(updateCount);
			_log.info("扣减上线数量的参数为：{}", onlineSpecMo);
			int updateCountResult = _mapper.updateSelective(onlineSpecMo);
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
	 * 修改上线规格信息 Title: resultMap Description:
	 *
	 * @param mo
	 * @return
	 * @date 2018年4月23日 下午5:46:50
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
			int updateStockCount = onlineSpecInfoRoList.get(0).getSaleCount()
					+ Integer.parseInt(String.valueOf(specList.get(i).get("buyCount")));
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
	 * 追击追加上线数量
	 * 
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@SuppressWarnings("rawtypes")
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Ro append(AppendOnlineSpecCountTo to) throws JsonParseException, JsonMappingException, IOException {
		_log.info("追加上线数量的请求参数为：{}", to);
		Ro ro = new Ro();
		if (to.getOnlineId() == 0 || to.getAppends().size() == 0) {
			_log.info("追加上线数量时发现参数不全");
			ro.setResult(ResultDic.FAIL);
			ro.setMsg("参数不正确");
			return ro;
		}

		ObjectMapper mapper = new ObjectMapper();
		for (Entry<String, Object> vo : to.getAppends().entrySet()) {
			System.out.println(mapper.writeValueAsString(vo.getValue()));
			Map map = mapper.readValue(mapper.writeValueAsString(vo.getValue()), Map.class);
			int appendCount = Integer.parseInt(map.get("appendCount").toString());
			if (appendCount != 0 && appendCount > 0) {
				AppendOnlineSpecCountTo appendOnlineSpecCountRo = new AppendOnlineSpecCountTo();
				appendOnlineSpecCountRo.setOnlineId(to.getOnlineId());
				appendOnlineSpecCountRo.setOnlineSpecId(Long.parseLong(vo.getKey()));
				appendOnlineSpecCountRo.setOnlineTotal(Integer.parseInt(map.get("alreadyOnlineCount").toString()));
				appendOnlineSpecCountRo.setAppendCount(appendCount);
				_log.info("追加上线数量的参数为：{}", appendOnlineSpecCountRo);
				int appendOnlineCountResult = _mapper.appendOnlineCount(appendOnlineSpecCountRo);
				_log.info("追加上线数量的返回值为：{}", appendOnlineCountResult);
				if (appendOnlineCountResult != 1) {
					_log.info("追加上线数量时出现错误，上线id为：{}", to.getOnlineId());
					throw new RuntimeException("追加上线数量出错");
				}
				
				OnlOnlineSpecOpLogMo onlineSpecOpLogMo = new OnlOnlineSpecOpLogMo();
				onlineSpecOpLogMo.setOnlineId(to.getOnlineId());
				onlineSpecOpLogMo.setOnlineSpecId(Long.parseLong(vo.getKey()));
				onlineSpecOpLogMo.setOpContent("追加上线数量");
				onlineSpecOpLogMo.setOpId(to.getOpId());
				onlineSpecOpLogMo.setOpTime(new Date());
				_log.info("追加上线数量添加操作日志的参数为：{}", onlineSpecOpLogMo);
				int addOpLogResult = onlOnlineSpecOpLogSvc.add(onlineSpecOpLogMo);
				_log.info("追加上线数量添加操作日志的返回值为：{}", addOpLogResult);
				if (addOpLogResult != 1) {
					_log.error("追加上线数量添加操作日志时出错，上线id为：{}", to.getOnlineId());
					throw new RuntimeException("添加操作日志出错");
				}
			}
		}
		_log.info("追加上线数量成功，上线id为：{}", to.getOnlineId());
		ro.setResult(ResultDic.SUCCESS);
		ro.setMsg("追加成功");
		return ro;
	}
}
