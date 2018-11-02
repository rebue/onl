package rebue.onl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import rebue.onl.to.DeleteCartAndModifyInventoryTo;
import rebue.wheel.OkhttpUtils;

public class OnlOnlineSpecTest {

	private String hostUrl = "http://localhost:9100/";
	
	@Test
	public void test01() throws IOException {
		List<DeleteCartAndModifyInventoryTo> list = new ArrayList<DeleteCartAndModifyInventoryTo>();
		DeleteCartAndModifyInventoryTo inventoryTo = new DeleteCartAndModifyInventoryTo();
		inventoryTo.setOnlineId(533179911800750080L);
		inventoryTo.setOnlineSpec("阿萨斯的");
		inventoryTo.setBuyCount(2);
		inventoryTo.setCartId(533540461516816387L);
		list.add(inventoryTo);
		System.out.println(list.toString());
		String result = OkhttpUtils.postByJsonParams(hostUrl + "/onl/onlinespec/deleteandupdate", list);
		System.out.println(result);
	}
	
	// @Test
	public void test02() throws IOException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("onlineId", 533179911800750080L);
		map.put("specName", "阿萨斯的");
		map.put("buyCount", 2);
		list.add(map);
		System.out.println(list.toString());
		String result = OkhttpUtils.postByJsonParams(hostUrl + "/onl/onlinespec/selectandupdate", list);
		System.out.println(result);
	}
}
