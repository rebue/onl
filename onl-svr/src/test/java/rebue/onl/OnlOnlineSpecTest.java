package rebue.onl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import rebue.wheel.OkhttpUtils;

public class OnlOnlineSpecTest {

    private final String hostUrl = "http://localhost:9101/";

    // @Test
    public void test02() throws IOException {
        final List<Map<String, Object>> list = new ArrayList<>();
        final Map<String, Object>       map  = new HashMap<>();
        map.put("onlineId", 533179911800750080L);
        map.put("specName", "阿萨斯的");
        map.put("buyCount", 2);
        list.add(map);
        System.out.println(list.toString());
        final String result = OkhttpUtils.postByJsonParams(hostUrl + "/onl/onlinespec/selectandupdate", list);
        System.out.println(result);
    }

    @Test
    public void test() throws IOException {
        final String result = OkhttpUtils.get(hostUrl + "/prd/online-spec-es/select-by-name?name=kekou");
        System.out.println(result);
    }
}
