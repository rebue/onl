package rebue.onl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import rebue.onl.to.AddOnlineTo;
import rebue.onl.to.OnlOnlineSpecTo;
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

	private String hostUrl = "http://localhost:9101/";
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
		String url = hostUrl + "/onl/online";
		Map<String, Object> slideshowMap = new HashMap<>();
		slideshowMap.put("slideshow", "slideshow=/damaiSlideshow/2018/11/08/16/06/84D0945253F8493AB2106C13F19EE92C.png");
		List<Map<String, Object>> slideshowList = new ArrayList<>();
		slideshowList.add(slideshowMap);
		
		List<OnlOnlineSpecTo> onlineSpecList = new ArrayList<>();
		OnlOnlineSpecTo onlineSpecTo = new OnlOnlineSpecTo();
		onlineSpecTo.setOnlineSpec("啊飒飒122");
		onlineSpecTo.setSalePrice(new BigDecimal(123));
		onlineSpecTo.setCostPrice(new BigDecimal(212));
		// 返现金（板块类型为普通返现时需要加）
//		onlineSpecTo.setCashbackAmount(new BigDecimal("121"));
		onlineSpecTo.setSaleUnit("个");
		onlineSpecTo.setCurrentOnlineCount(122);
		onlineSpecList.add(onlineSpecTo);
		
		AddOnlineTo onlineTo = new AddOnlineTo();
		onlineTo.setProductId(0L);
		onlineTo.setOnlineName("阿萨飒飒啊实打实大声道21");
		// 全返商品
		onlineTo.setSubjectType((byte) 1);
		// 普通返现
//		onlineTo.setSubjectType((byte) 0);
		onlineTo.setGoodsQsmm("/damaiQsmm/2018/11/08/16/05/AF7569B9D64B444782860951C64E67B5.png");
		onlineTo.setOnlineDetail("<p>阿斯蒂芬噶水电费刚好是大法官好</p>");
		onlineTo.setOpId(520469568947224576L);
		onlineTo.setSupplierId(532812733012377601L);
		onlineTo.setDeliverOrgId(532812849798578179L);
		onlineTo.setOnlineSpecs(onlineSpecList);
		onlineTo.setSlideshow(slideshowList);
		
		String result = OkhttpUtils.postByJsonParams(url, onlineTo);
		System.out.println(result);
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
