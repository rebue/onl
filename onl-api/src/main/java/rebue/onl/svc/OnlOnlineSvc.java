package rebue.onl.svc;

import rebue.robotech.svc.MybatisBaseSvc;
import rebue.onl.mo.OnlOnlineMo;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import rebue.onl.ro.GoodsOnlineRo;
import rebue.onl.ro.OnlOnlineGoodsInfoRo;
import rebue.onl.to.OnlineGoodsListTo;

public interface OnlOnlineSvc extends MybatisBaseSvc<OnlOnlineMo, java.lang.Long> {

	/**
	 * 商品上线 Title: addEx Description:
	 * 
	 * @param onlineInfo
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @date 2018年3月29日 上午11:24:09
	 */
	GoodsOnlineRo goodsOnline(String onlineInfo) throws JsonParseException, JsonMappingException, IOException;

	/**
	 * 获取上线商品列表 Title: selectOnlineGoodsList Description:
	 * 
	 * @return
	 * @date 2018年3月29日 下午5:40:42
	 */
	List<OnlOnlineGoodsInfoRo> selectOnlineGoodsList(OnlineGoodsListTo to);

	/**
	 * 重新上线 Title: anewOnline Description:
	 * 
	 * @param onlineInfo
	 * @return
	 * @throws JsonProcessingException
	 * @throws IOException
	 * @date 2018年4月3日 上午11:12:05
	 */
	GoodsOnlineRo anewOnline(String onlineInfo) throws JsonProcessingException, IOException;

}