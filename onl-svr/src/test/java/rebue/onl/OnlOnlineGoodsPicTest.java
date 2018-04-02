package rebue.onl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import rebue.wheel.OkhttpUtils;

/**  
* 创建时间：2018年4月1日 下午2:55:49  
* 项目名称：onl-svr  
* @author daniel  
* @version 1.0   
* @since JDK 1.8  
* 文件名称：OnlOnlineGoodsPicTest.java  
* 类说明：  上线商品图片测试类
*/
public class OnlOnlineGoodsPicTest {

	private String hostUrl = "http://localhost:9100";
	
	@Test
	public void selectOnlineGoodsPicTest() throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("onlineId", "454092105233596416");
		map.put("picType", "0");
		String results = OkhttpUtils.get(hostUrl + "/onl/onlinepic", map);
		System.out.println(results);
	}
}
  

