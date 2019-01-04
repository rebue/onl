package rebue.onl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import rebue.wheel.OkhttpUtils;

/**  
* 创建时间：2018年3月29日 下午2:29:52  
* 项目名称：onl-svr  
* @author daniel  
* @version 1.0   
* @since JDK 1.8  
* 文件名称：OnlCartTest.java  
* 类说明：  购物车测试
*/
public class OnlCartTest {

	private String hostUrl = "http://localhost:9100";
	
	/**
	 * 加入购物车
	 * Title: addCartTest
	 * Description: 
	 * @throws IOException 
	 * @date 2018年3月29日 下午2:31:37
	 */
//	@Test
	public void addCartTest() throws IOException {
		String url = hostUrl + "/onl/cart";
		Map<String, Object> map = new HashMap<String, Object>();
		/*map.put("onlineId", 522191372711755776L);
		map.put("onlineSpecId", 533180675591897100L);
		map.put("userId", 451273803712954379L);
		map.put("cartCount", 1);
		String result = OkhttpUtils.postByFormParams(url, map);
		System.out.println(result);*/
		map = new HashMap<String, Object>();
		map.put("onlineId", 533179911800750080L);
		map.put("onlineSpecId", 533179913663021058L);
		map.put("userId", 451273803712954379L);
		map.put("cartCount", 2);
		String result = OkhttpUtils.postByFormParams(url, map);
		System.out.println(result);
	}
	
	/**
	 * 根据购物车编号删除购物车
	 * Title: deleteCartTest
	 * Description: 
	 * @throws IOException 
	 * @date 2018年3月29日 下午2:52:58
	 */
	/*@Test
	public void deleteCartTest() throws IOException {
		String url = hostUrl + "/onl/cart";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 455576468500643840L);
		map.put("userId", 451273803712954379L);
		System.out.println(map.toString());
		String result = OkhttpUtils.deleteByFormParams(url, map);
		System.out.println(result);
	}*/
	
	/*@Test
	public void selectCartListTest() throws IOException {
		String url = hostUrl + "/onl/cart";
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", "451273803712954379");
		String result = OkhttpUtils.get(url, map);
		System.out.println(result);
	}*/
	
	@Test
	public void test001() {
		BigDecimal bd = BigDecimal.valueOf(11).divide(BigDecimal.valueOf(3));
		System.out.println(bd.setScale(0, BigDecimal.ROUND_HALF_UP));
	}
}
  

