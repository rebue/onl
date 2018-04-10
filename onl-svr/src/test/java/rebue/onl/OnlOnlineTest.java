package rebue.onl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import rebue.wheel.OkhttpUtils;

/**
 * 创建时间：2018年3月27日 下午2:19:01 项目名称：onl-svr
 * 
 * @author daniel
 * @version 1.0
 * @since JDK 1.8 文件名称：OnlOnlineTest.java 
 * 类说明：商品上线、推广测试
 */
public class OnlOnlineTest {

	private String hostUrl = "http://localhost:9100/";
	private ObjectMapper _objectMapper = new ObjectMapper();
	
	/**
	 * 发布商品
	 * Title: selectOnlineTest
	 * Description: 
	 * @throws IOException
	 * @date 2018年3月28日 下午1:24:55
	 */
	@Test
	public void onlineTest() throws JsonParseException, JsonMappingException, IOException {
		String jsondata = "{\"onlineDetail\":\"测试2018年4月10日10:26:29\",\"faceImg\":\"2018/04/10/156787888008000577.jpg,2018/04/10/158206788155000574.jpg\",\"goodsQsmm\":\"2018/04/10/158560550136000048.jpg\",\"produceId\":0,\"specs\":[{\"goodsSpec\":\"规格01\",\"goodsPrice\":\"10\",\"cashbackAmount\":\"5\",\"saleCount\":\"10\",\"seqNo\":\"1\",\"saleUnit\":\"\"}],\"opId\":\"451273803712954379\"}";
		String jsondatas = java.net.URLEncoder.encode(jsondata, "UTF-8");
		Map map = _objectMapper.readValue(jsondata, Map.class);
		System.out.println(String.valueOf(map));
		String url = hostUrl + "/onl/online";
	//	Map m = _objectMapper.readValue(OkhttpUtils.postByFormParams(url, map), Map.class);
		Map m = _objectMapper.readValue(OkhttpUtils.post(url + "?onlineInfo=" + jsondatas), Map.class);
		System.out.println(m.toString());
	}
	
	/**
	 * 获取上线商品
	 * Title: selectOnlineTest
	 * Description: 
	 * @throws IOException
	 * @date 2018年3月28日 下午1:25:19
	 */
	/*@Test
	public void selectOnlineTest() throws IOException {
		String url = hostUrl + "/onl/online?pageNum=" + 2 + "&pageSize=" + 1;
		String list = OkhttpUtils.get(url);
		System.out.println(list);
	}*/
	
	/**
	 * 根据条件查询上线商品规格信息
	 * Title: selectOnlineSpecTest
	 * Description: 
	 * @throws IOException
	 * @date 2018年3月28日 下午3:23:34
	 */
	/*@Test
	public void selectOnlineSpecTest() throws IOException {
		String url = hostUrl + "/onl/onlinespec?pageNum=" + 1 + "&pageSize=" + 5 + "&onlineId=" + "454092105233596416";
		String list = OkhttpUtils.get(url);
		System.out.println(list);
	}*/
	
	/**
	 * 商品下线
	 * Title: updateOnlineTest
	 * Description: 
	 * @throws IOException
	 * @date 2018年3月28日 下午4:30:24
	 */
	/*@Test
	public void updateOnlineTest() throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "454092105233596416");
		map.put("onlineState", 0);
		String url = hostUrl + "/onl/online";
		String result = OkhttpUtils.putByFormParams(url, map);
		System.out.println(result);
	}*/
	
	/**
	 * 上线商品推广
	 * Title: onlineGoodsPromoteTest
	 * Description: 
	 * @throws IOException
	 * @date 2018年3月28日 下午5:38:50
	 */
	/*@Test
	public void onlineGoodsPromoteTest() throws IOException {
		String url = hostUrl + "/onl/onlinepromotion";
		Map<String, Object> map = new HashMap<String, Object>();
		OnlineGoodsPromotionDic item = OnlineGoodsPromotionDic.getItem(2);
		map.put("promotionType", item.getCode());
		map.put("onlineId", "454097686082224128");
		System.out.println(map);
		String result = OkhttpUtils.postByFormParams(url, map);
		System.out.println(result);
	}*/
	
	/**
	 * 判断上线商品是否已推广
	 * Title: selectOnlineGoodsPromoteExist
	 * Description: 
	 * @throws IOException
	 * @date 2018年3月29日 上午8:50:54
	 */
	/*@Test
	public void selectOnlineGoodsPromoteExist() throws IOException {
		String url = hostUrl + "/onl/onlinepromotion/exist";
		Map<String, String> map = new HashMap<String, String>();
		map.put("onlineId", "454092105233596416");
		String result = OkhttpUtils.get(url, map);
		System.out.println(result);
	}*/
	
	/**
	 * 取消上线商品推广
	 * Title: deleteOnlineGoodsPromote
	 * Description: 
	 * @throws IOException
	 * @date 2018年3月29日 上午9:10:53
	 */
	/*@Test
	public void deleteOnlineGoodsPromote() throws IOException {
		String url = hostUrl + "/onl/onlinepromotion/";
		String result = OkhttpUtils.delete(url + "454092105233596416");
		System.out.println(result);
	}*/
	
	/**
	 * 获取上线商品推广列表
	 * Title: selectPromotionOnlineGoodsList
	 * Description: 
	 * @throws IOException
	 * @date 2018年3月29日 下午5:50:53
	 */
	/*@Test
	public void selectPromotionOnlineGoodsList() throws IOException {
		String url = hostUrl + "/onl/onlinepromotion/list";
		String result = OkhttpUtils.get(url);
		System.out.println(result);
	}*/
	
	/**
	 * 获取上线商品列表
	 * Title: selectOnlineGoodsListTest
	 * Description: 
	 * @throws IOException
	 * @date 2018年3月29日 下午5:50:10
	 */
	/*@Test
	public void selectOnlineGoodsListTest() throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("sortname", "oo.ID");
		map.put("sortOrder", "DESC");
		map.put("start", "0");
		map.put("size", "10");
		String result = OkhttpUtils.get(hostUrl + "/onl/online/list", map);
		System.out.println(result);
	}*/
	
	/**
	 * 根据上线编号获取上线详情信息
	 * Title: selectOnlineGoodsDetails
	 * Description: 
	 * @throws IOException
	 * @date 2018年4月1日 下午4:34:17
	 */
	/*@Test
	public void selectOnlineGoodsDetails() throws IOException {
		String result = OkhttpUtils.get(hostUrl + "/onl/online/details?id=" + "454098678299361291");
		System.out.println(result);
	}*/
	
	
	@Test
	public void selectOnlineSpecInfoByOnlineId() throws IOException {
		String result = OkhttpUtils.get(hostUrl + "/onl/onlinespec/details?id=" + "454098678299361291");
		System.out.println(result);
	}
}
