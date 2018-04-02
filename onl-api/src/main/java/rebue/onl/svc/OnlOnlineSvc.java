package rebue.onl.svc;

import rebue.robotech.svc.MybatisBaseSvc;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import rebue.onl.mo.OnlOnlineMo;
import rebue.onl.ro.OnlOnlineGoodsInfoRo;

public interface OnlOnlineSvc extends MybatisBaseSvc<OnlOnlineMo, java.lang.Long>{

	/**
	 * 商品上线
	 * Title: addEx
	 * Description: 
	 * @param onlineInfo
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @date 2018年3月29日 上午11:24:09
	 */
	Map<String, Object> addEx(String onlineInfo) throws JsonParseException, JsonMappingException, IOException;

	/**
	 * 获取上线商品列表
	 * Title: selectOnlineGoodsList
	 * Description: 
	 * @return
	 * @date 2018年3月29日 下午5:40:42
	 */
	List<OnlOnlineGoodsInfoRo> selectOnlineGoodsList(Map<String, Object> map);
	
}