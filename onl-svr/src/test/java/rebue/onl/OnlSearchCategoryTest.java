package rebue.onl;

import java.io.IOException;

import org.junit.Test;

import rebue.wheel.OkhttpUtils;

public class OnlSearchCategoryTest {

	private final String hostUrl = "http://localhost:9101/";

//	private final ObjectMapper _objectMapper = new ObjectMapper();
	
	@Test
	public void searchCategoryTreeListTest() throws IOException {
		final String url = hostUrl + "/onl/searchcategory/tree?shopId=581703913896542208";
		String result = OkhttpUtils.get(url);
		System.out.println(result);
	}
}
